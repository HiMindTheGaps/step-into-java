/**
 * @(#)SocketHandler.java, 6月 01, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lhw.study.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author lihanwen
 */
public class SocketHandler implements Runnable {

    private Socket socket;

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while ((!Thread.currentThread().isInterrupted()) && (!socket.isClosed())) {
            try {
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String meg;
                while ((meg = br.readLine()) != null) {
                    System.out.println(Thread.currentThread().getName() + " : " + meg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}