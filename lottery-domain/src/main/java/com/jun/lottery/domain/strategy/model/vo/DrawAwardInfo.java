package com.jun.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DrawAwardInfo {

    // 奖品ID
    private String rewardId;

    // 奖品名称
    private String awardName;
}
