package com.jun.lottery.domain.strategy.model.aggregates;
/*
 * @author cjj
 * */

import com.jun.lottery.infrastructure.po.Strategy;
import com.jun.lottery.infrastructure.po.StrategyDetail;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StrategyRich {
    // 策略id
    private Long strategyId;
    // 策略配置
    private Strategy strategy;
    // 策略明细，一个策略配置对应n个策略明细
    private List<StrategyDetail>  strategyDetailList;
}
