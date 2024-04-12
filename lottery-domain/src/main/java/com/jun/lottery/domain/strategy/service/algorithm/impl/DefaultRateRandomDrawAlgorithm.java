package com.jun.lottery.domain.strategy.service.algorithm.impl;
/*
 * @author cjj
 * */

import com.jun.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.jun.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        // 剩下的奖品的中奖几率和
        BigDecimal differenceDenominator = BigDecimal.ZERO;
        // 当前策略的奖品的信息
        List<AwardRateInfo> awardRateInfoList = super.awardRateInfoMap.get(strategyId);
        List<AwardRateInfo> differenceAwardRateList = new ArrayList();
        for (AwardRateInfo awardRateInfo : awardRateInfoList) {
            // 把库存不为0的放入新的list中，重新计算概率和执行抽奖
            BigDecimal awardRate = awardRateInfo.getAwardRate();
            if(excludeAwardIds.contains(awardRateInfo.getAwardId())) continue;
            differenceDenominator = differenceDenominator.add(awardRate);
            differenceAwardRateList.add(awardRateInfo);
        }
        if(differenceAwardRateList.size()==0) return "";
        if(differenceAwardRateList.size()==1) return differenceAwardRateList.get(0).getAwardId();

        // 重新计算概率和执行抽奖
        int randomValue = new SecureRandom().nextInt(100) + 1;
        int cursorVal = 0;
        String awardId = "";
        for (AwardRateInfo awardRateInfo : differenceAwardRateList) {
            int rateValue = awardRateInfo.getAwardRate().divide(differenceDenominator, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();
            // 当随机值落在某个奖品的概率范围内时，即确定抽中该奖品，并结束循环。
            if(randomValue<=cursorVal+rateValue) {
                awardId =  awardRateInfo.getAwardId();
                break;
            }
            cursorVal+=rateValue;
        }
        return awardId;
    }
}
