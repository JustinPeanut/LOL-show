package com.peanut.controller;

import com.peanut.api.MySqlRemoteService;
import com.peanut.constant.Constant;
import com.peanut.entity.vo.HeroDetailVO;
import com.peanut.entity.vo.HeroPageVO;
import com.peanut.myUtils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class HeroController {
    @Autowired
    private MySqlRemoteService mySqlRemoteService;

    /**
     * 查出所有的英雄在页面上显示
     * @param model
     * @return
     */
    @RequestMapping("to/get/hero/page")
    public String getHeroPage(Model model){
        // 查出数据
        ResultEntity<List<HeroPageVO>> result =  mySqlRemoteService.getAllHero();
        if(ResultEntity.SUCCEED.equals(result.getStatus())){
            List<HeroPageVO> data = result.getData();
            model.addAttribute("heroPageVOList",data);
        }else{
            model.addAttribute(Constant.ATTR_MESSAGE_EXCEPTION,result.getMessage());
        }
        return "hero-page";
    }

    /**
     * 点击小图片跳转到大图详情
     * @param id
     * @return
     */
    @RequestMapping("detail/{id}")
    public String getHeroDetail(@PathVariable("id")Integer id,Model model){
        // 先查出英雄的相关信息
        ResultEntity<HeroDetailVO> result = mySqlRemoteService.getHeroDetailVOById(id);
        if(ResultEntity.SUCCEED.equals(result.getStatus())){
            // 放入模型
            model.addAttribute("heroDetail",result.getData());
        }else {
            model.addAttribute(Constant.ATTR_MESSAGE_EXCEPTION,result.getMessage());
        }
        return "hero-detail";
    }

    /**
     * 通过切换类型切换英雄页面
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("detail/by/type.json")
    public ResultEntity<List<HeroPageVO>> detailByType(@RequestParam("id")Integer id){
        // 如果id等于0，查出所有的数据
        if(id == 0){
           return mySqlRemoteService.getAllHero();
        }
        // 不等于0，通过typeId查询相关类型的英雄
        return mySqlRemoteService.getHeroByTypeId(id);

    }

    /**
     * 通过文本输入框输入的内容即时查询英雄
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("detail/by/name.json")
    public ResultEntity<List<HeroPageVO>> detailByName(@RequestParam("name")String name){
        return mySqlRemoteService.getHeroByName(name);
    }
}
