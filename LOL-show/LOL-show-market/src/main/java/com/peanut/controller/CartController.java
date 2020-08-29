package com.peanut.controller;

import com.peanut.api.MySqlRemoteService;
import com.peanut.constant.Constant;
import com.peanut.entity.vo.CartHeroVO;
import com.peanut.entity.vo.ScotHeroVO;
import com.peanut.myUtils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private MySqlRemoteService mySqlRemoteService;

    /**
     * 根据标签id去往
     * @param id
     * @return
     */
    @RequestMapping("to/cart/{id}")
    public String toCartPage(@PathVariable("id") Integer id, Model model){
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
        // 再根据id查询出CartHeroVO对象
        ResultEntity<CartHeroVO> cartHero = mySqlRemoteService.getCartHeroVO(id);
        if(ResultEntity.SUCCEED.equals(cartHero.getStatus())){
            CartHeroVO data = cartHero.getData();
            model.addAttribute("cartHeroVO",data);
        }else{
            // 失败就
            model.addAttribute("cartException",cartHero.getMessage());
        }
        return "market-cart";
    }
}
