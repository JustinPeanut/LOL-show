package com.peanut.service;

import com.peanut.entity.po.WalletOrderPO;
import com.peanut.entity.vo.WalletOrderVO;
import com.peanut.mapper.WalletOrderPOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.awt.windows.WLightweightFramePeer;

@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
public class WalletOrderServiceImpl implements WalletOrderService {
    @Autowired
    private WalletOrderPOMapper walletOrderPOMapper;

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void saveWalletOrderVO(WalletOrderVO walletOrderVO) {
        // 复制属性
        WalletOrderPO walletOrderPO = new WalletOrderPO();
        BeanUtils.copyProperties(walletOrderVO,walletOrderPO);
        walletOrderPOMapper.insertSelective(walletOrderPO);
    }
}
