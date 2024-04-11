package com.jun.lottery.infrastructure.dao;

import com.jun.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

/*
 * @author cjj
 * */
@Mapper
public interface IAwardDao {
    Award queryAwardInfo(String awardId);
}
