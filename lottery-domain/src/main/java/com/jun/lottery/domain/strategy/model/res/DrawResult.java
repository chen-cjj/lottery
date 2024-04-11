package com.jun.lottery.domain.strategy.model.res;
/*
 * @author cjj
 * */

import com.jun.lottery.common.Constants;
import com.jun.lottery.domain.strategy.model.vo.DrawAwardInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DrawResult {
    // 用户id
    private String uId;
    // 策略id
    private Long strategyId;
    // 中奖状态：0未中奖、1已中奖、2兜底奖 Constants.DrawState
    private Integer drawState = Constants.DrawState.FAIL.getCode();
    // 中奖奖品信息
    DrawAwardInfo drawAwardInfo;

    public DrawResult(String uId, Long strategyId, Integer drawState) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }
}
