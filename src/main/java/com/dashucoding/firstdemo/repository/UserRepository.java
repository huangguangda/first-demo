/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserRepository
 * Author:   Jack
 * Date:     2018/12/17 18:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dashucoding.firstdemo.repository;


import com.dashucoding.firstdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jack
 * @create 2018/12/17
 * @since 1.0.0
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {
    /*
    * 采用内存型的存储方式 -> Map
    * */
    private final ConcurrentMap<Integer,User> repository
            = new ConcurrentHashMap<>();
    private final static AtomicInteger idGenerator =
            new AtomicInteger();
    /*
    * 保存用户对象,如果保存成功,返回<code>true</code>,
    * 否则,返回<code>false</code>
    * @param user {@link User} 对象
    * */
    public boolean save(User user){
//        boolean success = false;
//        ID从1开始
        Integer id = idGenerator.incrementAndGet();
//        设置 ID
        user.setId(id);
//        repository.put(id,user);
        return repository.put(id,user) == null;
    }
    /*
    * 返回所有用户列表
    * */
    public Collection<User> findAll() {
        return repository.values();
    }
}
