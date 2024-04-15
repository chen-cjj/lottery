package com.jun.lottery.dao;

import com.alibaba.fastjson.JSON;
import com.jun.lottery.common.Constants;
import com.jun.lottery.domain.support.ids.IIdGenerator;
import com.jun.lottery.infrastructure.dao.IUserStrategyExportDao;
import com.jun.lottery.infrastructure.po.UserStrategyExport;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @description: 用户策略计算结果表Dao测试
 * @author: 小傅哥，微信：fustack
 * @date: 2021/9/30
 * @github: https://github.com/fuzhengwei
 * @Copyright: 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserStrategyExportDaoTest {


    @Resource
    private IUserStrategyExportDao userStrategyExportDao;

    @Resource
    private Map<Constants.ids, IIdGenerator> idGeneratorMap;

    @Test
    public void test_insert() {
        UserStrategyExport userStrategyExport = new UserStrategyExport();
        userStrategyExport.setuId("Uhdgkw333333");
        userStrategyExport.setActivityId(idGeneratorMap.get(Constants.ids.ShortCode).nextId());
        userStrategyExport.setOrderId(idGeneratorMap.get(Constants.ids.SnowFlake).nextId());
        userStrategyExport.setStrategyId(idGeneratorMap.get(Constants.ids.RandomNumeric).nextId());
        userStrategyExport.setStrategyMode(Constants.StrategyMode.SINGLE.getCode());
        userStrategyExport.setGrantType(1);
        userStrategyExport.setGrantDate(new Date());
        userStrategyExport.setGrantState(1);
        userStrategyExport.setAwardId("1");
        userStrategyExport.setAwardType(Constants.AwardType.DESC.getCode());
        userStrategyExport.setAwardName("IMac");
        userStrategyExport.setAwardContent("奖品描述");
        userStrategyExport.setUuid(String.valueOf(userStrategyExport.getOrderId()));

        userStrategyExportDao.insert(userStrategyExport);
    }

    @Test
    public void test_select() {
        UserStrategyExport userStrategyExport = userStrategyExportDao.queryUserStrategyExportByUId("Uhdgkw766120d");
        log.info("测试结果：{}", JSON.toJSONString(userStrategyExport));
    }

}
