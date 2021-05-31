package com.wuyu.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wuyu.dubbo.bean.UserAddress;
import com.wuyu.dubbo.service.OrderService;
import com.wuyu.dubbo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference
    private UserService userService;

    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id:"+userId);
        List<UserAddress> userAddressList = userService.getUserAddressList("11");
        for (UserAddress userAddress : userAddressList) {
            System.out.println(userAddress.getUserAddress());
        }
        return userAddressList;
    }

    public List<UserAddress> hello(String userId){
        return Arrays.asList(new UserAddress(10,"测试地址","1","测试","测试","Y"));
    }

}
