package com.example.tdd;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MyInstrumentedTest {

    @Test
    public void testActivityFlow() {
        MainActivityRobot mainActivityRobot = new MainActivityRobot();
        SecondActivityRobot secondActivityRobot = new SecondActivityRobot();
        ThirdActivityRobot thirdActivityRobot = new ThirdActivityRobot();

        // Test Activity 1
        mainActivityRobot.enterNumber("5");
        mainActivityRobot.clickSubmitButton();

        // Test Activity 2
        secondActivityRobot.assertItemCount(5);
        secondActivityRobot.clickItem(3);

        // Test Activity 3
        thirdActivityRobot.assertClickedText("Item 3");
    }
}

