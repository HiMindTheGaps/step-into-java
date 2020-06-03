/**
 * @(#)MyServerBootStap.java, 6月 03, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lhw.study.netty.nio.selector;

/**
 * @author lihanwen
 */
public class MyServerBootStrap {

    public static void main(String[] args) {
        MySocketServer mySocketServer = new MySocketServer(8899);
        mySocketServer.start();
    }
}