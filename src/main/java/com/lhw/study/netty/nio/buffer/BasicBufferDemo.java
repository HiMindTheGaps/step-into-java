/**
 * @(#)BasicBuffer.java, 6月 01, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lhw.study.netty.nio.buffer;

import java.nio.IntBuffer;
import java.util.Arrays;

/**
 * @author lihanwen
 */
public class BasicBufferDemo {

    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(10);

        System.out.println("init capacity: " + intBuffer.capacity());
        System.out.println("init limit: " + intBuffer.limit());
        System.out.println("init position: " + intBuffer.position());

        for (int i = 0; i < (intBuffer.capacity()/2); i++) {
            intBuffer.put(i * 3);
            System.out.println("i: " + i +  " ==> limit: " + intBuffer.limit());
            System.out.println("i: " + i +  " ==> position: " + intBuffer.position());
        }

        System.out.println("array: " + Arrays.toString(intBuffer.array()));

        intBuffer.flip();
        System.out.println("flip limit: " + intBuffer.limit());
        System.out.println("flip position: " + intBuffer.position());

        for (int i = 0; i < (intBuffer.capacity()/2); i++) {
            intBuffer.put(i * 4);
            System.out.println("i: " + i +  " ==> limit: " + intBuffer.limit());
            System.out.println("i: " + i +  " ==> position: " + intBuffer.position());
        }

        System.out.println("array: " + Arrays.toString(intBuffer.array()));
    }
}