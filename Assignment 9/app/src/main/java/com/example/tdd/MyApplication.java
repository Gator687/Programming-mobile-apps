package com.example.tdd;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication instance;
    private MainActivityRobot mainActivityRobot;
    private SecondActivityRobot secondActivityRobot;
    private ThirdActivityRobot thirdActivityRobot;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mainActivityRobot = new MainActivityRobot();
        secondActivityRobot = new SecondActivityRobot();
        thirdActivityRobot = new ThirdActivityRobot();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public MainActivityRobot getMainActivityRobot() {
        return mainActivityRobot;
    }

    public SecondActivityRobot getSecondActivityRobot() {
        return secondActivityRobot;
    }

    public ThirdActivityRobot getThirdActivityRobot() {
        return thirdActivityRobot;
    }
}
