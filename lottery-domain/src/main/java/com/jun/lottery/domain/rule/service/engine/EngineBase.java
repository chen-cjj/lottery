package com.jun.lottery.domain.rule.service.engine;

import com.jun.lottery.common.Constants;
import com.jun.lottery.domain.rule.model.aggregates.TreeRuleRich;
import com.jun.lottery.domain.rule.model.req.DecisionMatterReq;
import com.jun.lottery.domain.rule.model.res.EngineResult;
import com.jun.lottery.domain.rule.model.vo.TreeNodeVO;
import com.jun.lottery.domain.rule.model.vo.TreeRootVO;
import com.jun.lottery.domain.rule.service.logic.LogicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @description: 规则引擎基础类
 * @author: 小傅哥，微信：fustack
 * @date: 2021/10/8
 * @github: https://github.com/fuzhengwei
 * @Copyright: 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public abstract class EngineBase extends EngineConfig implements EngineFilter {

    private Logger logger = LoggerFactory.getLogger(EngineBase.class);

    @Override
    public EngineResult process(DecisionMatterReq matter) {
        throw new RuntimeException("未实现规则引擎服务");
    }

    protected TreeNodeVO engineDecisionMaker(TreeRuleRich treeRuleRich, DecisionMatterReq matter) {
        TreeRootVO treeRoot = treeRuleRich.getTreeRoot();
        Map<Long, TreeNodeVO> treeNodeMap = treeRuleRich.getTreeNodeMap();
        // 规则树根ID
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        TreeNodeVO treeNodeInfo = treeNodeMap.get(rootNodeId);
        // 节点类型[NodeType]；1子叶、2果实
        // 当不是叶子节点时，表示还要参与决策，继续向下走
        while (Constants.NodeType.STEM.equals(treeNodeInfo.getNodeType())) {
            String ruleKey = treeNodeInfo.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(matter);
            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLineInfoList());
            treeNodeInfo = treeNodeMap.get(nextNode);
            logger.info("treeNodeInfo:", treeNodeInfo);
//            logger.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(), matter.getUserId(), matter.getTreeId(), treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }
        // 返回当前的果实节点，也就是可以参与的活动
        return treeNodeInfo;
    }

}
