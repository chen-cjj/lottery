package com.jun.lottery.domain.award.service.factory;
/*
 * @author cjj
 * */

import com.jun.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

@Service
public class DistributionGoodsFactory extends GoodsConfig {
    public IDistributionGoods getIDistributionGoods(Integer awardType) {
        return goodsMap.get(awardType);
    }
}
