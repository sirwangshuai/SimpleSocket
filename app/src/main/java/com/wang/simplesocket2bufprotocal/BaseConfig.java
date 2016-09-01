/**
 * Copyright (C)  2016 深圳市狗尾草智能科技有限公司
 * SimpleSocket2Bufprotocal
 * BaseConfig.java
 */
package com.wang.simplesocket2bufprotocal;

/**
 * @author ssywbj
 * @since 2016/9/1 20:09
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
public class BaseConfig {

    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = BaseConfig.class.getSimpleName();
    private static Object instance;


    private String scanPackageName = "com.wang.simplesocket2bufprotocal.command";

    public String getScanPackage(){

        return scanPackageName;
    }

    public static BaseConfig getInstance() {

        return new BaseConfig();
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
