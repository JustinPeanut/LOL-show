package com.peanut.controller;

import com.peanut.api.MySqlRemoteService;
import com.peanut.api.RedisRemoteService;
import com.peanut.constant.Constant;
import com.peanut.entity.vo.RegistMemberVO;
import com.peanut.myUtils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RegistController {

    @Autowired
    private RedisRemoteService redisRemoteService;
    @Autowired
    private MySqlRemoteService mySqlRemoteService;

    @RequestMapping("/do/member/regist")
    public String doRegist(RegistMemberVO registMemberVO, HttpSession session,Model model){
        // 首先比较验证码是否正确
        String code = registMemberVO.getCode();
        // 获取redis中存储的code
        ResultEntity<String> result = redisRemoteService.getValueByKey(Constant.ATTR_CODE_REGIST);
        // 如果没有获取到验证码
        if(!ResultEntity.SUCCEED.equals(result.getStatus())){
            System.out.println("取数据失败");
            model.addAttribute(Constant.ATTR_MESSAGE_EXCEPTION,result.getMessage());
            return "redirect:http://localhost/to/regist/page";
        }
        // 如果获取到了验证码，就应该可以执行到这里
        // 获取数据库中保存的验证码
        String data = result.getData();
        // 如果验证码不相等
        if(!code.equals(data)){
            model.addAttribute(Constant.ATTR_MESSAGE_EXCEPTION,"验证码不相等，请重新输入！");
            return "regist-page";
        }
        // 如果验证码相等，执行保存
        ResultEntity<Integer> registResult =mySqlRemoteService.saveRegistMemberVO(registMemberVO);
        if(ResultEntity.SUCCEED.equals(registResult.getStatus())){
            // 获取返回的主键值
            Integer memberId = registResult.getData();
            // 为刚创建的用户创建账户
            ResultEntity<String> resultEntity = mySqlRemoteService.createWalletByMemberId(memberId);
            if(!ResultEntity.SUCCEED.equals(resultEntity.getStatus())){
                session.setAttribute(Constant.ATTR_MESSAGE_EXCEPTION,registResult.getMessage());
                return "redirect:http://localhost/to/regist/page";
            }
            // 成功返回注册成功的页面
            model.addAttribute("registedSucceedMember",registMemberVO.getUserName());
            return "regist-sucess";
        }
        session.setAttribute(Constant.ATTR_MESSAGE_EXCEPTION,registResult.getMessage());
        return "redirect:http://localhost/to/regist/page";
    }
}
