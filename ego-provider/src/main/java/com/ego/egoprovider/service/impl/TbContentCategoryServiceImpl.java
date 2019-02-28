package com.ego.egoprovider.service.impl;

import com.ego.egoprovider.mapper.TbContentCategoryMapper;
import com.ego.egoprovider.service.TbContentCategoryService;
import com.ego.pojo.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {


    @Autowired
    TbContentCategoryMapper tbContentCategoryMapper;


    @Override
    public List<TbContentCategory> selByPid(long id) {
        Example example = new Example(TbContentCategory.class);
        example.createCriteria().andEqualTo("parentId", id);
        List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample(example);
        return tbContentCategories;
    }

    @Override
    public int insTbContentCategory(TbContentCategory category) {
        return tbContentCategoryMapper.insertSelective(category);
    }

    @Override
    public int updIsParentById(TbContentCategory category) {
        return tbContentCategoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public TbContentCategory selById(long id) {
        return tbContentCategoryMapper.selectByPrimaryKey(id);
    }
}
