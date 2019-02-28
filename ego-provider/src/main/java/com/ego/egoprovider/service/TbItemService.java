package com.ego.egoprovider.service;

import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemDesc;
import com.ego.pojo.TbItemParam;
import com.ego.pojo.TbItemParamItem;
import com.ego.pojo.entity.EasyUIDataGrid;

import java.util.List;

public interface TbItemService {

    List<TbItem> selectByPage(Integer page);


    EasyUIDataGrid show(int page, int rows);

    int update(String ids, byte status);

    int update(TbItem tbItem);

    int insTbItem(TbItem tbItem);

    int insTbItemDesc(TbItem tbItem, TbItemDesc tbItemDesc) throws Exception;

    int insTbItem(TbItem tbItem, TbItemDesc tbItemDesc, TbItemParamItem tbItemParam) throws Exception;
}
