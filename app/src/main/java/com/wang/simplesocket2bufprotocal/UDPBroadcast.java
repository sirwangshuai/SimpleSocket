/**
 * Copyright (C)  2016 深圳市狗尾草智能科技有限公司
 * SimpleSocket2Bufprotocal
 * UDPBroadcast.java
 */
package com.wang.simplesocket2bufprotocal;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author shuai. wang
 * @since 2016/7/28 15:41
 * @version 1.0
 */
public class UDPBroadcast {

	public static final String TAG = UDPBroadcast.class.getSimpleName();
	private int sendPort = 10007;//发送广播的端口
	private WifiManager mWifiManager;//wifi管理器
	private WifiManager.MulticastLock mLock;//发送组播的类
	private InetAddress mSendAddress; //发送广播的ip地址

	/**
	 * 在Manifest文件中加入：android.permission.CHANGE_WIFI_MULTICAST_STATE，这个权限
	 * 获取到MulticastLock对象，这个对象不能直接实例化，要通过WifiManager间接得到，工厂模式
	 * 这个对象用来开启组播
	 * 调用MulticastLock对象的acquire方法，获取到组播锁
	 * 相应的，用完组播，为了不浪费电力，要调用MulticastLock的release方法释放锁
	 * @param context
	 */
	public UDPBroadcast(Context context) {
		//udp 第一步获取wifimanager
		mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		//获得MulticastLock对象,参数是一个tag,自己设置没有多大意义
		mLock = mWifiManager.createMulticastLock("UDPwifi");

	}


	/**
	 * 开启子线程发送广播,注意这个广播是不间断的,只有当应用停止的时候,要停止这个线程
	 * 我觉得这个方法可以重载几次,方便使用
	 */
	public void sendBroadcast(final byte[] cmd) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Log.e(TAG,"开始发送广播" + cmd);
				//执行发送广播的业务
				try {
					//设置广播地址 udp 的广播地址是224.0.0.0到239.255.255.255.这个地址好像有问题
					mSendAddress = InetAddress.getByName("255.255.255.255");
					//发送消息的端口,类似于现实中的码头
					//为什么发送的时候也可以指定端口号,这样下面不用写了
					DatagramSocket socket = new DatagramSocket();
					//设置成允许发送广播
					socket.setBroadcast(true);
					//发送的消息的承载体,类似于现实中的船,把端口号在这里设置了
					DatagramPacket packet = new DatagramPacket(cmd, cmd.length, mSendAddress, sendPort);
					//发送消息了
					socket.send(packet);
					//发送玩消息,关闭,其实这个可以改善一下,在finally保存就行了
					socket.close();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (SocketException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}


	class ReceviceThread extends Thread {
		@Override
		public void run() {

		}
	}

	public void stop() {
		//停止接收的线程
	}

}
