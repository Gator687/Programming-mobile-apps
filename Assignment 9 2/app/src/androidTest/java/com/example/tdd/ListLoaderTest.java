package com.example.tdd;

import androidx.test.espresso.IdlingResource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ListLoaderTest {
    @Mock
    private IdlingResource idlingResource;

    private ListLoader listLoader;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        listLoader = new ListLoader(idlingResource);
    }

    @Test
    public void testLoadList() {
        ListLoader.OnListLoadedListener listener = mock(ListLoader.OnListLoadedListener.class);
        listLoader.loadList(5, listener);

        // Add your assertions or verify method calls here
    }

    @Test
    public void testCancelLoading() {
        listLoader.cancelLoading();

        // Add your assertions or verify method calls here
    }
}

