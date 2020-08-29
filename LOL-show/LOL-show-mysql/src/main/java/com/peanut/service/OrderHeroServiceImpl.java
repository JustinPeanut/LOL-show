package com.peanut.service;

import com.peanut.entity.po.OrderHeroPO;
import com.peanut.entity.po.OrderHeroPOExample;
import com.peanut.entity.vo.OrderHeroInPageVO;
import com.peanut.entity.vo.OrderHeroVO;
import com.peanut.mapper.OrderHeroPOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
public class OrderHeroServiceImpl implements OrderHeroService {
    @Autowired
    private OrderHeroPOMapper orderHeroPOMapper;

    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public void saveOrderHero(OrderHeroVO orderHeroVO, Integer id) {
        // 首先查询出该用户的所有的订单
        OrderHeroPOExample example = new OrderHeroPOExample();
        OrderHeroPOExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(id);
        List<OrderHeroPO> orderHeroPOS = orderHeroPOMapper.selectByExample(example);
        // 创建一个list集合存储这个用户已经购买的英雄id
        List<Integer> heroIdlist = new ArrayList<>();
        for(OrderHeroPO heroPO : orderHeroPOS){
            heroIdlist.add(heroPO.getHeroId());
        }
        if(heroIdlist.contains(orderHeroVO.getId())){
            throw new DuplicateKeyException("该物品只能购买一次");
        }
        // 赋值
        OrderHeroPO orderHeroPO = new OrderHeroPO();
        orderHeroPO.setMemberId(id);
        String fullName = orderHeroVO.getFullName();
        String nickName = orderHeroVO.getNickName();
        String orderName = fullName+" "+nickName;
        orderHeroPO.setOrderName(orderName);
        orderHeroPO.setOrderPic(orderHeroVO.getImgScot());
        orderHeroPO.setOrderPrice(orderHeroVO.getPrice());
        orderHeroPO.setPurchaseLimit(orderHeroVO.getIsRetail());
        orderHeroPO.setHeroId(orderHeroVO.getId());
        // 保存
        orderHeroPOMapper.insert(orderHeroPO);
    }

    @Override
    public List<OrderHeroInPageVO> getOrderHeroList(Integer id) {
        OrderHeroPOExample example = new OrderHeroPOExample();
        OrderHeroPOExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(id);
        List<OrderHeroPO> orderHeroPOS = orderHeroPOMapper.selectByExample(example);
        List<OrderHeroInPageVO> result = new ArrayList<>();
        for(OrderHeroPO orderHeroPO : orderHeroPOS){
            OrderHeroInPageVO orderHeroInPageVO = new OrderHeroInPageVO();
            BeanUtils.copyProperties(orderHeroPO,orderHeroInPageVO);
            result.add(orderHeroInPageVO);
        }
        return result;
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void removeHeroByHeroId(Integer heroId) {
        OrderHeroPOExample example = new OrderHeroPOExample();
        OrderHeroPOExample.Criteria criteria = example.createCriteria();
        criteria.andHeroIdEqualTo(heroId);
        orderHeroPOMapper.deleteByExample(example);
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void removeHeroByHeroIdList(List<Integer> heroIdList,Integer id) {
        orderHeroPOMapper.deleteOrderByList(heroIdList,id);
    }
}
