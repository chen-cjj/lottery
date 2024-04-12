package com.jun.lottery.domain.award.service.factory;
/*
 * @author cjj
 * */

import com.jun.lottery.common.Constants;
import com.jun.lottery.domain.award.service.goods.IDistributionGoods;
import com.jun.lottery.domain.award.service.goods.impl.CouponGoods;
import com.jun.lottery.domain.award.service.goods.impl.DescGoods;
import com.jun.lottery.domain.award.service.goods.impl.PhysicalGoods;
import com.jun.lottery.domain.award.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
* 管理奖品
* */
public class GoodsConfig {
    // 存放四种奖品和id
    protected static Map<Integer,IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    CouponGoods couponGoods;
    @Resource
    DescGoods descGoods;
    @Resource
    PhysicalGoods physicalGoods;
    @Resource
    RedeemCodeGoods redeemCodeGoods;
    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardType.DESC.getCode(),descGoods);
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
    }
}
