package com.jun.lottery.domain.rule.service.engine;
/*
 * @author cjj
 * */

import com.jun.lottery.domain.rule.service.logic.LogicFilter;
import com.jun.lottery.domain.rule.service.logic.impl.UserAgeFilter;
import com.jun.lottery.domain.rule.service.logic.impl.UserGenderFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EngineConfig {
    @Resource
    UserAgeFilter userAgeFilter;
    @Resource
    UserGenderFilter userGenderFilter;

    protected Map<String,LogicFilter> logicFilterMap = new ConcurrentHashMap();

    @PostConstruct
    public void init() {
        logicFilterMap.put("userAge",userAgeFilter);
        logicFilterMap.put("userGender",userGenderFilter);
    }
}
