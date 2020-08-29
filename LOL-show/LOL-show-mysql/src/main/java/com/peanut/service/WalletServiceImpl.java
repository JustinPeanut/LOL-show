package com.peanut.service;

import com.peanut.entity.po.MemberWalletPO;
import com.peanut.entity.po.MemberWalletPOExample;
import com.peanut.entity.po.WalletOrderPO;
import com.peanut.entity.vo.MemberWalletVO;
import com.peanut.exception.NoSuchMemberException;
import com.peanut.mapper.MemberWalletPOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
public class WalletServiceImpl implements WalletService {
    @Autowired
    private MemberWalletPOMapper walletPOMapper;

    @Override
    public MemberWalletVO getWalletVObyMemberId(Integer id) {
        MemberWalletPOExample example = new MemberWalletPOExample();
        MemberWalletPOExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(id);
        // 查询结果
        List<MemberWalletPO> memberWalletPOS = walletPOMapper.selectByExample(example);
        // 验证查询结果
        if(memberWalletPOS == null || memberWalletPOS.size() == 0){
            throw new NoSuchMemberException("找不到这个用户，请登录以后再试");
        }
        // 如果正确，复制属性
        MemberWalletPO memberWalletPO = memberWalletPOS.get(0);
        MemberWalletVO memberWalletVO = new MemberWalletVO();
        BeanUtils.copyProperties(memberWalletPO,memberWalletVO);
        return memberWalletVO;
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void reChangeWallet(Double price, Integer memberId) {
        // 根据用户id查询账户余额
        MemberWalletPOExample example = new MemberWalletPOExample();
        MemberWalletPOExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(memberId);
        List<MemberWalletPO> memberWalletPOS = walletPOMapper.selectByExample(example);
        MemberWalletPO memberWalletPO = memberWalletPOS.get(0);
        // 去除账户余额相加
        Double walletLast = memberWalletPO.getWalletLast();
        walletLast += price;
        memberWalletPO.setWalletLast(walletLast);
        // 再添加回去
        walletPOMapper.updateByPrimaryKey(memberWalletPO);
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void payWallet(Double lastMoney, Integer id) {
        MemberWalletPO memberWalletPO = new MemberWalletPO();
        // 设置实际剩余的余额
        memberWalletPO.setWalletLast(lastMoney);
        MemberWalletPOExample example = new MemberWalletPOExample();
        MemberWalletPOExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(id);
        walletPOMapper.updateByExampleSelective(memberWalletPO,example);
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void createWallet(Integer memberId) {
        MemberWalletPO memberWalletPO = new MemberWalletPO();
        memberWalletPO.setWalletLast(0.0);
        memberWalletPO.setMemberId(memberId);
        walletPOMapper.insertSelective(memberWalletPO);
    }
}
