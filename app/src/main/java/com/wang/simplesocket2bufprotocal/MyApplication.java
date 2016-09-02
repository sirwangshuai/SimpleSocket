/**
 * Copyright (C)  2016 深圳市狗尾草智能科技有限公司
 * SimpleSocket2Bufprotocal
 * MyApplication.java
 */
package com.wang.simplesocket2bufprotocal;

import android.app.Application;
import android.content.Context;

/**
 * @author ssywbj
 * @since 2016/9/1 21:16
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
public class MyApplication extends Application {

    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = MyApplication.class.getSimpleName();

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        ClientSocket.getInstence().init(this);

    }

    // ===========================================================
    // Static Fields
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================


    // ===========================================================
    // Constructors
    // ===========================================================


    // ===========================================================
    // Getter or Setter
    // ===========================================================


    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================


    // ===========================================================
    // Methods
    // ===========================================================


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
