package com.ego.egoprovider.controller;


import com.ego.egoprovider.service.TbItemParamService;
import com.ego.pojo.TbItemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/item/param")
public class TbItemParamController {

    @Autowired
    TbItemParamService tbItemParamService;


    @RequestMapping(value = "/searchByPage", method = RequestMethod.GET)
    public List<TbItemParam> searchByPage(int page, int rows) {
        return tbItemParamService.showPage(page, rows);
    }


    @RequestMapping(value = "/delIds", method = RequestMethod.GET)
    public int deleteIds(String ids) throws Exception {
        return tbItemParamService.delByIds(ids);
    }

    @RequestMapping(value = "/selByCatId/{catId}")
    public TbItemParam selByCatId(@PathVariable(value = "catId") long catId) {
        return tbItemParamService.selByCatId(catId);
    }


    @RequestMapping(value = "/insParam", method = RequestMethod.POST)
    public int save(@RequestBody TbItemParam tbItemParam) {
        return tbItemParamService.insParam(tbItemParam);
    }

}

