package com.peanut.service;

import com.github.pagehelper.PageInfo;
import com.peanut.entity.vo.PlanVO;
import com.peanut.myUtils.ResultEntity;

import java.util.List;

/**
 * @author 小可耐
 */
public interface PlanService {
    /**
     * 获取分页的PageInfo对象
     * @param pageNum   当前页码
     * @param pageSize  当前页码的个数
     * @param id        用户的id
     * @return
     */
    PageInfo<PlanVO> getPagePlanVOList(Integer pageNum,Integer pageSize,Integer id);

    /**
     * 根据id删除计划
     * @param id
     * @return
     */
    void removePlanById(Integer id);

    /**
     * 根据前台传回来的计划和memberid保存plan
     * @param planVO
     * @param memberVOId
     */
    void savePlanVO(PlanVO planVO, Integer memberVOId);

    /**
     * 更新计划表
     * @param planVO    接收的计划
     * @param memberId  用户id
     * @return
     */
    void updatePlan(PlanVO planVO, Integer memberId);
}
