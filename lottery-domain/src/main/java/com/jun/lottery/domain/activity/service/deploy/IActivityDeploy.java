package com.jun.lottery.domain.activity.service.deploy;
/*
 * @author cjj
 * */

import com.jun.lottery.domain.activity.model.req.ActivityConfigReq;

public interface IActivityDeploy {
    // 创建活动
    void createActivity(ActivityConfigReq req);
    // 修改活动
    void updateActivity(ActivityConfigReq req);
}
