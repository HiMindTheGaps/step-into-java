/**
 * @(#)User.java, 6月 22, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lhw.study.springboot.domain;

import java.util.Date;

/**
 * @author lihanwen
 */
public class User {

    private int id;
    private Date birthday;
    private String name;

    public User() {
    }

    public User(int id, Date birthday, String name) {
        this.id = id;
        this.birthday = birthday;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", birthday=").append(birthday);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}