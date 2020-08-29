package com.peanut.mapper;

import com.peanut.entity.po.PlanPO;
import com.peanut.entity.po.PlanPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanPOMapper {
    int countByExample(PlanPOExample example);

    int deleteByExample(PlanPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlanPO record);

    int insertSelective(PlanPO record);

    List<PlanPO> selectByExample(PlanPOExample example);

    PlanPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlanPO record, @Param("example") PlanPOExample example);

    int updateByExample(@Param("record") PlanPO record, @Param("example") PlanPOExample example);

    int updateByPrimaryKeySelective(PlanPO record);

    int updateByPrimaryKey(PlanPO record);
}