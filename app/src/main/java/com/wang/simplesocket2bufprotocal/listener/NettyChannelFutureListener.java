/**
 * Copyright (C)  2016 深圳市狗尾草智能科技有限公司
 * SimpleSocket2Bufprotocal
 * NettyChannelFutureListener.java
 */
package com.wang.simplesocket2bufprotocal.listener;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;

/**
 * @author ssywbj
 * @since 2016/9/2 22:29
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍
 * 负责netty的掉线重连机制
 * </strong></p>
 */
public class NettyChannelFutureListener implements ChannelFutureListener {

    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = NettyChannelFutureListener.class.getSimpleName();

    @Override
    public void operationComplete(ChannelFuture channelFuture) throws Exception {
//        if (!channelFuture.isSuccess()) {
//
//            System.out.println("Reconnect");
//
//            final EventLoop loop = channelFuture.channel().eventLoop();
//
//            loop.schedule(new Runnable() {
//
//                @Override
//
//                public void run() {
//
//                    client.createBootstrap(new Bootstrap(), loop);
//
//                }
//
//            }, 1L, TimeUnit.SECONDS);
//
//        }

        if (!channelFuture.isSuccess()) {
            Log.d(TAG,"开启重新连接");
        }

        boolean isSuccess = channelFuture.isSuccess();
        Channel channel = channelFuture.channel();
//        Logger.d(TAG,"operationComplete() isSuccess = " + isSuccess);
//        synchronized (mLock) {
//            mIsConnecting = false;
//            if (!isSuccess) {
//                mConnection = null;
//                if (channel != null) {
//                    channel.close();
//                    channel.eventLoop().schedule(mScheduleConnectTask, SCHEDULE_RECONNECT_SECONDS, TimeUnit.SECONDS);
//                }
//                mIsConnected = false;
//            } else {
//                if (mConnection != null && !mConnection.isClosed()){
//                    mConnection.close();
//                }
//                mConnection = new NettyConnection(mHostAddress, mPort, channel);
//                mIsConnected = true;
//            }
//        }
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
