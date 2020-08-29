package com.peanut.mapper;



import com.peanut.entity.po.MemberWalletPO;
import com.peanut.entity.po.MemberWalletPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberWalletPOMapper {
    int countByExample(MemberWalletPOExample example);

    int deleteByExample(MemberWalletPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberWalletPO record);

    int insertSelective(MemberWalletPO record);

    List<MemberWalletPO> selectByExample(MemberWalletPOExample example);

    MemberWalletPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberWalletPO record, @Param("example") MemberWalletPOExample example);

    int updateByExample(@Param("record") MemberWalletPO record, @Param("example") MemberWalletPOExample example);

    int updateByPrimaryKeySelective(MemberWalletPO record);

    int updateByPrimaryKey(MemberWalletPO record);
}