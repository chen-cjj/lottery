package com.jun.lottery.domain.strategy.service.draw;
/*
 * @author cjj
 * 抽奖执行接口
 * */

import com.jun.lottery.domain.strategy.model.req.DrawReq;
import com.jun.lottery.domain.strategy.model.res.DrawResult;

public interface IDrawExec {
    // 抽奖执行
    DrawResult doDrawExec(DrawReq req);
}
