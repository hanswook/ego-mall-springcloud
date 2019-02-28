package com.ego.egoprovider.service.impl;

import com.ego.egoprovider.mapper.TbItemParamMapper;
import com.ego.egoprovider.service.TbItemParamService;
import com.ego.pojo.TbItemParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TbItemParamServiceImpl implements TbItemParamService {


    @Autowired
    TbItemParamMapper tbItemParamMapper;

    @Override
    public List<TbItemParam> showPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        Example example = new Example(TbItemParam.class);
        List<TbItemParam> tbItemParams = tbItemParamMapper.selectByExample(example);
        PageInfo<TbItemParam> pi = new PageInfo<>(tbItemParams);
        return pi.getList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delByIds(String ids) throws Exception {
        String[] idStr = ids.split(",");
        int index = 0;
        for (String id : idStr) {
            index += tbItemParamMapper.deleteByPrimaryKey(Long.parseLong(id));
        }
        if (index == idStr.length) {
            return 1;
        } else {
            throw new Exception("删除失败,可能数据不存在");
        }
    }

    @Override
    public TbItemParam selByCatId(long catId) {
        Example example = new Example(TbItemParam.class);

        example.createCriteria().andEqualTo("itemCatId", catId);
        List<TbItemParam> tbItemParams = tbItemParamMapper.selectByExample(example);

        if (tbItemParams != null && tbItemParams.size() > 0) {
            return tbItemParams.get(0);
        }
        return null;
    }

    @Override
    public int insParam(TbItemParam tbItemParam) {
        return tbItemParamMapper.insertSelective(tbItemParam);
    }
}
