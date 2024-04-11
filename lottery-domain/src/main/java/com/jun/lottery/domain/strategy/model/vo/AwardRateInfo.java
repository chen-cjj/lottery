package com.jun.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/*
 * @author cjj
 * */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AwardRateInfo {
    // 奖品ID
    private String awardId;
    // 中奖概率
    private BigDecimal awardRate;
}
