package com.jun.lottery.domain.strategy.repository;
/*
 * @author cjj
 * 提供仓储服务，可以认为是mvc中的service层，去调用dao方法
 * */

import com.jun.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.jun.lottery.infrastructure.po.Award;

import java.util.List;

/**
 * @description: 策略表仓储服务
 * @author：小傅哥，微信：fustack
 * @date: 2021/8/28
 * @Copyright：公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return           扣减结果
     */
    boolean deductStock(Long strategyId, String awardId);

}
