package com.peanut.mapper;

import com.peanut.entity.po.WalletOrderPO;
import com.peanut.entity.po.WalletOrderPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WalletOrderPOMapper {
    int countByExample(WalletOrderPOExample example);

    int deleteByExample(WalletOrderPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WalletOrderPO record);

    int insertSelective(WalletOrderPO record);

    List<WalletOrderPO> selectByExample(WalletOrderPOExample example);

    WalletOrderPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WalletOrderPO record, @Param("example") WalletOrderPOExample example);

    int updateByExample(@Param("record") WalletOrderPO record, @Param("example") WalletOrderPOExample example);

    int updateByPrimaryKeySelective(WalletOrderPO record);

    int updateByPrimaryKey(WalletOrderPO record);
}