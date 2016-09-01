/**
 * Copyright (C)  2016 深圳市狗尾草智能科技有限公司
 * SimpleSocket2Bufprotocal
 * ClientSocket.java
 */
package com.wang.simplesocket2bufprotocal;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author ssywbj
 * @since 2016/9/1 10:14
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
public class ClientSocket {

    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = ClientSocket.class.getSimpleName();

    // ===========================================================
    // Static Fields
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private static ClientSocket instence;
    private NettyInitializer initializer;


    // ===========================================================
    // Constructors
    // ===========================================================
    private ClientSocket(){
        //进行对netty的初始化操作
        //需要有一个解码器
        initializer = new NettyInitializer();
        //开始一个客户端实例
        Bootstrap bootstrap = new Bootstrap();
        //开启一个事件的线程组
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();
        //设置的channle
        bootstrap.channel(NioSocketChannel.class);
        //
//        Bootstrap bootstrap=new Bootstrap();
//        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE,true);
//        bootstrap.group(eventLoopGroup);
//        bootstrap.remoteAddress(host,port);

    }



    // ===========================================================
    // Getter or Setter
    // ===========================================================

    /**
     * netty 管理的单例
     * @return
     */
    public static ClientSocket getInstence(){
        if (instence == null) {
            synchronized (ClientSocket.class) {
                if (instence == null) {
                    instence = new ClientSocket();
                }
            }
        }
        return instence;
    }



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
