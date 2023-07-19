package com.example.tdd;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;

public class MainActivityRobot {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    public void enterNumber(String number) {
        Espresso.onView(ViewMatchers.withId(R.id.numberEditText)).perform(ViewActions.typeText(number));
    }

    public void clickSubmitButton() {
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click());
    }
}

