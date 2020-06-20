/**
 * @(#)MyHandler.java, 6月 03, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lhw.study.netty.nio.selector;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

/**
 * @author lihanwen
 */
public class MyHandler implements Runnable {

    private MySocketServerContext context;

    private SelectionKey key;

    public MyHandler(MySocketServerContext context, SelectionKey selectionKey) {
        this.context = context;
        this.key = selectionKey;
    }

    @Override
    public void run() {
        ServerSocketChannel serverSocketChannel = context.getServerSocketChannel();
        Selector selector = context.getSelector();
        if (key.isAcceptable()) {
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println(
                        Thread.currentThread().getName() + ": " + socketChannel.getRemoteAddress() +
                                ": 已连接");
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (key.isReadable()) {
            SocketChannel channel = (SocketChannel) key.channel();
            try {
                System.out.println(
                        Thread.currentThread().getName() + ": " + channel.getRemoteAddress() +
                                ": 可读");
            } catch (IOException e) {
                e.printStackTrace();
            }
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            try {
                channel.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            buffer.flip();
            try {
                String msg = Charset.defaultCharset().newDecoder().decode(buffer.asReadOnlyBuffer())
                        .toString();
                buffer.clear();
                System.out.println(channel + ": " + msg);
            } catch (CharacterCodingException e) {
                e.printStackTrace();
            }
        }
    }
}