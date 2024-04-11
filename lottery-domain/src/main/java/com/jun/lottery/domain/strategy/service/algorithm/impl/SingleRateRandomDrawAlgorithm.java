package com.jun.lottery.domain.strategy.service.algorithm.impl;

import com.jun.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/*
 * @author cjj
 * 【推荐】单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 * */
@Component
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        // 获取策略对应的元祖
        String[] rateTuple = super.rateTupleMap.get(strategyId);
//        assert rateTuple != null;
        // 随机生成1-100，通过hash函数索引到元组的指定位置
        int intVal = new SecureRandom().nextInt(100) + 1;
        String awardId = rateTuple[super.hashIdx(intVal)];
        // 如果奖品没有了，未中奖
        if(excludeAwardIds.contains(awardId)) return "未中奖";
        return awardId;
    }
}
