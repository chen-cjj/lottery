package com.jun.lottery.domain.strategy.model.aggregates;
/*
 * @author cjj
 * */

import com.jun.lottery.domain.strategy.model.vo.StrategyBriefVO;
import com.jun.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
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
    private StrategyBriefVO strategy;
    /**
     * 策略明细
     */
    private List<StrategyDetailBriefVO> strategyDetailList;
}
