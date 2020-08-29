package com.peanut.service;


import com.peanut.entity.vo.LoginMemberVO;
import com.peanut.entity.vo.RegistMemberVO;
import com.peanut.exception.NoSuchMemberException;

import java.util.List;

/**
 * @author Peanut
 */
public interface MemberService {

    /**
     * 查询memberVO以供登陆检查
     * @param loginMemberVO
     * @return
     * @throws NoSuchMemberException
     */
    LoginMemberVO queryMemberByMemberVO(LoginMemberVO loginMemberVO) throws NoSuchMemberException;

    /**
     * 保存MemberVO
     * @param loginMemberParam
     */
    void saveMemberVO(LoginMemberVO loginMemberParam);

    /**
     * 保存注册的用户
     * @param registMemberVO
     * @return
     */
    Integer saveRegistMember(RegistMemberVO registMemberVO);


    /**
     * 保存用户购买的英雄
     * @param id
     * @param heroIdList
     */
    void saveMemberOwnHeroList(Integer id, List<Integer> heroIdList);
}
