package com.wuyu.dubbo.service.impl;

import com.wuyu.dubbo.bean.UserAddress;
import com.wuyu.dubbo.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;

public class UserServiceImplStub implements UserService {

    UserService userService;

    /**
     * 传入的是userService的远程对象
     * @param userService
     */
    public UserServiceImplStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("userServiceStub---------");
        if(!StringUtils.isEmpty(userId)){
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
