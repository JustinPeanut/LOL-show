package com.peanut.service;

import com.github.pagehelper.PageInfo;
import com.peanut.entity.vo.*;

import java.util.List;

public interface HeroService {

    /**
     * 获取主页的大图
     * @return
     */
    PageInfo<HeroPortalVO> getPortalPageInfo();

    /**
     * 获取英雄页面的所有英雄
     * @return
     */
    List<HeroPageVO> getAllHero();

    /**
     * 根据typeId查询hero
     * @return
     */
    List<HeroPageVO> getHeroByType(Integer id);

    /**
     * 根据name关键词查询hero
     * @param name
     * @return
     */
    List<HeroPageVO> getHeroByName(String name);

    /**
     * 根据id获取英雄详情的hero
     * @param id
     * @return
     */
    HeroDetailVO getHeroDetailById(Integer id);

    /**
     * 查询热门销量
     * @return
     */
    List<ScotHeroVO> getScotHero();

    /**
     * 分页显示Stick
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<StickHeroVO> getStickHeroByPage(Integer pageNum, Integer pageSize);

    /**
     * 通过typeId查询StickHero并且分页
     * @param pageNum
     * @param pageSize
     * @param typeId
     * @return
     */
    PageInfo<StickHeroVO> getStickByType(Integer pageNum, Integer pageSize, Integer typeId);

    /**
     * 根据首字母查询英雄并且分页
     * @param pageNum
     * @param pageSize
     * @param prefixLetter
     * @return
     */
    PageInfo<StickHeroVO> getHeroPrefixLetter(Integer pageNum, Integer pageSize, String prefixLetter,Integer typeId);

    /**
     * 根据不同的情况查询英雄stick
     * @param keyword
     * @param lowPrice
     * @param highPrice
     * @param typeId
     * @return
     */
    PageInfo<StickHeroVO> getHeroByCommitCondition(Integer pageNum, Integer pageSize, String keyword, double lowPrice, double highPrice, Integer typeId);

    /**
     * 根据id查询英雄cart
     * @param id
     * @return
     */
    CartHeroVO getCartHeroById(Integer id);

    /**
     * 获取将要被放入购物车的hero对象
     * @param heroId
     * @return
     */
    OrderHeroVO getOrderHeroVO(Integer heroId);

    /**
     * 通过用户id获取已经拥有的英雄
     * @param id
     * @return
     */
    List<HeroMemberOwnVO> getOwnHero(Integer id);

    /**
     * 为英雄的购买次数增加1
     * @param heroIdList
     */
    void addHeroPurchseNum(List<Integer> heroIdList);
}
