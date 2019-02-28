package com.ego.egoconsumer.controller;


import com.ego.egoconsumer.service.TbItemConsumerService;
import com.ego.pojo.HansJSONResult;
import com.ego.pojo.TbItem;
import com.ego.pojo.entity.EasyUIDataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/item")
public class TbItemController {

    @Autowired
    TbItemConsumerService tbItemConsumerService;


    @RequestMapping("/searchByPage")
    public HansJSONResult searchByPage(Integer page, Integer rows) {
        EasyUIDataGrid show = tbItemConsumerService.show(page, rows);
        return HansJSONResult.ok(show);
    }

    @RequestMapping("/searchByPage2")
    public HansJSONResult searchByPage2(Integer page, Integer rows) {
        return tbItemConsumerService.searchByPage(page, rows);
    }

    @RequestMapping("/delete")
    public HansJSONResult delete(String ids) {
        int index = tbItemConsumerService.update(ids, (byte) 3);
        if (index == 1) {
            return HansJSONResult.ok();
        }
        return HansJSONResult.errorException("consumer 删除失败");
    }


    @RequestMapping("/reshelf")
    public HansJSONResult reshelf(String ids) {
        int index = tbItemConsumerService.update(ids, (byte) 1);
        if (index == 1) {
            return HansJSONResult.ok();
        }
        return HansJSONResult.errorException("consumer 上架失败");
    }

    @RequestMapping("/instock")
    public HansJSONResult instock(String ids) {
        int index = tbItemConsumerService.update(ids, (byte) 2);
        if (index == 1) {
            return HansJSONResult.ok();
        }
        return HansJSONResult.errorException("consumer 下架失败");
    }


    @RequestMapping("/insTbItem")
    public HansJSONResult insTbItem(TbItem tbItem){
        int index=tbItemConsumerService.insTbItem(tbItem);
        if (index==1){
            return HansJSONResult.ok("插入成功");
        }
        return HansJSONResult.errorException("consumer 插入失败");
    }



}
