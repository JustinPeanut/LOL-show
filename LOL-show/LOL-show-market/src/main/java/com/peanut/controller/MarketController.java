package com.peanut.controller;

import com.github.pagehelper.PageInfo;
import com.netflix.ribbon.proxy.annotation.Http;
import com.peanut.api.MySqlRemoteService;
import com.peanut.constant.Constant;
import com.peanut.entity.vo.*;
import com.peanut.myUtils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MarketController {

    @Autowired
    private MySqlRemoteService mySqlRemoteService;

    @RequestMapping("to/market/home/page")
    public String getMarketPage(Model model, HttpSession session){
        // 这里要先查出数据
        // 查询10条热门信息
        ResultEntity<List<ScotHeroVO>> result = mySqlRemoteService.getScotHero();
        // 校验热门英雄的数据
        // 如果没有成功，则不返回
        if(! ResultEntity.SUCCEED.equals(result.getStatus())){
            model.addAttribute(Constant.ATTR_MESSAGE_EXCEPTION,result.getMessage());
        }else{
            model.addAttribute("scotHeroList",result.getData());
        }
        // 查询是否已经登陆，如果已经登陆，需要将订单数量设置回去
        LoginMemberVO memberVO = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
        if(memberVO != null){
            Integer memberVOId = memberVO.getId();
            ResultEntity<List<OrderHeroInPageVO>> orderHeroList = mySqlRemoteService.getOrderHeroList(memberVOId);
            List<OrderHeroInPageVO> data = orderHeroList.getData();
            Integer listSize = data.size();
            session.setAttribute(Constant.ATTR_ORDER_LIST_LENGTH,listSize);
        }
        return "market-home";
    }

    @ResponseBody
    @RequestMapping("get/stick/info.json")
    public ResultEntity<PageInfo<StickHeroVO>> getStickPageInfo(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam(value = "typeId",defaultValue = "-1") Integer typeId,
            @RequestParam(value = "keyword",defaultValue = "" )String keyword,
            @RequestParam(value = "lowPrice",defaultValue = "-1")double lowPrice,
            @RequestParam(value = "highPrice",defaultValue = "99999")double highPrice,
            @RequestParam(value = "prefixLetter",defaultValue = "")String prefixLetter){
        // 如果传回了字母
        if(prefixLetter.length() == 1){
            if(typeId >= 0){
                return mySqlRemoteService.getStickHeroPrefixLetter(pageNum,pageSize,prefixLetter,typeId);
            }
            return mySqlRemoteService.getStickHeroPrefixLetter(pageNum,pageSize,prefixLetter,0);
        }
        // 指定条件获取全部的stick hero或者制定了确认框中的条件
        return mySqlRemoteService.getAllStickHeroByCommitCondition(pageSize,pageNum,keyword,lowPrice,highPrice,typeId);
    }

    /**
     * 根据英雄id查询cartHeroVO数据并返回
     * @param heroId
     * @return
     */
    @ResponseBody
    @RequestMapping("get/click/hero.json")
    public ResultEntity<OrderHeroVO> getClickHero(@RequestParam("heroId")Integer heroId, HttpSession session){
        // 查询出clickHero，并将其放入session中
        ResultEntity<OrderHeroVO> clickHero = mySqlRemoteService.getClickHero(heroId);
        // 放入session中
        session.setAttribute(Constant.ATTR_ORDER_HERO,clickHero.getData());
        return clickHero;
    }


}
