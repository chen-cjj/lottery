package com.jun.lottery.domain.activity.model.res;
/*
 * @author cjj
 * */

import com.jun.lottery.common.Result;

public class PartakeResult extends Result {
    /**
     * 策略ID
     */
    private Long strategyId;

    public PartakeResult(String code, String info, Long strategyId) {
        super(code, info);
        this.strategyId = strategyId;
    }

    public PartakeResult(String code, String info) {
        super(code, info);
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
}
