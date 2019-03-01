package com.ego.egoprovider.service.impl;

import com.ego.egoprovider.mapper.TbContentMapper;
import com.ego.egoprovider.service.TbContentService;
import com.ego.pojo.TbContent;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    TbContentMapper tbContentMapper;


    @Override
    public List<TbContent> searchByCid(long cid, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);

        Example example=new Example(TbContent.class);
        example.createCriteria().andEqualTo("categoryId",cid);
        List<TbContent> tbContents = tbContentMapper.selectByExample(example);
        return tbContents;
    }

    @Override
    public int insertTbContent(TbContent tbContent) {
        return tbContentMapper.insert(tbContent);
    }
}
