/**
 * Copyright (C)  2016 深圳市狗尾草智能科技有限公司
 * SimpleSocket2Bufprotocal
 * ClientSocket.java
 */
package com.wang.simplesocket2bufprotocal;

import android.content.Context;

import com.wang.simplesocket2bufprotocal.listener.NettyChannelFutureListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author ssywbj
 * @version 1.0
 *          <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2016/9/1 10:14
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
    private Context context;
    private Map<Integer, ICommand> commands = new HashMap<>();
    private Bootstrap bootstrapm;
    private boolean isConnected;
    private Channel session;
    private NettyChannelFutureListener mFutureListener;


    // ===========================================================
    // Constructors
    // ===========================================================
    private ClientSocket() {
    }


    public void init(Context context) {
        this.context = context;
        initInternalCommand();
        initSocket();
    }

    /**
     * 初始化Icommed,通过反射加载类对象读取类的信息
     */
    private void initInternalCommand() {
        SocketCommand socketCommandAnnotation = null;
        short code = 0;
        byte type = 0;
        ICommand gameCommand = null;

        List<Class<ICommand>> classes = ClassUtil.scan(context, BaseConfig.scanPackageName);
        //加载class文件
        for (Class<?> clazz : classes) {
            socketCommandAnnotation = clazz.getAnnotation(SocketCommand.class);
            if (socketCommandAnnotation != null) {
                code = socketCommandAnnotation.code();
                type = socketCommandAnnotation.type();//获得了code和type
                System.out.print(code + type + "-----------------------------");
                try {
                    gameCommand = (ICommand) clazz.newInstance();
                    commands.put(((type << 16) + code), gameCommand);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void initSocket() {
        //进行对netty的初始化操作
        //需要有一个解码器
        initializer = new NettyInitializer();
        //开始一个客户端实例
        bootstrapm = new Bootstrap();
        //开启一个事件的线程组
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        //设置事件的group的线程组
        bootstrapm.group(eventLoopGroup);
        //指定channel类型
        bootstrapm.channel(NioSocketChannel.class);
        //保活
        bootstrapm.option(ChannelOption.SO_KEEPALIVE, false);
        //加入初始化的handler
        bootstrapm.handler(initializer);
        //设置ip 端口号,连接的时候调用
        bootstrapm.remoteAddress("58.67.213.148", 6030);
//      bootstrap.connect().addListener(new ConnectionListener(this));

    }


    public void connect() {
        //避免重复的调用connect方法,优雅清晰的代码.哈哈
        if (!isConnected) {
            isConnected = true;
            ChannelFuture channelFuture = this.bootstrapm.connect();
            session = channelFuture.channel();
            channelFuture.removeListener(mFutureListener);//这一步是不是必须的呢
            channelFuture.addListener(mFutureListener);
        }
    }


    /**
     * netty 管理的单例
     *
     * @return
     */
    public static ClientSocket getInstence() {
        if (instence == null) {
            synchronized (ClientSocket.class) {
                if (instence == null) {
                    try {
                        instence = new ClientSocket();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instence;
    }

    public void createBootstrap(Bootstrap bootstrap, EventLoop loop) {

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
