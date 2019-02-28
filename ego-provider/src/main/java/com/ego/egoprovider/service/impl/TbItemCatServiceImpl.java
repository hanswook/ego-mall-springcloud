package com.ego.egoprovider.service.impl;

import com.ego.egoprovider.mapper.TbItemCatMapper;
import com.ego.egoprovider.service.TbItemCatService;
import com.ego.pojo.TbItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TbItemCatServiceImpl implements TbItemCatService {


    @Autowired
    TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> show(long pid) {
        Example example = new Example(TbItemCat.class);
        example.createCriteria().andEqualTo("parentId", pid);
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(example);
        return tbItemCats;
    }
}
