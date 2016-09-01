/**
 * Copyright (C)  2016 深圳市狗尾草智能科技有限公司
 * SimpleSocket2Bufprotocal
 * NettyInitializer.java
 */
package com.wang.simplesocket2bufprotocal;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author ssywbj
 * @since 2016/9/1 10:20
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
public class NettyInitializer extends ChannelInitializer<SocketChannel> {

    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = NettyInitializer.class.getSimpleName();

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //初始化解码器和加上自己的channel
        ChannelPipeline pipeline = socketChannel.pipeline();
//        pipeline.addLast("decoder", new StringDecoder()); 添加加密和解密的coder
//        pipeline.addLast("encoder", new StringEncoder());
//      自己的处理逻辑hander
//        pipeline.addLast("hander",new )
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
