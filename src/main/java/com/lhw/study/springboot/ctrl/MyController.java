/**
 * @(#)MyController.java, 6月 22, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lhw.study.springboot.ctrl;

import com.lhw.study.springboot.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author lihanwen
 */

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MyController {

    @GetMapping(value = "/user")
    public User getUser() {
        User user = new User(3, new Date(), "hw");
        return user;
    }
}