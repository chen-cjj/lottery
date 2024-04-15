package com.jun.lottery.dao;

import com.jun.lottery.infrastructure.dao.IUserTakeActivityDao;
import com.jun.lottery.infrastructure.po.UserTakeActivity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: 测试用户领取活动表
 * @author: 小傅哥，微信：fustack
 * @date: 2021/9/22
 * @github: https://github.com/fuzhengwei
 * @Copyright: 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTakeActivityDaoTest {

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Test
    public void test_insert() {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setuId("Ukdli109op811d"); // 1库：Ukdli109op89oi 2库：Ukdli109op811d
        userTakeActivity.setTakeId(121019889410L);
        userTakeActivity.setActivityId(100001L);
        userTakeActivity.setActivityName("测试活动");
        userTakeActivity.setTakeDate(new Date());
        userTakeActivity.setTakeCount(10);
        userTakeActivity.setUuid("Ukdli109op811d");

        userTakeActivityDao.insert(userTakeActivity);
    }

}
