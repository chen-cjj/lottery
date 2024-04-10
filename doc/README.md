# 笔记

- 第 1 节：

## 1. 构建框架

分支：210804_xfg_buildFramework
内容：通过创建第一个活动表信息，对框架引入相应的技术栈，完成CRUD操作

```sql
create table activity
(
    id bigint auto_increment comment '自增ID' primary key,
    activityId bigint null comment '活动ID',
    beginDateTime datetime not null comment '开始时间',
    endDateTime datetime not null comment '结束时间',
    stockCount int not null comment '库存',
    takeCount int null comment '每人可参与次数',
    state int null comment '活动状态：编辑、提审、撤审、通过、运行、拒绝、关闭、开启',
    creator varchar(64) not null comment '创建人',
    activityName varchar(64) not null comment '活动名称',
    activityDesc varchar(128) null comment '活动描述',
    createTime datetime not null comment '创建时间',
    updateTime datetime not null comment '修改时间'
);

create unique index activity_id_uindex
    on activity (id);
```