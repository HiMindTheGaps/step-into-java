/**
 * @(#)MySocketServerContext.java, 6月 03, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lhw.study.netty.nio.selector;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author lihanwen
 */
public class MySocketServerContext {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    public MySocketServerContext() {
    }

    public MySocketServerContext(Selector selector, ServerSocketChannel serverSocketChannel) {
        this.selector = selector;
        this.serverSocketChannel = serverSocketChannel;
    }

    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public ServerSocketChannel getServerSocketChannel() {
        return serverSocketChannel;
    }

    public void setServerSocketChannel(ServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }
}