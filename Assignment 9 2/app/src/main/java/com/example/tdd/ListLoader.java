package com.example.tdd;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import androidx.test.espresso.IdlingResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ListLoader {
    private Timer timer;
    private IdlingResource idlingResource;

    public ListLoader(IdlingResource idlingResource) {
        this.idlingResource = idlingResource;
    }

    public void loadList(int itemCount, final OnListLoadedListener listener) {
        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                final List<ItemModel> itemList = new ArrayList<>();
                for (int i = 0; i < itemCount; i++) {
                    itemList.add(new ItemModel("Item " + i));
                }

                SystemClock.sleep(1000);

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        if (listener != null) {
                            listener.onListLoaded(itemList);
                        }
                    }
                });
            }
        }, 0);
    }

    public void cancelLoading() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public interface OnListLoadedListener {
        void onListLoaded(List<ItemModel> itemList);
    }
}


