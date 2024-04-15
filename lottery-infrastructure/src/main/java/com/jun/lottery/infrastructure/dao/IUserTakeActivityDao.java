package com.jun.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import com.jun.lottery.infrastructure.po.UserTakeActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 用户领取活动表DAO
 * @author: 小傅哥，微信：fustack
 * @date: 2021/9/22
 * @github: https://github.com/fuzhengwei
 * @Copyright: 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Mapper
public interface IUserTakeActivityDao {

    /**
     * 插入用户领取活动信息
     *
     * @param userTakeActivity 入参
     */
    @DBRouter(key = "uId")
    void insert(UserTakeActivity userTakeActivity);

}
