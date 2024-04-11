package com.jun.lottery.domain.strategy.service.draw;
/*
 * @author cjj
 * */

import com.jun.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.jun.lottery.domain.strategy.repository.IStrategyRepository;
import com.jun.lottery.infrastructure.po.Award;
import com.jun.lottery.infrastructure.po.Strategy;

import javax.annotation.Resource;

public class DrawStrategySupport extends DrawConfig{
    @Resource
    protected IStrategyRepository strategyRepository;
    /**
     * 查询策略配置信息
     *
     * @param strategyId 策略ID
     * @return 策略配置信息
     */
    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }
    /**
     * 查询奖品详情信息
     *
     * @param awardId 奖品ID
     * @return 中奖详情
     */
    protected Award queryAwardInfo(String awardId) {
        return  strategyRepository.queryAwardInfo(awardId);
    }



}
