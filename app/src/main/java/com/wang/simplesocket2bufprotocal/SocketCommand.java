/**
 * Copyright(c) 2014 ShenZhen Gowild Intelligent Technology Co., Ltd.
 * All rights reserved.
 * Created on  2014-3-21  上午10:02:07
 */
package com.wang.simplesocket2bufprotocal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Dream.xie
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SocketCommand {
    /**
     * 类型
     *
     * @return
     */
    byte type();

    /**
     * 模块类型
     *
     * @return
     */
    short code();

    /**
     * 描述
     *
     * @return
     */
    String desc() default "";
}
