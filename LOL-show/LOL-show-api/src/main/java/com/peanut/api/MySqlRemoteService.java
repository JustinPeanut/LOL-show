package com.peanut.api;

import com.github.pagehelper.PageInfo;
import com.peanut.entity.vo.*;
import com.peanut.myUtils.ResultEntity;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Peanut
 */

@FeignClient("LOL-show-mysql-provider")
public interface MySqlRemoteService {

    @ResponseBody
    @RequestMapping("/hello")
    public String testHello();

    /**
     * 查询是否存在这个用户，验证登陆信息
     * @param loginMemberVO
     * @return
     */
    @ResponseBody
    @RequestMapping("query/member/to/login")
    public ResultEntity<LoginMemberVO> queryMemberToLogin(@RequestBody LoginMemberVO loginMemberVO);

    /**
     * 获取全部的大区，用于填充注册页的大区选择 <br/>
     * @return ResultEntity
     */
    @ResponseBody
    @RequestMapping("get/area/info/to/regist")
    ResultEntity<List<AreaVO>> getAreaInfoToRegist();

    /**
     * 设置修改过的loginMemberVO回数据库
     * @param loginMemberParam
     * @return
     */
    @ResponseBody
    @RequestMapping("save/member/po")
    ResultEntity<String> saveMemberPO(@RequestBody LoginMemberVO loginMemberParam);

    /**
     * 获取plan页面的用户的计划数据
     * 并且返回页面，在页面上分页显示
     * @param id       用户id
     * @param pageNum  分页页码
     * @param pageSize 每页的个数
     * @return
     */
    @ResponseBody
    @RequestMapping("get/page/info")
    public ResultEntity<PageInfo<PlanVO>> getPlanPageInfo(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("id") Integer id);

    /**
     * 删除用户需要删除的计划
     * @param id        根据计划的主键删除plan在数据库中的记录
     * @return
     */
    @ResponseBody
    @RequestMapping("remove/member/plan/by/id")
    public ResultEntity<String> removePlanById(@RequestParam("id") Integer id);

    /**
     * 从前台接收计划，并保存到数据库
     * @param planVO    接受的计划
     * @param memberVOId 用户的id
     * @return          返回响应ResultEntity
     */
    @ResponseBody
    @RequestMapping("save/member/plan")
    ResultEntity<String> saveMemberPlan(@RequestBody PlanVO planVO,@RequestParam("memberId") Integer memberVOId);

    /**
     * 更新计划表
     * @param planVO    接收的计划
     * @param memberId  用户id
     * @return
     */
    @ResponseBody
    @RequestMapping("update/member/plan")
    ResultEntity<String> updateMemberPlan(@RequestBody PlanVO planVO, @RequestParam("memberId") Integer memberId);

    /**
     * 保存注册的用户
     * @param registMemberVO
     * @return
     */
    @ResponseBody
    @RequestMapping("save/regist/member/vo")
    ResultEntity<Integer> saveRegistMemberVO(@RequestBody RegistMemberVO registMemberVO);

    /**
     * 获取主页的五张大图
     * 分页
     * @return
     */
    @ResponseBody
    @RequestMapping("get/portal/big/img")
    ResultEntity<PageInfo<HeroPortalVO>> getPortalImg();

    /**
     * 获取英雄页面的所有英雄
     * @return
     */
    @ResponseBody
    @RequestMapping("get/all/hero/page")
    ResultEntity<List<HeroPageVO>> getAllHero();

    /**
     * 通过typeId查询相关类型的英雄集合
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("get/hero/by/type/id")
    ResultEntity<List<HeroPageVO>> getHeroByTypeId(@RequestParam("id") Integer id);

    /**
     * 通过文本输入框的name关键字查询英雄
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("get/hero/by/name")
    ResultEntity<List<HeroPageVO>> getHeroByName(@RequestParam("name") String name);

    /**
     * 根据英雄id查出英雄详情页需要的英雄
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("get/hero/detail/vo/by/id")
    ResultEntity<HeroDetailVO> getHeroDetailVOById(@RequestParam("id") Integer id);

    /**
     * 查询左侧热门销量heroList
     * @return
     */
    @ResponseBody
    @RequestMapping("get/scot/hero/info")
    ResultEntity<List<ScotHeroVO>> getScotHero();

    /**
     * 跳转到商店页面要展示的所有StickHero
     * @return
     */
    @ResponseBody
    @RequestMapping("get/all/stick/hero")
    ResultEntity<PageInfo<StickHeroVO>> getAllStickHero();

    /**
     * 根据分页获取StickHero
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("get/stick/hero/by/page")
    ResultEntity<PageInfo<StickHeroVO>> getStickHeroByPage(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize);

    /**
     * 通过typeId查询分页的stickHero
     * @param pageNum
     * @param pageSize
     * @param typeId
     * @return
     */
    @ResponseBody
    @RequestMapping("get/stick/by/type")
    ResultEntity<PageInfo<StickHeroVO>> getStickByType(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("typeId") Integer typeId);

    /**
     * 根据传回的首字母查询
     * @param pageNum
     * @param pageSize
     * @param prefixLetter
     * @return
     */
    @ResponseBody
    @RequestMapping("get/stick/hero/prefix/letter")
    ResultEntity<PageInfo<StickHeroVO>> getStickHeroPrefixLetter
    (@RequestParam("pageNum") Integer pageNum,
     @RequestParam("pageSize") Integer pageSize,
     @RequestParam("prefixLetter") String prefixLetter,
     @RequestParam("typeId") Integer typeId);

    /**
     * 根据确认框的不同关键词查询StickHero
     * @param keyword
     * @param lowPrice
     * @param highPrice
     * @param typeId
     * @return
     */
    @ResponseBody
    @RequestMapping("get/all/stick/hero/by/commit/condition")
    ResultEntity<PageInfo<StickHeroVO>> getAllStickHeroByCommitCondition
    (
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("keyword") String keyword,
     @RequestParam("lowPrice") double lowPrice,
     @RequestParam("highPrice") double highPrice,
     @RequestParam("typeId") Integer typeId);

    /**
     * 根据id查询出购物车的herovo
     * @return
     */
    @ResponseBody
    @RequestMapping("get/cart/hero/vo")
    ResultEntity<CartHeroVO> getCartHeroVO(@RequestParam("id") Integer id);

    /**
     * 根据用户id查询用户钱包剩余
     * @param memberVOId
     * @return
     */
    @ResponseBody
    @RequestMapping("select/member/wallet/last")
    ResultEntity<MemberWalletVO> selectMemberWalletLast(@RequestParam("id") Integer memberVOId);

    /**
     * 保存用户充值订单
     * @param walletOrderVO
     * @return
     */
    @ResponseBody
    @RequestMapping("save/wallet/order")
    ResultEntity<String> saveWalletOrder(@RequestBody WalletOrderVO walletOrderVO);

    /**
     * 通过用户id充值
     * @param price
     * @param memberId
     * @return
     */
    @ResponseBody
    @RequestMapping("rechange/member/wallet")
    ResultEntity<String> reChangeMemberWallet(@RequestParam("price") Double price,@RequestParam("memberId") Integer memberId);

    /**
     * 查询将要加入购物车的hero信息
     * @param heroId
     * @return
     */
    @ResponseBody
    @RequestMapping("get/click/hero")
    ResultEntity<OrderHeroVO> getClickHero(@RequestParam("heroId") Integer heroId);

    /**
     * 将英雄订单信息，保存进数据库
     * @param orderHeroVO
     */
    @ResponseBody
    @RequestMapping("save/order/hero/vo")
    ResultEntity<String> saveOrderHeroVO(@RequestBody OrderHeroVO orderHeroVO,@RequestParam("id") Integer id);

    /**
     * 查询已经登陆的用户的所有的
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("get/order/hero/list")
    ResultEntity<List<OrderHeroInPageVO>> getOrderHeroList(@RequestParam("id") Integer id);

    /**
     * 根据英雄id删除订单
     * @param heroId
     * @return
     */
    @ResponseBody
    @RequestMapping("remove/order/hero/by/hero/id")
    ResultEntity<String> removeOrderHeroByHeroId(@RequestParam("heroId") Integer heroId);

    /**
     * 更新消费之后的用户余额
     * @param lastMoney
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("pay/for/hero/order")
    ResultEntity<String> payForHeroOrder(@RequestParam("lastMoney") Double lastMoney, @RequestParam("id") Integer id);

    /**
     * 删除已经支付的订单
     * @param heroIdList
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("remove/order/hero/by/hero/id/list")
    ResultEntity<String> removeOrderHeroByHeroIdList(@RequestBody List<Integer> heroIdList, @RequestParam("id") Integer id);

    /**
     * 为用户发放购买的英雄
     * @param id
     * @param heroIdList
     * @return
     */
    @ResponseBody
    @RequestMapping("sava/member/own/hero")
    ResultEntity<String> saveMemberOwnHero(@RequestParam("id") Integer id,@RequestBody List<Integer> heroIdList);

    /**
     * 查询用户已经拥有的英雄
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("get/own/hero")
    ResultEntity<List<HeroMemberOwnVO>> getOwnHero(@RequestParam("id") Integer id);

    /**
     * 为刚创建的用户创建账户
     * @param memberId
     * @return
     */
    @ResponseBody
    @RequestMapping("create/wallet/by/member/id")
    ResultEntity<String> createWalletByMemberId(@RequestParam("id") Integer memberId);

    /**
     * 为英雄的购买次数增加1
     * @param heroIdList
     * @return
     */
    @ResponseBody
    @RequestMapping("add/hero/puchase/num")
    ResultEntity<String> addHeroPurchaseNum(@RequestBody List<Integer> heroIdList);
}
