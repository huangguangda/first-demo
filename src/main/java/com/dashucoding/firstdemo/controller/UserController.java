/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserController
 * Author:   Jack
 * Date:     2018/12/17 18:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dashucoding.firstdemo.controller;


import com.dashucoding.firstdemo.domain.User;
import com.dashucoding.firstdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jack
 * @create 2018/12/17
 * @since 1.0.0
 */
@RestController
public class UserController {
//    构造器的注入方式,不能修改,可以提早的进行初始化
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
            System.out.printf("用户对象: %s 保存成功! \n",user);
        }
        return user;
    }
}
