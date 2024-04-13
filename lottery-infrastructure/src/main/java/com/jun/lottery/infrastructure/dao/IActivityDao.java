package com.jun.lottery.infrastructure.dao;


import com.jun.lottery.domain.activity.model.vo.AlterStateVO;
import com.jun.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 活动基础信息表DAO
 * @author: 小傅哥，微信：fustack
 * @date: 2021/9/4
 * @github: https://github.com/fuzhengwei
 * @Copyright: 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Mapper
public interface IActivityDao {

   /**
    * 插入数据，新增活动
    * @param req 入参
    */
   void insert(Activity req);

   /**
    * 根据活动号查询活动信息
    *
    * @param activityId 活动号
    * @return           活动信息
    */
   Activity queryActivityById(Long activityId);

   /**
    * 变更活动状态
    *
    * @param alterStateVO  [activityId、beforeState、afterState]
    * @return 更新数量
    */
   int alterState(AlterStateVO alterStateVO);

}
