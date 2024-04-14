package com.jun.lottery.domain;

import com.jun.lottery.common.Constants;
import com.jun.lottery.domain.support.ids.IIdGenerator;
import com.jun.lottery.domain.support.ids.IdContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

/*
 * @author cjj
 * */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SupportTest {
    @Resource
    Map<Constants.ids,IIdGenerator> idGeneratorMap;
    @Test
    public void test_ids() {
        log.info("雪花算法策略，生成ID：{}", idGeneratorMap.get(Constants.ids.SnowFlake).nextId());
        log.info("日期算法策略，生成ID：{}", idGeneratorMap.get(Constants.ids.ShortCode).nextId());
        log.info("随机算法策略，生成ID：{}", idGeneratorMap.get(Constants.ids.RandomNumeric).nextId());
    }
}
