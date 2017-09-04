package com.jkkc.music;

import android.app.Application;

/**
 * Created by Guan on 2017/8/31.
 */

public class MusicApplication extends Application{

    /***
     * 单例模式
     */
    private static MusicApplication instance;

    @Override
    public void onCreate() {

        super.onCreate();

    }


}
