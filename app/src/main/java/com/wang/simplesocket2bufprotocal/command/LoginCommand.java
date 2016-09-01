/**
 * Copyright (C)  2016 深圳市狗尾草智能科技有限公司
 * SimpleSocket2Bufprotocal
 * LoginCommand.java
 */
package com.wang.simplesocket2bufprotocal.command;

import com.wang.simplesocket2bufprotocal.ClientSocket;
import com.wang.simplesocket2bufprotocal.ICommand;
import com.wang.simplesocket2bufprotocal.Message;
import com.wang.simplesocket2bufprotocal.SocketCommand;

/**
 * @author ssywbj
 * @version 1.0
 *          <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2016/9/1 20:34
 */
@SocketCommand(type = 2,code = 102,desc = "登录的协议请求")
public class LoginCommand implements ICommand {


    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = LoginCommand.class.getSimpleName();

    @Override
    public void excute(ClientSocket c, Message msg) throws Exception {

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
