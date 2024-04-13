package com.jun.lottery.domain.activity.service.deploy.impl;
/*
 * @author cjj
 * */

import com.alibaba.fastjson.JSON;
import com.jun.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.jun.lottery.domain.activity.model.req.ActivityConfigReq;
import com.jun.lottery.domain.activity.repository.IActivityRepository;
import com.jun.lottery.domain.activity.service.deploy.IActivityDeploy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class ActivityDeployImpl implements IActivityDeploy {

    @Resource
    private IActivityRepository activityRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createActivity(ActivityConfigReq req) {
        try {
            ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
            Long activityId = activityConfigRich.getActivity().getActivityId();
            log.info("配置活动开始:{}",activityId);
            //  活动配置
            activityRepository.addActivity(activityConfigRich.getActivity());
            //  策略配置(含策略明细)
            activityRepository.addStrategy(activityConfigRich.getStrategy());
            // 奖品配置
            activityRepository.addAward(activityConfigRich.getAwardList());
            // 详细策略配置
            activityRepository.addStrategyDetailList(activityConfigRich.getStrategy().getStrategyDetailList());
            log.info("配置活动结束:{}",activityId);
        } catch (DuplicateKeyException e) {
            log.error("创建活动配置失败，唯一索引冲突 activityId：{} reqJson：{}", req.getActivityId(), JSON.toJSONString(req), e);
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq req) {
        // 后续补充
    }
}
