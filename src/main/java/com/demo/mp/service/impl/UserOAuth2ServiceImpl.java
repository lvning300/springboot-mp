package com.demo.mp.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.mp.entity.UserOAuthEntity;
import com.demo.mp.mapper.OAuth2Mapper;
import com.demo.mp.service.IUserOAuth2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class UserOAuth2ServiceImpl extends ServiceImpl<OAuth2Mapper, UserOAuthEntity> implements IUserOAuth2Service {


    @Override
    public UserOAuthEntity getUserOAuth2(String userName) {
        try {
            List<UserOAuthEntity> list = lambdaQuery()
                    .eq(UserOAuthEntity::getUsername, userName)
                    .list();
            if (list.size() > 0) {
                return list.get(0);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
