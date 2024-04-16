package com.jun.lottery.application.process;
/*
 * @author cjj
 * */

import com.jun.lottery.application.process.req.DrawProcessReq;
import com.jun.lottery.application.process.res.DrawProcessResult;

public interface IActivityProcess {
    DrawProcessResult doDrawProcess(DrawProcessReq req);
}
