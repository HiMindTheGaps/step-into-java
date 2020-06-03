/**
 * @(#)TypeBuffer.java, 6月 02, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lhw.study.netty.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @author lihanwen
 */
public class TypeBufferDemo {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        byteBuffer.putInt(123);
        byteBuffer.putLong(345);
        byteBuffer.putChar('李');
        byteBuffer.putDouble(123.45);
        byteBuffer.putShort((short) 22);

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getShort());
    }
}