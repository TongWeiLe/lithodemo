package com.test.lithodemo;

import android.app.Application;

import com.facebook.soloader.SoLoader;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.inspector.protocol.module.Inspector;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);
    }
}
