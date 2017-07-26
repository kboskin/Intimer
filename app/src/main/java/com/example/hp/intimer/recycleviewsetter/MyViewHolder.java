package com.example.hp.intimer.recycleviewsetter;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hp.intimer.R;

import java.util.concurrent.TimeUnit;

/**
 * Created by hp on 021 21.07.2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    private long timeCountInMilliSeconds = 1 * 60000;

    private enum TimerStatus {
        STARTED,
        STOPPED
    }

    public TextView title;
    private TimerStatus timerStatus = TimerStatus.STOPPED;
    private ProgressBar progressBarCV;
    public TextView textViewTimeCV;
    private CountDownTimer countDownTimer;
    private Handler handler;

    public MyViewHolder(View view) {
        super(view);

        initViews(view);
    }

    private void initViews(View view) {
        title = (TextView) view.findViewById(R.id.title);
        progressBarCV = (ProgressBar) view.findViewById(R.id.progressBarCV);
        textViewTimeCV = (TextView) view.findViewById(R.id.textViewTimeCV);
    }

    public void startStop(String minutes) {
        if (timerStatus == TimerStatus.STOPPED) {


            // call to initialize the timer values
            setTimerValues(minutes);
            // call to initialize the progress bar values
            setProgressBarValues();
            // changing the timer status to started
            timerStatus = TimerStatus.STARTED;
            // call to start the count down timer
            startCountDownTimer();

        } else {

            // changing the timer status to stopped
            timerStatus = TimerStatus.STOPPED;
            stopCountDownTimer();
        }
    }

    private void setTimerValues(String minutes) {
        int time = 0;
        if (!minutes.isEmpty() || Integer.parseInt(minutes) != 0) {

            time = Integer.parseInt(minutes);
        }

        // assigning values after converting to milliseconds
        timeCountInMilliSeconds = time * 60 * 1000;
    }

    private void startCountDownTimer() {
        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textViewTimeCV.setText(hmsTimeFormatter(millisUntilFinished));

                progressBarCV.setProgress((int) (millisUntilFinished / 1000));


            }

            @Override
            public void onFinish() {

                textViewTimeCV.setText(hmsTimeFormatter(timeCountInMilliSeconds));
                // call to initialize the progress bar values
                setProgressBarValues();
                // changing the timer status to stopped
                timerStatus = TimerStatus.STOPPED;
            }

        }.start();
    }

    private void stopCountDownTimer() {
        countDownTimer.cancel();
    }

    private void setProgressBarValues() {

        progressBarCV.setMax((int) timeCountInMilliSeconds / 1000);
        progressBarCV.setProgress((int) timeCountInMilliSeconds / 1000);
    }

    private String hmsTimeFormatter(long milliSeconds) {

        String hms = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));

        return hms;
    }
}
