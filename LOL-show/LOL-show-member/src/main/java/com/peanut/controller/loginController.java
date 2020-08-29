package com.peanut.controller;

import com.github.pagehelper.PageInfo;
import com.peanut.api.MySqlRemoteService;
import com.peanut.constant.Constant;
import com.peanut.entity.vo.AreaVO;
import com.peanut.entity.vo.HeroPortalVO;
import com.peanut.entity.vo.LoginMemberVO;
import com.peanut.myUtils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Peanut
 */
@Controller
public class loginController {
    /**
     * 装配远程调用接口
     */
    @Autowired
    private MySqlRemoteService mySqlRemoteService;

    /**
     * 网页主页面
     * @return
     */
    @RequestMapping("/")
    public String getHome(HttpSession session){
        // 这里需要查出数据
        // 查出前五条数据存入session域中
        ResultEntity<PageInfo<HeroPortalVO>> result =  mySqlRemoteService.getPortalImg();
        // 校验
        if(ResultEntity.SUCCEED.equals(result.getStatus())){
            // 获取封装好的PageInfp对象
            PageInfo<HeroPortalVO> data = result.getData();
            List<HeroPortalVO> list = data.getList();
            // 存入session域
            session.setAttribute("portalImgList", list);
        }else {
            session.setAttribute(Constant.ATTR_MESSAGE_EXCEPTION,result.getMessage());
        }
        return "redirect:http://localhost/get/home/page";
    }

    /**
     * 登陆的逻辑代码
     * @param loginMemberVO
     * @return 个人主页
     *
     */
    @RequestMapping("do/member/login")
    public String doLogin(LoginMemberVO loginMemberVO, HttpSession session){
        // 拿到LoginMemberVO对象，查询数据库中是否匹配这个用户
        ResultEntity<LoginMemberVO> result = mySqlRemoteService.queryMemberToLogin(loginMemberVO);
        // 获取查询结果状态码
        String status = result.getStatus();
        if(ResultEntity.SUCCEED.equals(status)){
            // 将loginMemberVO设置到session中，并且返回个人主页
            LoginMemberVO data = result.getData();
            session.setAttribute(Constant.ATTR_LOGIN_MEMBER,data);
            return "member-home";
        }else{
            // 如果没有查询到对象，将结果信息设置到session中
            session.setAttribute(Constant.ATTR_MESSAGE_EXCEPTION,result.getMessage());
        }
        // 仍然返回登陆页
        return "redirect:http://localhost/to/login/page";
    }

    /**
     * 退出登陆
     * @return 返回主页h
     */
    @RequestMapping("/quit/login/member")
    public String quitLogin(HttpSession session){
        // 让session失效，以达到退出登陆的效果
        session.invalidate();
        return "redirect:http://localhost/";
    }

    /**
     * 获取注册的大区信息，并且前往注册页面
     * @return
     */
    @RequestMapping("to/regist/page")
    public String getRegistAreaPage(Model model){
        // 获取areaInfo信息
        ResultEntity<List<AreaVO>> areaListResult = mySqlRemoteService.getAreaInfoToRegist();
        String status = areaListResult.getStatus();
        // 校验查询结果
        if(ResultEntity.SUCCEED.equals(status)){
            // 如果成功，存入模型
            List<AreaVO> data = areaListResult.getData();
            model.addAttribute(Constant.ATTR_AREA_LIST,data);
            // 并且返回注册页面
            return "regist-page";
        }

        // 如果不成功的话，返回主页
        return "redirect:http://localhost/";
    }



}
