package com.wang.simplesocket2bufprotocal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 写这个类,是为了socket的基本使用
 * 学习目标学会socket的基本使用,可以用来简单的即时通信传输
 * 分为udp与tcp的广播
 */
public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ClientSocket.getInstence();
	}

	/**
	 * 开启udp广播
	 * @param view
	 */
	public void startUDP(View view) {
		startIntent(UDPActivity.class);
	}


	public void startIntent(Class clazz) {
		startActivity(new Intent(this,clazz));
	}

}
