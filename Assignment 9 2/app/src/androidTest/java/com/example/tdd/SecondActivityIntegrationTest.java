package com.example.tdd;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class SecondActivityIntegrationTest {
    @Rule
    public ActivityTestRule<SecondActivity> activityRule = new ActivityTestRule<>(SecondActivity.class);

    @Before
    public void setup() {
        Intents.init();
    }

    @After
    public void teardown() {
        Intents.release();
    }

    @Test
    public void testItemSelectedInThirdActivity() {
        onData(allOf(is(instanceOf(String.class)), is("Item 3")))
                .inAdapterView(withId(R.id.listView))
                .atPosition(2)
                .perform(click());

        intended(allOf(
                hasComponent(ThirdActivity.class.getName()),
                hasExtra("selectedItem", equalTo("Item 3"))
        ));
    }
}

