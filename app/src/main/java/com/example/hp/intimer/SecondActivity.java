package com.example.hp.intimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.intimer.recycleviewsetter.Task;

import static com.example.hp.intimer.MainActivity.tAdapter;
import static com.example.hp.intimer.MainActivity.taskList;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    Task task;

    private long timeCountInMilliSeconds = 1 * 60000;

    private enum TimerStatus {
        STARTED,
        STOPPED
    }

    private TimerStatus timerStatus = TimerStatus.STOPPED;

    private ProgressBar progressBarCircle;
    private EditText editTextMinute;
    private TextView textViewTime;
    private ImageView imageViewReset;
    private ImageView imageViewStartStop;
    private CountDownTimer countDownTimer;
    private EditText editTextTitle;

    private String title;
    private String minutes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // method call to initialize the views
        initViews();
        // method call to initialize the listeners
        initListeners();

    }

    /**
     * method to initialize the views
     */
    private void initViews() {
        progressBarCircle = (ProgressBar) findViewById(R.id.progressBarCircle);
        editTextMinute = (EditText) findViewById(R.id.editTextMinute);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        imageViewStartStop = (ImageView) findViewById(R.id.imageViewStartStop);
        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
    }

    /**
     * method to initialize the click listeners
     */
    private void initListeners() {
        imageViewStartStop.setOnClickListener(this);
    }

    /**
     * implemented method to listen clicks
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageViewStartStop:
                prepareTaskData(title, null, minutes);

                break;
        }
    }


    private void prepareTaskData(String title, String description, String time) {

        time = editTextMinute.getText().toString().trim();
        // fetching minutes for Task obj
        minutes = editTextMinute.getText().toString();
        // fetching value from edit text and type cast to string
        title = editTextTitle.getText().toString();
        // toast message to fill edit text
        if(minutes.isEmpty() || minutes == null || minutes == String.valueOf(0) ||  title.isEmpty() )
        {
            Toast.makeText(getApplicationContext(), getString(R.string.message_minutes_or_title), Toast.LENGTH_LONG).show();
        }
        else
        {
            task = new Task(title, description, time);
            taskList.add(task);
            tAdapter.notifyItemChanged(taskList.size() - 1);
            finish();
        }
    }
}
