package com.ego.egoprovider.controller;

import com.ego.egoprovider.service.TbItemDescService;
import com.ego.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/item/desc")
public class TbItemDescController {

    @Autowired
    TbItemDescService tbItemDescService;

    @RequestMapping(value = "/insDesc",method = RequestMethod.POST)
    public int insDesc(@RequestBody TbItemDesc tbItemDesc){
        return tbItemDescService.insDesc(tbItemDesc);
    }

}
