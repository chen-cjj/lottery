package com.jun.lottery.domain.rule.service.engine.impl;

import com.jun.lottery.domain.rule.model.aggregates.TreeRuleRich;
import com.jun.lottery.domain.rule.model.req.DecisionMatterReq;
import com.jun.lottery.domain.rule.model.res.EngineResult;
import com.jun.lottery.domain.rule.model.vo.TreeNodeVO;
import com.jun.lottery.domain.rule.repository.IRuleRepository;
import com.jun.lottery.domain.rule.service.engine.EngineBase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 规则引擎处理器
 * @author: 小傅哥，微信：fustack
 * @date: 2021/10/8
 * @github: https://github.com/fuzhengwei
 * @Copyright: 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Service
public class RuleEngineHandle extends EngineBase {

    @Resource
    private IRuleRepository ruleRepository;

    // 执行决策过程方法
    @Override
    public EngineResult process(DecisionMatterReq matter) {
        // 获取决策规则树
        TreeRuleRich treeRuleRich = ruleRepository.queryTreeRuleRich(matter.getTreeId());
        if (null == treeRuleRich) {
            throw new RuntimeException("Tree Rule is null!");
        }

        // 获取决策节点（获取可以参与的活动id）
        TreeNodeVO treeNodeInfo = engineDecisionMaker(treeRuleRich, matter);

        // 决策结果（得到最终可以参与的活动id）
        return new EngineResult(matter.getUserId(), treeNodeInfo.getTreeId(), treeNodeInfo.getTreeNodeId(), treeNodeInfo.getNodeValue());
    }

}
