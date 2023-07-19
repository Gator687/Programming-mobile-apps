package com.example.tdd;

import androidx.test.espresso.IdlingResource;

import java.util.ArrayList;

public class IntegrationTestApplication extends MyApp {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public ListLoader getListLoader(IdlingResource idlingResource) {
        return new FakeListLoader(idlingResource);
    }

    private static class FakeListLoader extends ListLoader {
        public FakeListLoader(IdlingResource idlingResource) {
            super(idlingResource);
        }

        @Override
        public void loadList(int itemCount, final OnListLoadedListener listener) {
            // Return an empty list immediately
            if (listener != null) {
                listener.onListLoaded(new ArrayList<ItemModel>());
            }
        }

        @Override
        public void cancelLoading() {
            // No-op
        }
    }
}

