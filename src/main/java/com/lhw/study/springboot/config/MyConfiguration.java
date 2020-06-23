/**
 * @(#)MyConfiguration.java, 6月 22, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lhw.study.springboot.config;

import com.lhw.study.springboot.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author lihanwen
 */
@Configuration
public class MyConfiguration {

    @Value("${admin.user.id}")
    private int id;
    @Value("${admin.user.name}")
    private String name;

    @Bean
    public User getUserBean() {
        return new User(id, new Date(), name);
    }
}