package com.peanut.service;

import com.peanut.entity.po.AreaPO;
import com.peanut.entity.vo.AreaVO;
import com.peanut.mapper.AreaPOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peanut
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaPOMapper areaPOMapper;

    /**
     * 获取全部的大区信息
     * @return
     */
    @Override
    public List<AreaVO> getAll() {
        // 查询PO
        List<AreaPO> areaPoList = areaPOMapper.selectAll();
        List<AreaVO> areaVOList = new ArrayList<>();
        // 遍历，复制PO属性到VO
        for(AreaPO areaPO : areaPoList){
            AreaVO areaVO = new AreaVO();
            BeanUtils.copyProperties(areaPO,areaVO);
            areaVOList.add(areaVO);
        }
        // 返回
        return areaVOList;
    }
}
