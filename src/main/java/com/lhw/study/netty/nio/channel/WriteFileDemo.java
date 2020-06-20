/**
 * @(#)WriteFileDemo.java, 6月 02, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lhw.study.netty.nio.channel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author lihanwen
 */
public class WriteFileDemo {

    public static void main(String[] args) {
        String msg = "首次写文件内容";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(msg.getBytes());
        byteBuffer.flip();

        try (FileOutputStream fos = new FileOutputStream("text1.txt")) {
            FileChannel channel = fos.getChannel();
            channel.write(byteBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}