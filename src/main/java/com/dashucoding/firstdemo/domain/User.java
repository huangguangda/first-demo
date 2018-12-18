/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: User
 * Author:   Jack
 * Date:     2018/12/17 17:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dashucoding.firstdemo.domain;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jack
 * @create 2018/12/17
 * @since 1.0.0
 */
/*
* 用户模型
* */
public class User {
    private int id;
    /*
    * 用户的名称
    * */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
