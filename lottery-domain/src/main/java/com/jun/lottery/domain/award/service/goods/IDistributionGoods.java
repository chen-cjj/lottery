package com.jun.lottery.domain.award.service.goods;
/*
 * @author cjj
 * */

import com.jun.lottery.domain.award.model.req.GoodsReq;
import com.jun.lottery.domain.award.model.res.DistributionRes;

public interface IDistributionGoods {
    // 执行发奖方法
    DistributionRes doDistribution(GoodsReq req);

    // 获取抽奖商品名字
    Integer getDistributionGoodsName();
}
