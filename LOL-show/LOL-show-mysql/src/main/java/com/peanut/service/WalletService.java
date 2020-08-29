package com.peanut.service;

import com.peanut.entity.vo.MemberWalletVO;

public interface WalletService {
    MemberWalletVO getWalletVObyMemberId(Integer id);

    /**
     * 为用户充值
     * @param price
     * @param memberId
     */
    void reChangeWallet(Double price, Integer memberId);

    /**
     * 更新余额
     * @param lastMoney
     * @param id
     */
    void payWallet(Double lastMoney, Integer id);

    /**
     * 根据用户id创建账户
     * @param memberId
     */
    void createWallet(Integer memberId);
}
