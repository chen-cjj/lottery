package com.jun.lottery.domain.strategy.repository.impl;
/*
 * @author cjj
 * 提供仓储服务，可以认为是mvc中的service层，去调用dao方法
 * */

import com.jun.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.jun.lottery.domain.strategy.repository.IStrategyRepository;
import com.jun.lottery.infrastructure.dao.IAwardDao;
import com.jun.lottery.infrastructure.dao.IStrategyDao;
import com.jun.lottery.infrastructure.dao.IStrategyDetailDao;
import com.jun.lottery.infrastructure.po.Award;
import com.jun.lottery.infrastructure.po.Strategy;
import com.jun.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 策略表仓储服务
 * @author：小傅哥，微信：fustack
 * @date: 2021/8/28
 * @Copyright：公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetailList);
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }

    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId) {
        return strategyDetailDao.queryNoStockStrategyAwardList(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail req = new StrategyDetail();
        req.setStrategyId(strategyId);
        req.setAwardId(awardId);
        int count = strategyDetailDao.deductStock(req);
        return count == 1;
    }

}
