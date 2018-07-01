package com.example.lap11799.rxbus;

import android.app.Application;

public class MyApplication extends Application {

    private RxBus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        bus = new RxBus();
    }

    public RxBus bus() {
        return bus;
    }

}