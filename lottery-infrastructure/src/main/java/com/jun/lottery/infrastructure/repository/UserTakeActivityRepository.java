package com.jun.lottery.infrastructure.repository;
/*
 * @author cjj
 * */

import com.jun.lottery.domain.activity.repository.IUserTakeActivityRepository;
import com.jun.lottery.infrastructure.dao.IUserTakeActivityCountDao;
import com.jun.lottery.infrastructure.dao.IUserTakeActivityDao;
import com.jun.lottery.infrastructure.po.UserTakeActivity;
import com.jun.lottery.infrastructure.po.UserTakeActivityCount;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class UserTakeActivityRepository implements IUserTakeActivityRepository {
    @Resource
    IUserTakeActivityCountDao userTakeActivityCountDao;
    @Resource
    IUserTakeActivityDao userTakeActivityDao;
    @Override
    public int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date partakeDate) {
        UserTakeActivityCount userTakeActivityCount = new UserTakeActivityCount();
        if(userTakeLeftCount==null) {
            // 该用户还没参加过活动
            userTakeActivityCount.setActivityId(activityId);
            userTakeActivityCount.setTotalCount(takeCount);
            userTakeActivityCount.setLeftCount(takeCount-1);
            userTakeActivityCount.setuId(uId);
            userTakeActivityCountDao.insert(userTakeActivityCount);
            return 1;
        } else {
            // 扣除该用户的一次参与次数
            userTakeActivityCount.setuId(uId);
            userTakeActivityCount.setActivityId(activityId);
            return userTakeActivityCountDao.updateLeftCount(userTakeActivityCount);
        }
    }

    @Override
    public void takeActivity(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId) {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setuId(uId);
        userTakeActivity.setTakeId(takeId);
        userTakeActivity.setActivityId(activityId);
        userTakeActivity.setActivityName(activityName);
        userTakeActivity.setTakeDate(takeDate);
        if(userTakeLeftCount==null)  {
            // 未参与过
            userTakeActivity.setTakeCount(1);
        } else {
            userTakeActivity.setTakeCount(takeCount-userTakeLeftCount);
        }
        String uuid = uId + "_" + activityId + "_" + userTakeActivity.getTakeCount();
        userTakeActivity.setUuid(uuid);

        userTakeActivityDao.insert(userTakeActivity);
    }
}
