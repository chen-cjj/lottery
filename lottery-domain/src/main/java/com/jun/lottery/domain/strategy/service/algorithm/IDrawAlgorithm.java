package com.jun.lottery.domain.strategy.service.algorithm;
/*
 * @author cjj
 * 策略接口
 * */

import com.jun.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

public interface IDrawAlgorithm {
    // 初始化概率元组
    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList);
    // 判断元组是否存在
    boolean isExistRateTuple(Long strategyId);
    // 执行抽奖
    String randomDraw(Long strategyId,List<String> excludeIdsList);
}
