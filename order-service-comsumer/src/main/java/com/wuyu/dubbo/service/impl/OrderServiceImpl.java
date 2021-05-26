package com.wuyu.dubbo.service.impl;

import com.wuyu.dubbo.bean.UserAddress;
import com.wuyu.dubbo.service.OrderService;
import com.wuyu.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id:"+userId);
        List<UserAddress> userAddressList = userService.getUserAddressList("11");
        for (UserAddress userAddress : userAddressList) {
            System.out.println(userAddress.getUserAddress());
        }
        return userAddressList;
    }
}
