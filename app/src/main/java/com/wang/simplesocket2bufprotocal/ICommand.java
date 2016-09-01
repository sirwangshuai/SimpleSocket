/**
 * Copyright(c) 2014 ShenZhen Gowild Intelligent Technology Co., Ltd.
 * All rights reserved.
 * Created on  2014-2-20  下午8:39:31
 */
package com.wang.simplesocket2bufprotocal;


/**
 * Command接口
 *
 * @author Dream.xie
 */
public interface ICommand{

    /**
     * command的具体执行方法
     *
     * @param msg
     * @throws Exception
     */
    void excute(ClientSocket c, Message msg) throws Exception;

}
