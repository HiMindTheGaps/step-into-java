/**
 * @(#)MySocketServer.java, 6月 03, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lhw.study.netty.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lihanwen
 */
public class MySocketServer {

    private MySocketServerContext context;

    private ExecutorService threadPool;

    public MySocketServer(int port) {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            context = new MySocketServerContext(selector, serverSocketChannel);
            threadPool = Executors.newSingleThreadExecutor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Selector selector = context.getSelector();
        try {
            while (!Thread.currentThread().isInterrupted()) {
                if (selector.select() != 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    /**
                     * (TODO:lihanwen)这个地方的处理是有问题的
                     * 开启新的线程去处理selectionKey需要一定的时间，在没有处理完之后，该selectionKey会在后续的每次select过程中得到
                     * 所以就会不停的使用这个线程去处理这个selectionKey
                     *
                     */
                    selectionKeys.forEach(key -> threadPool.submit(new MyHandler(context, key)));
                    selectionKeys.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
            try {
                context.getServerSocketChannel().close();
                context.getSelector().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}