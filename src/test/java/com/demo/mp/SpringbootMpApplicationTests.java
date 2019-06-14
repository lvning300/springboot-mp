package com.demo.mp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.mp.entity.User;
import com.demo.mp.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMpApplicationTests {

    @Autowired
    IUserService userService;


    /**
     * saveOrUpdateBatch 依赖ID操作如果ID不存在则插入否则更新
     */
    @Test
    public void insertOrUpdate() {

        User userA = User.builder()
                .id(getUUId())
                .userName("jack")
                .age(12)
                .email("jack@163.com")
                .managerId(getUUId())
                .build();

        User userB = User.builder()
                .id(getUUId())
                .userName("sunny")
                .age(12)
                .email("sunny@163.com")
                .managerId(getUUId())
                .build();

        List<User> users = Arrays.asList(userA, userB);

        boolean updateBatch = userService.saveOrUpdateBatch(users);

        System.out.println(updateBatch);

    }

    private String getUUId() {
        return UUID.randomUUID().toString();
    }


    /**
     * saveBatch 批量保存
     */
    @Test
    public void saveBatch() {

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            User userB = User.builder()
                    .id(getUUId())
                    .userName("钱大妈A" + i)
                    .age(i)
                    .email("zdm@16" + i + ".com")
                    .managerId(getUUId())
                    .build();
            users.add(userB);
        }

        userService.insertBatch(users);

    }


    /**
     * updateBatch 依赖ID操作如果ID则也表示更新成功
     */
    @Test
    public void updateBatch() {

        List<User> users = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            User userB = User.builder()
                    //.id(UUID.randomUUID().toString())
                    .userName("钱大妈A" + i)
                    .age(35)
                    .email("zdm@16" + i + ".com")
                    //.managerId(UUID.randomUUID().toString())
                    .build();
            users.add(userB);
        }

        userService.updateBatch(users);
    }


    @Test
    public void selectUserByPage() {

        IPage<User> userIPage = userService.queryUserByPage(1, 10, "钱大");
        List<User> records = userIPage.getRecords();
        records.forEach(System.out::println);

    }

    @Test
    public void queryUserByPageNotUseCount() {

        IPage<User> userIPage = userService.queryUserByPageNotUseCount(1, 10, "钱大");
        List<User> records = userIPage.getRecords();
        records.forEach(System.out::println);

    }


}
