package com.jun.lottery.domain.support.ids;
/*
 * @author cjj
 * */

import com.jun.lottery.common.Constants;
import com.jun.lottery.domain.support.ids.policy.RandomNumeric;
import com.jun.lottery.domain.support.ids.policy.ShortCode;
import com.jun.lottery.domain.support.ids.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class IdContext {
    @Bean
    public Map<Constants.ids,IIdGenerator> idGenerator(RandomNumeric randomNumeric,ShortCode shortCode,SnowFlake snowFlake) {
        Map<Constants.ids,IIdGenerator> idGeneratorMap = new ConcurrentHashMap();
        idGeneratorMap.put(Constants.ids.ShortCode,shortCode);
        idGeneratorMap.put(Constants.ids.SnowFlake,snowFlake);
        idGeneratorMap.put(Constants.ids.RandomNumeric,randomNumeric);
        return idGeneratorMap;
    }
}
