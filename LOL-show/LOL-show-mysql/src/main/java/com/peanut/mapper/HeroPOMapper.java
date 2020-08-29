package com.peanut.mapper;

import com.peanut.entity.po.HeroPO;
import com.peanut.entity.po.HeroPOExample;
import com.peanut.entity.vo.HeroDetailVO;
import com.peanut.entity.vo.HeroMemberOwnVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HeroPOMapper {
    int countByExample(HeroPOExample example);

    int deleteByExample(HeroPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HeroPO record);

    int insertSelective(HeroPO record);

    List<HeroPO> selectByExampleWithBLOBs(HeroPOExample example);

    List<HeroPO> selectByExample(HeroPOExample example);

    HeroPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HeroPO record, @Param("example") HeroPOExample example);

    int updateByExampleWithBLOBs(@Param("record") HeroPO record, @Param("example") HeroPOExample example);

    int updateByExample(@Param("record") HeroPO record, @Param("example") HeroPOExample example);

    int updateByPrimaryKeySelective(HeroPO record);

    int updateByPrimaryKeyWithBLOBs(HeroPO record);

    int updateByPrimaryKey(HeroPO record);

    List<HeroPO> selectBigImgDesc();

    List<HeroPO> selectAll();

    List<HeroPO> selectByName(@Param("name") String name);

    HeroDetailVO getHeroDetail(@Param("id") Integer id);

    List<HeroPO> selectScotHero();

    List<HeroPO> selectAllStickHero();

    List<HeroPO> getStickHeroByType(@Param("typeId") Integer typeId);

    List<HeroPO> selectHeroByPrefixLetter(@Param("prefixLetter") String prefixLetter);

    List<HeroPO> selectHeroByPrefixLetterAndType(@Param("prefixLetter")String prefixLetter, @Param("typeId") Integer typeId);

    List<HeroPO> selectStickHeroByConditionAtType(
            @Param("keyword") String keyword,
            @Param("lowPrice") double lowPrice,
            @Param("highPrice") double highPrice,
            @Param("typeId") Integer typeId);

    List<HeroPO> selectStickHeroByConition(@Param("keyword") String keyword,@Param("lowPrice") double lowPrice, @Param("highPrice") double highPrice);

    HeroPO selectOrderHero(@Param("heroId") Integer heroId);

    List<HeroMemberOwnVO> getHeroOwnByMemberId(@Param("id") Integer id);
}