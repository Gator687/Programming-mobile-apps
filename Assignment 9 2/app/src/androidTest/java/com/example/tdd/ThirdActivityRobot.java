package com.example.tdd;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;

public class ThirdActivityRobot {
    @Rule
    public ActivityScenarioRule<ThirdActivity> activityScenarioRule = new ActivityScenarioRule<>(ThirdActivity.class);

    public void assertClickedText(String text) {
        Espresso.onView(ViewMatchers.withId(R.id.textView))
                .check(ViewAssertions.matches(ViewMatchers.withText("You clicked " + text)));
    }
}

