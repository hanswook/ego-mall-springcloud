package com.ego.egoconsumer.service;

import com.ego.pojo.*;
import com.ego.pojo.entity.EasyUIDataGrid;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TbItemConsumerServiceHystric implements TbItemConsumerService {
    @Override
    public EasyUIDataGrid show(int page, int rows) {
        return null;
    }

    @Override
    public int update(TbItem tbItem) {
        return 0;
    }

    @Override
    public int update(String ids, byte status) {
        return 0;
    }

    @Override
    public HansJSONResult searchByPage(int page, int rows) {
        return HansJSONResult.errorMsg("服务异常");
    }

    @Override
    public List<TbItemCat> showItemCatList(long pid) {
        return null;
    }

    @Override
    public int insDesc(TbItemDesc tbItemDesc) {
        return 0;
    }

    @Override
    public int insTbItem(TbItem tbItem) {
        return 0;
    }

    @Override
    public List<TbItemParam> searchParamsByPage(int page, int rows) {
        return null;
    }

    @Override
    public int deleteIds(String ids) {
        return 0;
    }

    @Override
    public TbItemParam selByCatId(long catId) {
        return null;
    }

    @Override
    public int insParam(TbItemParam tbItemParam) {
        return 0;
    }

    @Override
    public int insTbItem(TbItemSaveReq tbItemSaveReq) {
        return 0;
    }

    @Override
    public List<TbContentCategory> selByPid(long id) {
        return null;
    }

    @Override
    public int create(TbContentCategory category) {
        return 0;
    }

    @Override
    public TbContentCategory selById(long id) {
        return null;
    }
}
