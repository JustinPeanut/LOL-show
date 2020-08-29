package com.peanut.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peanut.entity.po.PlanPO;
import com.peanut.entity.po.PlanPOExample;
import com.peanut.entity.vo.PlanVO;
import com.peanut.exception.UnKnowNetWorkException;
import com.peanut.mapper.PlanPOMapper;
import com.peanut.myUtils.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peanut
 */

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanPOMapper planPOMapper;

    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public PageInfo getPagePlanVOList(Integer pageNum, Integer pageSize, Integer id) {
        // 开启分页
        PageHelper.startPage(pageNum,pageSize);
        PlanPOExample example = new PlanPOExample();
        PlanPOExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(id);
        // 执行查询
        List<PlanPO> planPOList = planPOMapper.selectByExample(example);
        // 判断结果
        if(planPOList.size() == 0){
            throw new UnKnowNetWorkException("没有查询到任何数据，快去添加计划吧！");
        }
        // 结果正确就返回
        List<PlanVO> list = new ArrayList<>();
        for(PlanPO planPO : planPOList){
            PlanVO planVO = new PlanVO();
            BeanUtils.copyProperties(planPO,planVO);
            list.add(planVO);
        }
        // 封装PageInfo对象
        return new PageInfo(list);
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public void removePlanById(Integer id) {
        planPOMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public void savePlanVO(PlanVO planVO, Integer memberVOId) {
        // 创建一个PlanPO，准备存入数据库
        PlanPO planPO = new PlanPO();
        // 复制属性
        BeanUtils.copyProperties(planVO,planPO);
        // 设置memberId属性
        planPO.setMemberId(memberVOId);
        // 执行保存
        planPOMapper.insertSelective(planPO);

    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public void updatePlan(PlanVO planVO, Integer memberId) {
        // 创建更新的对象
        PlanPO planPO = new PlanPO();
        BeanUtils.copyProperties(planVO,planPO);
        planPO.setMemberId(memberId);
        planPOMapper.updateByPrimaryKeySelective(planPO);
    }
}
