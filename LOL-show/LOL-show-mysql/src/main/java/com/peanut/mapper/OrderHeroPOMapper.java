package com.peanut.mapper;

import com.peanut.entity.po.OrderHeroPO;
import com.peanut.entity.po.OrderHeroPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderHeroPOMapper {
    int countByExample(OrderHeroPOExample example);

    int deleteByExample(OrderHeroPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderHeroPO record);

    int insertSelective(OrderHeroPO record);

    List<OrderHeroPO> selectByExample(OrderHeroPOExample example);

    OrderHeroPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderHeroPO record, @Param("example") OrderHeroPOExample example);

    int updateByExample(@Param("record") OrderHeroPO record, @Param("example") OrderHeroPOExample example);

    int updateByPrimaryKeySelective(OrderHeroPO record);

    int updateByPrimaryKey(OrderHeroPO record);

    void deleteOrderByList(@Param("heroIdList") List<Integer> heroIdList,@Param("id") Integer id);
}