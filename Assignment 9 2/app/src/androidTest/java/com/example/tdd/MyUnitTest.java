package com.example.tdd;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

public class MyUnitTest {
    private MainActivityRobot mainActivityRobot;
    private SecondActivityRobot secondActivityRobot;
    private ThirdActivityRobot thirdActivityRobot;

    @Before
    public void setup() {
        MyApplication application = (MyApplication) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
        mainActivityRobot = application.getMainActivityRobot();
        secondActivityRobot = application.getSecondActivityRobot();
        thirdActivityRobot = application.getThirdActivityRobot();
    }

    @Test
    public void testActivityFlow() {
        // Use the robots as needed in your tests
        // ...
    }
}

