/**
 * Copyright (C)  2016 深圳市狗尾草智能科技有限公司
 * SimpleSocket2Bufprotocal
 * HelloCientHandler.java
 */
package com.wang.simplesocket2bufprotocal;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author ssywbj
 * @since 2016/9/1 10:46
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
public class HelloCientHandler extends ChannelInboundHandlerAdapter {

    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = HelloCientHandler.class.getSimpleName();

    // ===========================================================
    // Methods
    // ===========================================================

    /**
     * 需要内部持有一个对象,来分发消息的处理
     */

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 收到消息直接打印输出
        System.out.println(ctx.channel().remoteAddress() + " Say : " + msg);
        // 返回客户端消息 - 我已经接收到了你的消息
        ctx.writeAndFlush("Received your message !\n");
    }


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
