package com.example.tdd;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;

public class SecondActivityRobot {
    @Rule
    public ActivityScenarioRule<SecondActivity> activityScenarioRule = new ActivityScenarioRule<>(SecondActivity.class);

    public void assertItemCount(int count) {
        Espresso.onData(ViewMatchers.anything())
                .inAdapterView(ViewMatchers.withId(R.id.listView))
                .atPosition(count - 1)
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    public void clickItem(int position) {
        Espresso.onData(ViewMatchers.anything())
                .inAdapterView(ViewMatchers.withId(R.id.listView))
                .atPosition(position)
                .perform(ViewActions.click());
    }
}

