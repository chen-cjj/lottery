package com.jun.lottery.domain.rule.service.logic;
/*
 * @author cjj
 * */

import com.jun.lottery.common.Constants;
import com.jun.lottery.domain.rule.model.req.DecisionMatterReq;
import com.jun.lottery.domain.rule.model.vo.TreeNodeLineVO;

import java.util.List;

public abstract class BaseLogic implements LogicFilter{

    /**
     *
     * @param matterValue          决策值
     * @param treeNodeLineInfoList 决策节点 所有和他相连的线
     * @return 下一个节点
     * 只要由满足的决策就向下走
     */
    @Override
    public Long filter(String matterValue, List<TreeNodeLineVO> treeNodeLineInfoList) {
        for (TreeNodeLineVO nodeLine : treeNodeLineInfoList) {
            if(decisionLogic(matterValue,nodeLine)) {
                return nodeLine.getNodeIdTo();
            }
        }
        return Constants.Global.TREE_NULL_NODE;
    }

    /**
     * 获取规则比对值
     * @param decisionMatter 决策物料
     * @return 比对值
     */
    @Override
    public abstract String matterValue(DecisionMatterReq decisionMatter);

    /**
     *
     * @param matterValue 比较的值如男，女，18，20等
     * @param nodeLine 当前比较的nodeLine
     * @return
     */
    private boolean decisionLogic(String matterValue, TreeNodeLineVO nodeLine) {
        switch (nodeLine.getRuleLimitType()) {
            case Constants.RuleLimitType.EQUAL:
                return matterValue.equals(nodeLine.getRuleLimitValue());
            case Constants.RuleLimitType.GT:
                return Double.parseDouble(matterValue) > Double.parseDouble(nodeLine.getRuleLimitValue());
            case Constants.RuleLimitType.LT:
                return Double.parseDouble(matterValue) < Double.parseDouble(nodeLine.getRuleLimitValue());
            case Constants.RuleLimitType.GE:
                return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLine.getRuleLimitValue());
            case Constants.RuleLimitType.LE:
                return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLine.getRuleLimitValue());
            default:
                return false;
        }
    }
}
