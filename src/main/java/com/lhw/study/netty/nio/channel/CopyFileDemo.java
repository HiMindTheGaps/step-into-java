/**
 * @(#)CopyFileDemo.java, 6月 02, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lhw.study.netty.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author lihanwen
 */
public class CopyFileDemo {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);

        try (FileInputStream fis = new FileInputStream("text1.txt");
             FileOutputStream fos = new FileOutputStream("text2.txt")) {
            FileChannel inputChannel = fis.getChannel();
            FileChannel outputChannel = fos.getChannel();
            while (inputChannel.read(byteBuffer)!=-1) {
                byteBuffer.flip();
                outputChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}