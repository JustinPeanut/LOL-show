package com.peanut.service;

import com.peanut.entity.vo.OrderHeroInPageVO;
import com.peanut.entity.vo.OrderHeroVO;

import java.util.List;

public interface OrderHeroService {

    /**
     * 保存orderHeroVO
     * @param orderHeroVO
     * @param id
     */
    void saveOrderHero(OrderHeroVO orderHeroVO, Integer id);

    /**
     * 根据用户id查询其id
     * @param id
     * @return
     */
    List<OrderHeroInPageVO> getOrderHeroList(Integer id);

    /**
     * 根据heroId删除订单
     * @param heroId
     */
    void removeHeroByHeroId(Integer heroId);

    /**
     * 批量删除已经支付的订单
     * @param heroIdList
     * @param id
     */
    void removeHeroByHeroIdList(List<Integer> heroIdList , Integer id);
}
