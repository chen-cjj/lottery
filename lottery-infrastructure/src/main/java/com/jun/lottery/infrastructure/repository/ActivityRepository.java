package com.jun.lottery.infrastructure.repository;
/*
 * @author cjj
 * */

import com.jun.lottery.common.Constants;
import com.jun.lottery.domain.activity.model.vo.*;
import com.jun.lottery.domain.activity.repository.IActivityRepository;
import com.jun.lottery.infrastructure.dao.IActivityDao;
import com.jun.lottery.infrastructure.dao.IAwardDao;
import com.jun.lottery.infrastructure.dao.IStrategyDao;
import com.jun.lottery.infrastructure.dao.IStrategyDetailDao;
import com.jun.lottery.infrastructure.po.Activity;
import com.jun.lottery.infrastructure.po.Award;
import com.jun.lottery.infrastructure.po.Strategy;
import com.jun.lottery.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Component
public class ActivityRepository implements IActivityRepository {

    @Resource
    IActivityDao activityDao;
    @Resource
    IAwardDao awardDao;
    @Resource
    IStrategyDao strategyDao;
    @Resource
    IStrategyDetailDao strategyDetailDao;

    @Override
    public void addActivity(ActivityVO activity) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activity, req);
        activityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> awards = new ArrayList<>();
        for (AwardVO awardVO : awardList) {
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            awards.add(award);
        }
        awardDao.insertList(awards);
    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategy, req);
        strategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> req = new ArrayList<>();
        for (StrategyDetailVO strategyDetailVO : strategyDetailList) {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            req.add(strategyDetail);
        }
        strategyDetailDao.insertStrategyDetail(req);
    }

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState) {
        AlterStateVO stateVO = new AlterStateVO(activityId,((Constants.ActivityState)beforeState).getCode(), ((Constants.ActivityState)afterState).getCode());
        return activityDao.alterState(stateVO)==1;
    }
}
