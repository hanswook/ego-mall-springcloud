package com.ego.egoprovider.controller;


import com.ego.egoprovider.service.TbItemDescService;
import com.ego.egoprovider.service.TbItemService;
import com.ego.pojo.*;
import com.ego.pojo.entity.EasyUIDataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("rest/item")
public class TbItemController {

    @Autowired
    TbItemService tbItemService;

    @Autowired
    TbItemDescService tbItemDescService;

    @Value("${server.port}")
    String port;

    @RequestMapping("/selectByPage")
    public HansJSONResult selectTbItemByPage(Integer page) {
        List<TbItem> tbItems = tbItemService.selectByPage(page);
        return HansJSONResult.ok(tbItems);
    }

    @RequestMapping("/searchByPage")
    public HansJSONResult searchByPage(Integer page, Integer rows) {
        EasyUIDataGrid show = tbItemService.show(page, rows);
        return HansJSONResult.ok(show).setMsg("port:" + port);
    }

    @RequestMapping("/show")
    public EasyUIDataGrid show(Integer page, Integer rows) {
        return tbItemService.show(page, rows);
    }


    @RequestMapping("/delete")
    public HansJSONResult delete(String ids) {
        int index = tbItemService.update(ids, (byte) 3);
        if (index == 1) {
            return HansJSONResult.ok();
        }
        return HansJSONResult.errorException("删除失败");
    }


    @RequestMapping("/reshelf")
    public HansJSONResult reshelf(String ids) {
        int index = tbItemService.update(ids, (byte) 1);
        if (index == 1) {
            return HansJSONResult.ok();
        }
        return HansJSONResult.errorException("上架失败");
    }

    @RequestMapping("/instock")
    public HansJSONResult instock(String ids) {
        int index = tbItemService.update(ids, (byte) 2);
        if (index == 1) {
            return HansJSONResult.ok();
        }
        return HansJSONResult.errorException("下架失败");
    }


    @RequestMapping("/update")
    public int update(TbItem tbItem) {
        return tbItemService.update(tbItem);
    }

    @RequestMapping("/update2")
    public int update(String ids, byte status) {
        return tbItemService.update(ids, status);
    }


    @RequestMapping(value = "/insTbItem", method = RequestMethod.POST)
    public int insTbItem(@RequestBody TbItem tbItem) {
        return tbItemService.insTbItem(tbItem);
    }


    @RequestMapping(value = "save", method = RequestMethod.POST)
    public int save(@RequestBody TbItemSaveReq tbItemSaveReq) {

        /*TbItem tbItem = tbItemSaveReq.getTbItem();
        String desc = tbItemSaveReq.getDesc();
        Date date = new Date();
        tbItem.setCreated(date);
        tbItem.setUpdated(date);
        tbItem.setStatus((byte) 1);
        int index = tbItemService.insTbItem(tbItem);
        if (index > 0) {
            TbItemDesc tbItemDesc = new TbItemDesc();
            tbItemDesc.setItemDesc(desc);
            tbItemDesc.setCreated(date);
            tbItemDesc.setUpdated(date);
            index += tbItemDescService.insDesc(tbItemDesc);
        }
        if (index == 2) {
            return 1;
        }
        return 0;*/
        TbItem tbItem = tbItemSaveReq.getTbItem();
        String desc = tbItemSaveReq.getDesc();
        Date date = new Date();
        tbItem.setCreated(date);
        tbItem.setUpdated(date);
        tbItem.setStatus((byte) 1);

        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        int index = 0;
        try {
            index = tbItemService.insTbItemDesc(tbItem, tbItemDesc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index;
    }

    @RequestMapping(value = "/insTbItemV2", method = RequestMethod.POST)
    public int insTbItem(@RequestBody TbItemSaveReq tbItemSaveReq) {
        TbItem tbItem = tbItemSaveReq.getTbItem();
        String desc = tbItemSaveReq.getDesc();
        Date date = new Date();
        tbItem.setCreated(date);
        tbItem.setUpdated(date);
        tbItem.setStatus((byte) 1);

        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);

        TbItemParamItem tbItemParam=tbItemSaveReq.getTbItemParam();
        tbItemParam.setCreated(date);
        tbItemParam.setUpdated(date);

        System.out.println("v2接口");
        int index = 0;
        try {
            index = tbItemService.insTbItem(tbItem, tbItemDesc,tbItemParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index;
    }
}
