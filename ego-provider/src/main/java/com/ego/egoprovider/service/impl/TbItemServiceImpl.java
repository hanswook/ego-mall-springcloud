package com.ego.egoprovider.service.impl;

import com.ego.egoprovider.mapper.TbItemDescMapper;
import com.ego.egoprovider.mapper.TbItemMapper;
import com.ego.egoprovider.mapper.TbItemParamItemMapper;
import com.ego.egoprovider.mapper.TbItemParamMapper;
import com.ego.egoprovider.service.TbItemService;
import com.ego.pojo.*;
import com.ego.pojo.entity.EasyUIDataGrid;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;


@Service
public class TbItemServiceImpl implements TbItemService {

    @Autowired
    TbItemMapper tbItemMapper;

    @Autowired
    TbItemDescMapper tbItemDescMapper;

    @Autowired
    TbItemParamItemMapper tbItemParamMapper;


    @Override
    public List<TbItem> selectByPage(Integer page) {
        PageHelper.startPage(page, 10);

        Example example = new Example(TbItem.class);
        List<TbItem> userList = tbItemMapper.selectByExample(example);

        return userList;
    }

    @Override
    public EasyUIDataGrid show(int page, int rows) {

        PageHelper.startPage(page, rows);
        List<TbItem> tbItems = tbItemMapper.selectByExample(new Example(TbItem.class));

        PageInfo<TbItem> pi = new PageInfo<>(tbItems);
        EasyUIDataGrid<TbItem> easyUIDataGrid = new EasyUIDataGrid<>();
        easyUIDataGrid.setRows(pi.getList());
        easyUIDataGrid.setTotal(pi.getTotal());

        return easyUIDataGrid;
    }


    @Override
    public int update(String ids, byte status) {
        int index = 0;
        String[] splic = ids.split(",");
        TbItem tbItem = new TbItem();
        for (String id : splic) {
            tbItem.setId(Long.parseLong(id));
            tbItem.setStatus(status);
            index += tbItemMapper.updateByPrimaryKeySelective(tbItem);
        }

        if (index == splic.length) {
            return 1;
        }
        return 0;
    }

    @Override
    public int update(TbItem tbItem) {
        return tbItemMapper.updateByPrimaryKeySelective(tbItem);
    }

    @Override
    public int insTbItem(TbItem tbItem) {
        return tbItemMapper.insertSelective(tbItem);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insTbItemDesc(TbItem tbItem, TbItemDesc tbItemDesc) throws Exception {
        int index = 0;
        index += tbItemMapper.insertSelective(tbItem);
        index += tbItemDescMapper.insertSelective(tbItemDesc);

        if (index == 2) {
            return 1;
        } else {
            throw new Exception("新增失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insTbItem(TbItem tbItem, TbItemDesc tbItemDesc, TbItemParamItem tbItemParam) throws Exception {
        int index = 0;
        index += tbItemMapper.insertSelective(tbItem);
        index += tbItemDescMapper.insertSelective(tbItemDesc);
        index += tbItemParamMapper.insertSelective(tbItemParam);
        if (index == 3) {
            return 1;
        } else {
            throw new Exception("新增失败");
        }
    }
}
