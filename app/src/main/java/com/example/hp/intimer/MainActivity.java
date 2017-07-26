package com.example.hp.intimer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.andremion.floatingnavigationview.FloatingNavigationView;
import com.example.hp.intimer.recycleviewsetter.Task;
import com.example.hp.intimer.recycleviewsetter.TaskAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Task task;

    private FloatingNavigationView mFloatingNavigationView;

    public List<Task> taskList = new ArrayList<>();
    private RecyclerView recyclerView;
    public  TaskAdapter tAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*startActivity(new Intent(MainActivity.this, SecondActivity.class));*/
                prepareTaskData("jakldsj","asasd" ,  String.valueOf(1));
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        tAdapter = new TaskAdapter(taskList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(tAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void prepareTaskData(String title, String description, String time) {

        task = new Task(title, description, time);
        taskList.add(task);
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tAdapter.notifyItemChanged(taskList.size()-1);
            }
        });

    }

}
