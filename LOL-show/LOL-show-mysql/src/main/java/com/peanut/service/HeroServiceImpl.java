package com.peanut.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peanut.entity.po.HeroPO;
import com.peanut.entity.po.HeroPOExample;
import com.peanut.entity.vo.*;
import com.peanut.exception.NoSuchHeroException;
import com.peanut.mapper.HeroPOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
public class HeroServiceImpl implements HeroService {
    @Autowired
    private HeroPOMapper heroPOMapper;

    @Override
    public PageInfo<HeroPortalVO> getPortalPageInfo() {
        PageHelper.startPage(1,5);
        List<HeroPO> heroPOList =  heroPOMapper.selectBigImgDesc();
        List<HeroPortalVO> result = new ArrayList<>();
        for(HeroPO heroPO : heroPOList){
            HeroPortalVO heroPortalVO = new HeroPortalVO();
            BeanUtils.copyProperties(heroPO,heroPortalVO);
            result.add(heroPortalVO);
        }
        return new PageInfo<>(result);
    }

    @Override
    public List<HeroPageVO> getAllHero() {
        List<HeroPO> poList = heroPOMapper.selectAll();
        List<HeroPageVO> result = new ArrayList<>();
        for(HeroPO heroPO : poList){
            HeroPageVO heroPageVO = new HeroPageVO();
            BeanUtils.copyProperties(heroPO,heroPageVO);
            result.add(heroPageVO);
        }
        return result;
    }

    @Override
    public List<HeroPageVO> getHeroByType(Integer id) {
        HeroPOExample example = new HeroPOExample();
        HeroPOExample.Criteria criteria = example.createCriteria();
        String typeId = id.toString();
        criteria.andHeroTypeIdEqualTo(typeId);
        List<HeroPO> heroPOList = heroPOMapper.selectByExample(example);
        // 创建一个集合用于接收复制的属性类
        List<HeroPageVO> result = new ArrayList<>();
        for(HeroPO heroPO : heroPOList){
            HeroPageVO heroPageVO = new HeroPageVO();
            BeanUtils.copyProperties(heroPO,heroPageVO);
            result.add(heroPageVO);
        }
        return result;
    }

    @Override
    public List<HeroPageVO> getHeroByName(String name) {
        // 根据关键词查询
        List<HeroPO> heroPOList = heroPOMapper.selectByName(name);
        if(heroPOList == null || heroPOList.size() == 0){
            throw new NoSuchHeroException("没有查询到任何匹配的英雄");
        }
        // 创建将要返回的结果集合
        List<HeroPageVO> result = new ArrayList<>();
        // 复制属性
        for(HeroPO heroPO : heroPOList){
            HeroPageVO heroPageVO = new HeroPageVO();
            BeanUtils.copyProperties(heroPO,heroPageVO);
            result.add(heroPageVO);
        }
        return result;
    }

    @Override
    public HeroDetailVO getHeroDetailById(Integer id) {
        return heroPOMapper.getHeroDetail(id);
    }

    @Override
    public List<ScotHeroVO> getScotHero() {
        // 开启分页
        PageHelper.startPage(1,10);
        List<HeroPO> heroPOList =  heroPOMapper.selectScotHero();
        List<ScotHeroVO> result = new ArrayList<>();
        for(HeroPO heroPO : heroPOList){
            ScotHeroVO scotHeroVO = new ScotHeroVO();
            BeanUtils.copyProperties(heroPO,scotHeroVO);
            result.add(scotHeroVO);
        }
        // 如果没有查询到数据，抛出异常
        if(result == null || result.size() == 0){
            throw new NoSuchHeroException("没有查询到任何热点英雄");
        }
        return result;
    }


    @Override
    public PageInfo<StickHeroVO> getStickHeroByPage(Integer pageNum, Integer pageSize) {
        // pageSize为0的时候表示获取所有的数据，其实当前语句可有可无
        PageHelper.startPage(pageNum,pageSize);
        // 查询
        List<HeroPO> heroPOList = heroPOMapper.selectAllStickHero();
        List<StickHeroVO> result = new ArrayList<>();
        // 复制属性
        for(HeroPO heroPO : heroPOList){
            StickHeroVO stickHeroVO = new StickHeroVO();
            BeanUtils.copyProperties(heroPO,stickHeroVO);
            result.add(stickHeroVO);
        }
        return new PageInfo<>(result);
    }

    @Override
    public PageInfo<StickHeroVO> getStickByType(Integer pageNum, Integer pageSize, Integer typeId) {
        PageHelper.startPage(pageNum,pageSize);
        List<HeroPO> heroPOList = heroPOMapper.getStickHeroByType(typeId);
        List<StickHeroVO> result = new ArrayList<>();
        for(HeroPO heroPO : heroPOList){
            StickHeroVO stickHeroVO = new StickHeroVO();
            BeanUtils.copyProperties(heroPO,stickHeroVO);
            result.add(stickHeroVO);
        }
        return new PageInfo<>(result);
    }

    @Override
    public PageInfo<StickHeroVO> getHeroPrefixLetter(Integer pageNum, Integer pageSize, String prefixLetter,Integer typeId) {
        PageHelper.startPage(pageNum,pageSize);
        List<HeroPO> heroPOList;
        if(typeId != 0){
             heroPOList = heroPOMapper.selectHeroByPrefixLetterAndType(prefixLetter,typeId);
        }else{
             heroPOList =  heroPOMapper.selectHeroByPrefixLetter(prefixLetter);
        }
        List<StickHeroVO> result = new ArrayList<>();
        for(HeroPO heroPO : heroPOList){
            StickHeroVO stickHeroVO = new StickHeroVO();
            BeanUtils.copyProperties(heroPO,stickHeroVO);
            result.add(stickHeroVO);
        }
        return new PageInfo<>(result);
    }

    @Override
    public PageInfo<StickHeroVO> getHeroByCommitCondition(Integer pageNum, Integer pageSize, String keyword, double lowPrice, double highPrice, Integer typeId) {
        PageHelper.startPage(pageNum,pageSize);
        List<HeroPO> heroPOList;
        // 如果如果制定了类型，添加type筛选
        if(typeId > 0){
            heroPOList = heroPOMapper.selectStickHeroByConditionAtType(keyword,lowPrice,highPrice,typeId);
        }else{
            heroPOList = heroPOMapper.selectStickHeroByConition(keyword,lowPrice,highPrice);
        }

        List<StickHeroVO> result = new ArrayList<>();
        for(HeroPO heroPO : heroPOList){
            StickHeroVO stickHeroVO = new StickHeroVO();
            BeanUtils.copyProperties(heroPO,stickHeroVO);
            result.add(stickHeroVO);
        }
        return new PageInfo<>(result);
    }

    @Override
    public CartHeroVO getCartHeroById(Integer id) {
        HeroPO heroPO = heroPOMapper.selectByPrimaryKey(id);
        CartHeroVO cartHeroVO = new CartHeroVO();
        BeanUtils.copyProperties(heroPO,cartHeroVO);
        return cartHeroVO;
    }

    @Override
    public OrderHeroVO getOrderHeroVO(Integer heroId) {
        HeroPO heroPO = heroPOMapper.selectOrderHero(heroId);
        OrderHeroVO orderHeroVO = new OrderHeroVO();
        BeanUtils.copyProperties(heroPO,orderHeroVO);
        orderHeroVO.setIsRetail(1);
        return orderHeroVO;
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void addHeroPurchseNum(List<Integer> heroIdList) {
        for(Integer heroId : heroIdList){
            HeroPO heroPO = heroPOMapper.selectByPrimaryKey(heroId);
            Integer purchaseNum = heroPO.getPurchaseNum();
            purchaseNum += 1;
            heroPO.setPurchaseNum(purchaseNum);
            heroPOMapper.updateByPrimaryKey(heroPO);
        }
    }

    @Override
    public List<HeroMemberOwnVO> getOwnHero(Integer id) {
        return heroPOMapper.getHeroOwnByMemberId(id);
    }
}
