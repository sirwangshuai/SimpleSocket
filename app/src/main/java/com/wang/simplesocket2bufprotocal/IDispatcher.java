/**
 * Copyright (C)  2016 深圳市狗尾草智能科技有限公司
 * SimpleSocket2Bufprotocal
 * IDispatcher.java
 */
package com.wang.simplesocket2bufprotocal;

/**
 * @author ssywbj
 * @since 2016/9/1 11:08
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍
 *        处理消息的分发问题
 * </strong></p>
 */
public interface IDispatcher {

    //分发消息
    void dispatherMessage(Message msg);
    //分发异常


    // ===========================================================
    // Constants
    // ===========================================================


    // ===========================================================
    // Methods
    // ===========================================================
}
