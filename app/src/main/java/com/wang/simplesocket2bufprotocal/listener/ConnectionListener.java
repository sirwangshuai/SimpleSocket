/**
 * Copyright (C)  2016 深圳市狗尾草智能科技有限公司
 * SimpleSocket2Bufprotocal
 * ConnectionListener.java
 */
package com.wang.simplesocket2bufprotocal.listener;

import com.wang.simplesocket2bufprotocal.ClientSocket;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;

/**
 * @author ssywbj
 * @version 1.0
 *          <p><strong>Features draft description.主要功能介绍
 *          负责掉线重连
 *          <p>
 *          </strong></p>
 * @since 2016/9/2 21:03
 */
public class ConnectionListener implements ChannelFutureListener {

    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = ConnectionListener.class.getSimpleName();

    private ClientSocket client;

    public ConnectionListener(ClientSocket client) {
        this.client = client;
    }

    /**
     * 处理掉线重连
     */
    @Override
    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        if (!channelFuture.isSuccess()) {

            System.out.println("Reconnect");

            final EventLoop loop = channelFuture.channel().eventLoop();

            loop.schedule(new Runnable() {

                @Override

                public void run() {

                    client.createBootstrap(new Bootstrap(), loop);

                }

            }, 1L, TimeUnit.SECONDS);

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
