package com.jun.lottery.infrastructure.dao;

import com.jun.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

/*
 * @author cjj
 * */
@Mapper
public interface IStrategyDao {
    Strategy queryStrategy(Long strategyId);
}
