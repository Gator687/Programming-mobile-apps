package com.example.tdd;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class TextProviderTest {
    private TextProvider textProvider;

    @Before
    public void setup() {
        Context context = ApplicationProvider.getApplicationContext();
        textProvider = new TextProvider(context);
    }

    @Test
    public void testGetButtonText() {
        String buttonText = textProvider.getButtonText();
        assertEquals("", buttonText);
    }

    @Test
    public void testGetItemText() {
        int position = 0;
        String itemText = textProvider.getItemText(position);
        assertEquals("", itemText);
    }
}

