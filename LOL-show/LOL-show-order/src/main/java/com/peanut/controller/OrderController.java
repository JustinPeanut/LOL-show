package com.peanut.controller;

import com.netflix.ribbon.proxy.annotation.Http;
import com.peanut.api.MySqlRemoteService;
import com.peanut.constant.Constant;
import com.peanut.entity.vo.*;
import com.peanut.myUtils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private MySqlRemoteService mySqlRemoteService;

    @ResponseBody
    @RequestMapping("save/to/wallet")
    public ResultEntity<String> saveWallet(@RequestParam("price")Double price, HttpSession session){
        // 获取已经登陆的对象
        try{
            LoginMemberVO memberVO = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
            Integer memberVOId = memberVO.getId();
            // 封装orderWalletOrderVO对象
            WalletOrderVO walletOrderVO = new WalletOrderVO();
            walletOrderVO.setMemberId(memberVOId);
            walletOrderVO.setPrice(price);
            walletOrderVO.setOrderName("充值LB: "+price+"元");
            // 将封装的order对象放入session域中
            session.setAttribute(Constant.ATTR_WALLET_ORDER,walletOrderVO);
            return ResultEntity.succeedWithOutData(ResultEntity.SUCCEED);
        }catch (Exception e){
            return ResultEntity.failedWithOutData(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("add/hero/to/cart")
    public ResultEntity<String> addHeroCart(HttpSession session){
        try{
            OrderHeroVO orderHeroVO = (OrderHeroVO) session.getAttribute(Constant.ATTR_ORDER_HERO);
            // 将这个订单信息保存进数据库
            // 获取当前登陆的用户id
            LoginMemberVO member = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
            Integer id = member.getId();
            // 因为已经添加了数据，所以这个list肯定不为空
            ResultEntity<String> resultEntity = mySqlRemoteService.saveOrderHeroVO(orderHeroVO, id);
            if(ResultEntity.FAILED.equals(resultEntity.getStatus())){
                return ResultEntity.failedWithOutData(resultEntity.getMessage());
            }

            ResultEntity<List<OrderHeroInPageVO>> orderHeroList = mySqlRemoteService.getOrderHeroList(id);
            List<OrderHeroInPageVO> data = orderHeroList.getData();
            Integer listSize = data.size();
            List<OrderHeroVO> list = (List<OrderHeroVO>) session.getAttribute(Constant.ATTR_ORDER_HERO_LIST);
            // 如果不存在这个list，那么就创建一个list
            if (list == null) {
                List<OrderHeroVO> heroList = new ArrayList<>();
                heroList.add(orderHeroVO);
                session.setAttribute(Constant.ATTR_ORDER_HERO_LIST,heroList);
                session.setAttribute(Constant.ATTR_ORDER_LIST_LENGTH,listSize);
            }else{
                list.add(orderHeroVO);
                // 然后再将list设置回session中
                session.setAttribute(Constant.ATTR_ORDER_HERO_LIST,list);
                session.setAttribute(Constant.ATTR_ORDER_LIST_LENGTH,listSize);
            }
            return ResultEntity.succeedWithOutData(ResultEntity.SUCCEED);
        }catch (Exception e){
            return ResultEntity.failedWithOutData(e.getMessage());

        }

    }

    @RequestMapping("save/order/to/cart/{heroId}")
    public String saveOrderToCart(@PathVariable("heroId") Integer heroId, HttpSession session){
        // 先查出orderHeroVO
        ResultEntity<OrderHeroVO> clickHeroResult = mySqlRemoteService.getClickHero(heroId);
        if(ResultEntity.SUCCEED.equals(clickHeroResult.getStatus())){
            OrderHeroVO data = clickHeroResult.getData();
            LoginMemberVO member = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
            Integer id = member.getId();
            // 保存在购物车页面添加的订单
            ResultEntity<String> resultEntity = mySqlRemoteService.saveOrderHeroVO(data, id);
            if(ResultEntity.SUCCEED.equals(resultEntity.getStatus())){
                // 取出当前订单数目，如果是null，就设为0，否则自增
                Integer listSize = (Integer) session.getAttribute(Constant.ATTR_ORDER_LIST_LENGTH);
                if(listSize == null){
                    listSize = 0;
                }else {
                    listSize++;
                }
                session.setAttribute(Constant.ATTR_ORDER_LIST_LENGTH,listSize);
                return "redirect://localhost/order/to/hero/submit/page";
            }else {
                session.setAttribute("addCartException",resultEntity.getMessage());
                return "redirect:http://localhost/market/to/cart/"+heroId;
            }
        }
            return "redirect:http://localhost/market/to/cart/"+heroId;

    }


    /**
     * 跳转到具体的购物车页面，我的订单
     * @return
     */
    @RequestMapping("to/hero/submit/page")
    public String toHeroOrderSubmitPage(HttpSession session, Model model){
        // 获取当前登陆的用户id
        LoginMemberVO member = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
        Integer id = member.getId();
        // 查询出当前的用户所有的订单
        ResultEntity<List<OrderHeroInPageVO>> result = mySqlRemoteService.getOrderHeroList(id);
        if(ResultEntity.SUCCEED.equals(result.getStatus())){
            model.addAttribute("OrderHeroInPage",result.getData());
        }else {
            model.addAttribute(Constant.ATTR_MESSAGE_EXCEPTION,result.getMessage());
        }
        return "order-submit";
    }

    @RequestMapping("remove/hero/{heroId}")
    public String removeOrder(@PathVariable("heroId") Integer heroId, Model model, HttpSession session){
        ResultEntity<String> result = mySqlRemoteService.removeOrderHeroByHeroId(heroId);
        if(ResultEntity.SUCCEED.equals(result.getStatus())){
            // 将session中的订单个数减一
            Integer listSize = (Integer) session.getAttribute(Constant.ATTR_ORDER_LIST_LENGTH);
            listSize--;
            session.setAttribute(Constant.ATTR_ORDER_LIST_LENGTH,listSize);
            return "redirect:http://localhost/order/to/hero/submit/page";
        }else{
            model.addAttribute(Constant.ATTR_MESSAGE_EXCEPTION,result.getMessage());
        }
        return "order-submit";
    }

    @RequestMapping("pay/to/save/hero")
    @ResponseBody
    public ResultEntity<String> payToSave(@RequestParam("money") Double money,HttpSession session){
        // 获取已经登陆的对象
        LoginMemberVO member = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
        Integer id = member.getId();
        ResultEntity<MemberWalletVO> memberWalletVOResultEntity = mySqlRemoteService.selectMemberWalletLast(id);
        if(ResultEntity.FAILED.equals(memberWalletVOResultEntity.getStatus())){
            return ResultEntity.failedWithOutData("系统繁忙，请刷新页面，稍后再试！");
        }
        MemberWalletVO data = memberWalletVOResultEntity.getData();
        Double walletLast = data.getWalletLast();
        // 如果余额不足，就直接返回异常信息
        if(walletLast < money){
            return ResultEntity.failedWithOutData("对不起，余额不足，请前往个人主页充值！");
        }
        // 如果余额充足，执行消费扣除需要消费的价格
        Double lastMoney = walletLast - money;
        return mySqlRemoteService.payForHeroOrder(lastMoney,id);

    }

    @ResponseBody
    @RequestMapping("delete/order/send/hero")
    public ResultEntity<String> deleteOrderSendHero(@RequestParam(value = "heroIdList[]")List<Integer> heroIdList,HttpSession session){
        // 获取登陆的用户
        LoginMemberVO member = (LoginMemberVO) session.getAttribute(Constant.ATTR_LOGIN_MEMBER);
        Integer id = member.getId();
        // 执行删除订单
        ResultEntity<String> resultEntity = mySqlRemoteService.removeOrderHeroByHeroIdList(heroIdList,id);
        if(ResultEntity.SUCCEED.equals(resultEntity.getStatus())){
            // 将session中的listSize减少相应的数量
            int size = heroIdList.size();
            Integer listSize = (Integer) session.getAttribute(Constant.ATTR_ORDER_LIST_LENGTH);
            listSize -= size;
            // 设置回session
            session.setAttribute(Constant.ATTR_ORDER_LIST_LENGTH,listSize);
            // 为拥有英雄的表添加英雄
            ResultEntity<String> result = mySqlRemoteService.saveMemberOwnHero(id,heroIdList);
            if(!ResultEntity.SUCCEED.equals(result.getStatus())){
                return result;
            }
            // 为英雄的购买次数增加1
            ResultEntity<String> addResult =  mySqlRemoteService.addHeroPurchaseNum(heroIdList);
            if(!ResultEntity.SUCCEED.equals(addResult.getStatus())){
                return addResult;
            }

        }
        return ResultEntity.succeedWithOutData(ResultEntity.SUCCEED);
    }


}
