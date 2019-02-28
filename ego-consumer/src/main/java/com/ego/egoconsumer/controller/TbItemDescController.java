package com.ego.egoconsumer.controller;


import com.ego.egoconsumer.service.TbItemConsumerService;
import com.ego.pojo.HansJSONResult;
import com.ego.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/item/desc")
public class TbItemDescController {

    @Autowired
    TbItemConsumerService tbItemConsumerService;


    @RequestMapping("/insDesc")
    public HansJSONResult insDesc(TbItemDesc tbItemDesc) {
        int result = tbItemConsumerService.insDesc(tbItemDesc);
        if (result == 1) {
            return HansJSONResult.ok("插入desc成功");
        }
        return HansJSONResult.errorMsg("插入desc失败");
    }


}
