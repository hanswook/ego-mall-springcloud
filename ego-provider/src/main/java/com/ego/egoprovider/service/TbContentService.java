package com.ego.egoprovider.service;

import com.ego.pojo.TbContent;

import java.util.List;

public interface TbContentService {

    List<TbContent> searchByCid(long cid, int page, int pageSize);

    /**
     * 新增
     *
     * @param tbContent
     * @return
     */
    int insertTbContent(TbContent tbContent);
}
