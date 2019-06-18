package com.demo.mp.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.mp.entity.UserOAuthEntity;

public interface IUserOAuth2Service extends IService<UserOAuthEntity> {

    UserOAuthEntity getUserOAuth2(String userName);
}
