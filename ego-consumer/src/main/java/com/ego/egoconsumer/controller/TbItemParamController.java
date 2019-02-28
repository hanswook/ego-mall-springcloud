package com.ego.egoconsumer.controller;


import com.ego.egoconsumer.service.TbItemConsumerService;
import com.ego.pojo.HansJSONResult;
import com.ego.pojo.TbItemParam;
import com.ego.pojo.TbItemSaveReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("rest/item/param")
public class TbItemParamController {

    @Autowired
    TbItemConsumerService tbItemConsumerService;


    @RequestMapping("/searchByPage")
    public HansJSONResult searchByPage(int page, int rows) {
        List<TbItemParam> tbItemParams = tbItemConsumerService.searchParamsByPage(page, rows);
        return HansJSONResult.ok(tbItemParams);
    }

    @RequestMapping("/delIds")
    public HansJSONResult deleteIds(String ids) {
        int i = tbItemConsumerService.deleteIds(ids);
        if (i == 1) {
            return HansJSONResult.ok("删除成功");
        }
        return HansJSONResult.errorMsg("删除失败");
    }


    @RequestMapping("/selByCatId/{catId}")
    public HansJSONResult selByCatId(@PathVariable(value = "catId") long catId) {
        TbItemParam tbItemParam = tbItemConsumerService.selByCatId(catId);
        if (null != tbItemParam) {
            return HansJSONResult.ok(tbItemParam);
        }
        return HansJSONResult.errorMsg("查询失败");
    }

    @RequestMapping(value = "/insParam/{catId}", method = RequestMethod.POST)
    public HansJSONResult insParam(@RequestBody TbItemParam tbItemParam, @PathVariable(value = "catId") long catId) {
        TbItemParam tbItemParam1 = tbItemConsumerService.selByCatId(catId);
        if (null != tbItemParam1) {
            return HansJSONResult.errorMsg("插入规格,已存在对应类目");
        }
        tbItemParam.setItemCatId(catId);

        Date date = new Date(System.currentTimeMillis());
        tbItemParam.setUpdated(date);
        tbItemParam.setCreated(date);
        int i = tbItemConsumerService.insParam(tbItemParam);
        if (i == 1) {
            return HansJSONResult.ok("插入成功");
        }
        return HansJSONResult.errorMsg("插入规格参数失败");
    }


    @RequestMapping(value = "/insTbItem", method = RequestMethod.POST)
    public HansJSONResult insTbItem(@RequestBody TbItemSaveReq tbItemSaveReq) {
        int i = tbItemConsumerService.insTbItem(tbItemSaveReq);
        if (i == 1) {
            return HansJSONResult.ok("插入tbitem 成功");
        }
        return HansJSONResult.errorMsg("插入 tbitem 失败");
    }

}
