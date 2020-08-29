package com.peanut.controller;

import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.peanut.api.MySqlRemoteService;
import com.peanut.api.RedisRemoteService;
import com.peanut.constant.Constant;
import com.peanut.entity.vo.HeroMemberOwnVO;
import com.peanut.entity.vo.LoginMemberVO;
import com.peanut.entity.vo.MemberWalletVO;
import com.peanut.entity.vo.PlanVO;
import com.peanut.exception.ResgistMemberException;
import com.peanut.myUtils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * 处理一些member主页的逻辑
 * @author Peanut
 */

@Controller
public class MemberController {
    @Autowired
    private MySqlRemoteService mySqlRemoteService;
    @Autowired
    DefaultKaptcha defaultKaptcha;
    @Autowired
    private RedisRemoteService redisRemoteService;

    /**
     * 用于修改member的controller
     * 将修改后的member存入数据库
     * @param session 用于存取session
     * @param loginMemberParam 接收前台传回来的修改的member
     * @return
     */
    @RequestMapping("/do/update/member/info")
    public String updateMemberInfo(HttpSession session,LoginMemberVO loginMemberParam){
        // 获取session中已经存在的loginMemberVO对象
        LoginMemberVO loginMemberVO = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
        // 复制属性
        // 判断loginMemberParam传回来的roleName和年龄是否为空
        if(loginMemberParam.getRoleName()==""){
            String roleName = loginMemberVO.getRoleName();
            loginMemberParam.setRoleName(roleName);
        }
        if(loginMemberParam.getAge() == null){
            int age = loginMemberVO.getAge();
            loginMemberParam.setAge(age);
        }
        // 设置不能改变的属性
        String userName = loginMemberVO.getUserName();
        String password = loginMemberVO.getPassword();
        Integer id = loginMemberVO.getId();
        loginMemberParam.setUserName(userName);
        loginMemberParam.setPassword(password);
        loginMemberParam.setId(id);
        // 重新设置回session
        session.setAttribute(Constant.ATTR_LOGIN_MEMBER,loginMemberParam);
        // 保存回数据库
        ResultEntity<String> resultEntity = mySqlRemoteService.saveMemberPO(loginMemberParam);
        // 获取状态
        String status = resultEntity.getStatus();
        if(ResultEntity.SUCCEED.equals(status)){
            return "member-info-update";
        }
        // 设置异常信息
        String message = resultEntity.getMessage();
        session.setAttribute(Constant.ATTR_MESSAGE_EXCEPTION,message);
        return "member-info-update";
    }


    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("member/get/page/info.json")
    @ResponseBody
    public ResultEntity<PageInfo<PlanVO>> getPageInfo(
            @RequestParam("pageNum")Integer pageNum,
            @RequestParam("pageSize")Integer pageSize,
            HttpSession session){
        // 获取当前登陆的memberId
        LoginMemberVO loginMemberVO  = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
        Integer memberVOId = loginMemberVO.getId();
        // 获取plan的数据
        // 如果结果没有问题就返回
        ResultEntity<PageInfo<PlanVO>> result = mySqlRemoteService.getPlanPageInfo(pageNum, pageSize, memberVOId);
        if(ResultEntity.SUCCEED.equals(result.getStatus())){
            return result;
        }
        // 如果有异常，返回异常信息
         return ResultEntity.failedWithOutData(result.getMessage());
    }

    /**
     * 删除计划
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("remove/member/plan.json")
    public ResultEntity<String> removeMemberPlan(@RequestParam("id") Integer id){
        return mySqlRemoteService.removePlanById(id);
   }

    /**
     * 从前台接收计划，并保存到数据库
     * @param planVO    接受的计划
     * @param session   session中取出memberId
     * @return          返回响应ResultEntity
     */
    @ResponseBody
    @RequestMapping("add/member/plan.json")
    public ResultEntity<String> addMemberPlan(@RequestBody PlanVO planVO,HttpSession session){
        // 取出已经登陆的用户的id
        LoginMemberVO memberVO = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
        Integer memberVOId = memberVO.getId();
        return mySqlRemoteService.saveMemberPlan(planVO,memberVOId);
   }

    @ResponseBody
    @RequestMapping(value = "update/member/plan.json")
    public ResultEntity<String> updateMemberPlan(@RequestBody PlanVO planVO,HttpSession session){
        // 取出已经登陆的用户的id
        LoginMemberVO memberVO = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
        Integer memberId = memberVO.getId();
        return mySqlRemoteService.updateMemberPlan(planVO,memberId);
    }

    /**
     * 使用谷歌插件生成验证码的方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping("/api/kaptcha/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            // 存入redis缓存
            ResultEntity<String> resultEntity =
                    redisRemoteService.setKeyValue(Constant.ATTR_CODE_REGIST, createText);
            // 如果保存验证码失败，就让用户重新刷新页面
            if(ResultEntity.FAILED.equals(resultEntity)){
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute(Constant.ATTR_MESSAGE_EXCEPTION,"注册失败，请重试刷新页面！");
                httpServletResponse.sendRedirect("http://localhsot/to/regist/page");
                throw new ResgistMemberException(resultEntity.getMessage());
            }
            // 使用生成的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }finally {
            // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
            captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
            httpServletResponse.setHeader("Cache-Control", "no-store");
            httpServletResponse.setHeader("Pragma", "no-cache");
            httpServletResponse.setDateHeader("Expires", 0);
            httpServletResponse.setContentType("image/jpeg");
            ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
            responseOutputStream.write(captchaChallengeAsJpeg);
            responseOutputStream.flush();
            responseOutputStream.close();
        }
    }

    /**
     * 跳转到用户钱包页面
     * @param session
     * @return
     */
    @RequestMapping("to/member/wallet")
    public String toMemberWallet(HttpSession session, Model model){
        // 从session域中取出已经登陆的对象
        LoginMemberVO loginMemberVO = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
        // 获取登陆的用户id
        Integer memberVOId = loginMemberVO.getId();
        // 根据用户id查询用户的钱包剩余
        ResultEntity<MemberWalletVO> result = mySqlRemoteService.selectMemberWalletLast(memberVOId);
        if(ResultEntity.SUCCEED.equals(result.getStatus())){
            MemberWalletVO data = result.getData();
            model.addAttribute("walletVO",data);
        }else {
            model.addAttribute(Constant.ATTR_MESSAGE_EXCEPTION,result.getMessage());
        }
        return "member-wallet";
    }

    @RequestMapping("to/member/hero/page")
    public String toMemberHeroPage(HttpSession session,Model model){
        // 获取登陆的对象
        LoginMemberVO member = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
        Integer id = member.getId();
        ResultEntity<List<HeroMemberOwnVO>> result = mySqlRemoteService.getOwnHero(id);
        if(ResultEntity.SUCCEED.equals(result.getStatus())){
            List<HeroMemberOwnVO> data = result.getData();
            model.addAttribute("heroList",data);
        }
        return "member-hero";
    }



}
