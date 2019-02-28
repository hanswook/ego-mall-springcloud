package com.ego.egoprovider.service.impl;

import com.ego.egoprovider.mapper.TbItemDescMapper;
import com.ego.egoprovider.service.TbItemDescService;
import com.ego.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TbItemDescServiceImpl implements TbItemDescService {

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public int insDesc(TbItemDesc tbItemDesc) {
        return tbItemDescMapper.insertSelective(tbItemDesc);
    }
}
