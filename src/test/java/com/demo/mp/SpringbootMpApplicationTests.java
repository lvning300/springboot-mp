package com.demo.mp;

import com.demo.mp.entity.User;
import com.demo.mp.mapper.UserMapper;
import com.demo.mp.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMpApplicationTests {

    @Autowired
    IUserService userService;

    /*
     *
     *saveOrUpdateBatch 依赖ID操作如果ID不存在则插入否则更新
     *
     */

    @Test
    public void insertOrUpdate() {

        User userA = User.builder()
                .id("987654321Qwert123")
                .userName("张三")
                .age(48)
                .email("zs@163.com")
                .managerId(UUID.randomUUID().toString())
                .build();

        User userB = User.builder()
                .id("1234567890SADF456")
                .userName("赵四")
                .age(35)
                .email("zs@163.com")
                .managerId(UUID.randomUUID().toString())
                .build();

        List<User> users = Arrays.asList(userA, userB);

        boolean updateBatch = userService.saveOrUpdateBatch(users);

        System.out.println(updateBatch);

    }



    /*
     *
     *saveOrUpdateBatch 依赖ID操作如果ID则也表示更新成功
     *
     */
    @Test
    public void updateBatch() {

        User userA = User.builder()
                .id("987654321Qwert123456")
                .userName("张三")
                .age(14)
                .email("zs@163.com")
                .managerId(UUID.randomUUID().toString())
                .build();

        User userB = User.builder()
                .id("1234567890SADF456789")
                .userName("赵四")
                .age(12)
                .email("zs@163.com")
                .managerId(UUID.randomUUID().toString())
                .build();

        List<User> users = Arrays.asList(userA, userB);

        boolean updateBatch = userService.updateBatchById(users);

    }


}
