package com.peanut.service;

import com.peanut.entity.po.MemberPO;
import com.peanut.entity.po.MemberPOExample;
import com.peanut.entity.vo.LoginMemberVO;
import com.peanut.entity.vo.RegistMemberVO;
import com.peanut.exception.NoSuchMemberException;
import com.peanut.exception.PasswordIncorrectException;
import com.peanut.exception.UserNameAlreadyUsedException;
import com.peanut.mapper.MemberPOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Peanut
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberPOMapper memberPOMapper;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    @Transactional(readOnly = true)
    public LoginMemberVO queryMemberByMemberVO(LoginMemberVO loginMemberVO){
        // 获取传递过来的userName
        String userName = loginMemberVO.getUserName();
        // 添加查询条件
        MemberPOExample example = new MemberPOExample();
        MemberPOExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        // 执行查询
        List<MemberPO> result = memberPOMapper.selectByExample(example);
        // 如果没有查询到数据
        if(result == null || result.size() <= 0 ) {
            throw new NoSuchMemberException("用户名不存在！");
        }
        // 如果查询到了数据就会走到这里
        MemberPO memberPO = result.get(0);
        // 获取查询到的数据库密码
        String dataBasePassword = memberPO.getPassword();
        // 获取传递的password
        String loginMemberVOPassword = loginMemberVO.getPassword();
        // 比较密码是否正确
        if(! encoder.matches(loginMemberVOPassword,dataBasePassword)){
            // 抛出自定义异常
            throw new PasswordIncorrectException("密码不正确，请重新输入");
        }
        // 最后结果正确的话返回member
        LoginMemberVO memberVO = new LoginMemberVO();
        BeanUtils.copyProperties(memberPO,memberVO);
        return memberVO;
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public void saveMemberVO(LoginMemberVO loginMemberParam) {
        MemberPO memberPO = new MemberPO();
        BeanUtils.copyProperties(loginMemberParam,memberPO);
        // 获取loginMember的用户名
        String userName = loginMemberParam.getUserName();
        // 设置查询条件
        MemberPOExample example = new MemberPOExample();
        MemberPOExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        // 先查询出数据库中原本存在的member对象
        List<MemberPO> memberPOS = memberPOMapper.selectByExample(example);
        MemberPO member = memberPOS.get(0);
        // 复制已有的属性
        BeanUtils.copyProperties(loginMemberParam,member);
        // 更新原有的member对象
        memberPOMapper.updateByPrimaryKeySelective(member);
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public Integer saveRegistMember(RegistMemberVO registMemberVO) {
        MemberPO memberPO = new MemberPO();
        BeanUtils.copyProperties(registMemberVO,memberPO);
        // 这里要加密
        String password = memberPO.getPassword();
        String encodedPassword = encoder.encode(password);
        memberPO.setPassword(encodedPassword);
        try{
            memberPOMapper.insertSelective(memberPO);
            Integer id = memberPO.getId();
            System.out.println(id);
            return id;
        }catch (Exception e){
            if(e instanceof DuplicateKeyException){
                throw new UserNameAlreadyUsedException("用户名已经被使用");
            }
        }
        return 0;
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void saveMemberOwnHeroList(Integer id, List<Integer> heroIdList) {
        memberPOMapper.saveOwnHero(id,heroIdList);
    }

}
