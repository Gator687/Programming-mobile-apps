package com.example.tdd;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.test.espresso.IdlingResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class UiTestApplication extends Application {
    private ListLoader listLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        listLoader = new FakeListLoader();
    }

    @Override
    public ListLoader getListLoader(IdlingResource idlingResource) {
        return listLoader;
    }

    private static class FakeListLoader extends ListLoader {
        private Timer timer;

        public FakeListLoader() {
            super(null); // No need for IdlingResource in fake implementation
        }

        @Override
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

        @Override
        public void cancelLoading() {
            if (timer != null) {
                timer.cancel();
                timer = null;
            }
        }
    }
}

