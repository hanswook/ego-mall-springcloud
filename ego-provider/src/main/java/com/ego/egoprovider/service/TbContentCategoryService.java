package com.ego.egoprovider.service;

import com.ego.pojo.TbContentCategory;

import java.util.List;

public interface TbContentCategoryService {


    /**
     * 根据父id查询所有子类目
     *
     * @param id
     * @return
     */
    List<TbContentCategory> selByPid(long id);


    /**
     * 新增
     *
     * @param category
     * @return
     */
    int insTbContentCategory(TbContentCategory category);


    /**
     * 修改isparent属性
     *
     * @param category
     * @return
     */
    int updIsParentById(TbContentCategory category);


    /**
     * 通过id查询内容类目详细信息
     *
     * @param id
     * @return
     */
    TbContentCategory selById(long id);

}
