package com.ego.egoprovider.service;

import com.ego.pojo.TbItemParam;

import java.util.List;

public interface TbItemParamService {

    List<TbItemParam> showPage(int page, int rows);


    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int delByIds(String ids) throws Exception;

    TbItemParam selByCatId(long catId);


    /**
     * 新增规格，支持主键自增
     * @param tbItemParam
     * @return
     */
    int insParam(TbItemParam tbItemParam);

}
