/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: RouterFunctionConfiguration
 * Author:   Jack
 * Date:     2018/12/18 1:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dashucoding.firstdemo.config;


import com.dashucoding.firstdemo.domain.User;
import com.dashucoding.firstdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jack
 * @create 2018/12/18
 * @since 1.0.0
 * 路由器函数
 */
@Configuration
public class RouterFunctionConfiguration {
//    Servlet
//    请求接口: ServletRequest 或者 HttpServletRequest
//    响应接口: ServletResponse 或者 HttpServletResponse
//    Spring 5.0 重新定义了服务请求和响应接口
//    请求接口: ServerRequest
//    响应接口: ServerResponse
//    即可支持Servlet规范,也可以支持自定义,比如:Netty (Web Server)
//    以本利:
//    定义GET请求,并且返回所有的用户对象 URI: /person/find/all
//    Flus 是0-N个对象集合
//    Momo 是0-1个对象集合
//    Reactive中的Flux或者Mono它是异步处理
//    集合对象基本上是同步处理(阻塞)
//    Flux或者Mono都是Publisher
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    //      返回所有的用户对象
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
        });
    }
}
