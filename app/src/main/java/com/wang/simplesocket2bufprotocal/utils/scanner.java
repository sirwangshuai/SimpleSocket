/**
 * Copyright (C)  2016 深圳市狗尾草智能科技有限公司
 * SimpleSocket2Bufprotocal
 * Scanner.java
 */
package com.wang.simplesocket2bufprotocal.utils;

import android.content.Context;

import com.wang.simplesocket2bufprotocal.ICommand;
import com.wang.simplesocket2bufprotocal.SocketCommand;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;

/**
 * @author ssywbj
 * @since 2016/9/1 21:26
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
public class Scanner {

    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = Scanner.class.getSimpleName();


    private static Field dexField;

    static {
        try {
            dexField = PathClassLoader.class.getDeclaredField("mDexs");
            dexField.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Class<?>> scan(Context ctx, String entityPackage) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        try {
            PathClassLoader classLoader = (PathClassLoader) Thread
                    .currentThread().getContextClassLoader();

            DexFile dex = new DexFile(ctx.getPackageResourcePath());
            Enumeration<String> entries = dex.entries();
            while (entries.hasMoreElements()) {
                String entryName = entries.nextElement();
                if (entryName.contains(entityPackage)) {
                    Class<?> entryClass = Class.forName(entryName, true,classLoader);//疑问：Class.forName(entryName);这种方式不知道为什么返回null，哪位大神知道原因，请指点一下小弟吧  感激不尽
                    SocketCommand annotation = entryClass.getAnnotation(SocketCommand.class);
                    if (annotation != null) {
                        classes.add(entryClass);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }



    /**
     * 安卓只能扫全部的
     */
    public static void scan() {
        Map<Integer,Class> map = new HashMap<>();
        int index = 0;
        try {
            PathClassLoader classLoader = (PathClassLoader) Thread.currentThread().getContextClassLoader();
            DexFile[] dexs = (DexFile[]) dexField.get(classLoader);
            for (DexFile dex : dexs) {
                Enumeration<String> entries = dex.entries();
                while (entries.hasMoreElements()) {
                    String entry = entries.nextElement();
                    Class<?> entryClass = dex.loadClass(entry, classLoader);
                    if (entryClass != null) {
                        index ++;
                        SocketCommand annotation = entryClass.getAnnotation(SocketCommand.class);
                        if (annotation != null) {
                            map.put(index, entryClass);
                            System.out.println("name=" + annotation.code() + annotation.type() +  "; class=" + entryClass.getName());
                        }
                    }
                }
            }
            System.out.print(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
