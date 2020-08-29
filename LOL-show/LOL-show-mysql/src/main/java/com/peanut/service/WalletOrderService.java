package com.peanut.service;

import com.peanut.entity.vo.WalletOrderVO;

public interface WalletOrderService {

    /**
     * 保存充值订单
     * @param walletOrderVO
     */
    void saveWalletOrderVO(WalletOrderVO walletOrderVO);
}
