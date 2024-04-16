package com.jun.lottery.application;
/*
 * @author cjj
 * */
import org.junit.Test;
import com.alibaba.fastjson.JSON;
import com.jun.lottery.application.process.IActivityProcess;
import com.jun.lottery.application.process.req.DrawProcessReq;
import com.jun.lottery.application.process.res.DrawProcessResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityProcessTest {
    @Resource
    private IActivityProcess activityProcess;

    @Test
    public void test_doDrawProcess() {
        DrawProcessReq req = new DrawProcessReq();
        req.setuId("fustack");
        req.setActivityId(100001L);
        DrawProcessResult drawProcessResult = activityProcess.doDrawProcess(req);

        log.info("请求入参：{}", JSON.toJSONString(req));
        log.info("测试结果：{}", JSON.toJSONString(drawProcessResult));
    }

}
