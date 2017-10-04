package com.cosmo.arquitecturamvpbase;

import android.app.Application;

import com.cosmo.arquitecturamvpbase.helper.Database;

/**
 * Created by jersonsuaza on 9/30/17.
 */

public class App extends Application {

    public static Database mdb;

    @Override
    public void onCreate() {
        super.onCreate();
        mdb = new Database(this);
        mdb.open();
    }

    @Override
    public void onTerminate() {
        mdb.close();
        super.onTerminate();
    }
}
