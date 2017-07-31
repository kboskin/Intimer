package com.example.hp.intimer.recycleviewsetter;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

/**
 * Created by hp on 026 26.07.2017.
 */

public class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener {
    // custom touch listener, to scroll rv
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                rv.getParent().requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
