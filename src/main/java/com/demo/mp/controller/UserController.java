package com.demo.mp.controller;


import com.demo.mp.entity.User;
import com.demo.mp.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LvNing
 * @since 2019-06-12
 */
@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {

    @Autowired
    IUserService userService;

    @ApiOperation(value = "查询所有用户信息", response = User.class)
    @GetMapping(value = "/list/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> lambdaQuery(@ApiParam(name = "userName", value = "用户名")
                                  @PathVariable(name = "userName") String userName) {

        return userService.lambdaQuery().eq(User::getUserName, userName).list();

    }

}
