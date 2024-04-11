package com.jun.lottery.domain.strategy.model.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * @author cjj
 * */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DrawReq {
    // 用户id
    private String uId;
    // 策略id
    private Long strategyId;
}
