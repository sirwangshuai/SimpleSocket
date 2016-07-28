package com.wang.simplesocket2bufprotocal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author shuai. wang
 * @since 2016/7/28 15:09
 * @des 这个类将会用来发送udp广播
 * @des udp的广播方面无连接,即加入了多播群组就能收到主机发送的消息
 * @target 让机器能够收到手机发送的wifi帐号密码的udp广播 具体的作用我再请教一下项目组长
 * // TODO: 2016/7/28 写完这个进行测试
 * // 鼓励一下 你若不勇敢,谁来替你坚强,udp搞起
 */
public class UDPActivity extends AppCompatActivity{

	/**
	 * 核心的思想
	 * 1.udp是面向无连接的,发送数据的时候要用一个载体去承载消息
	 * 2.udp发送广播是要获取wifiMannager
	 * 3.udp是要加入组播的
	 * 4.即时的通讯是要while(true)这种循环
	 */

	public static final String TAG = UDPActivity.class.getSimpleName();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}
