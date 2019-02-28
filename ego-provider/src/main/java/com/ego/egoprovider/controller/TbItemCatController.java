package com.ego.egoprovider.controller;


import com.ego.egoprovider.service.TbItemCatService;
import com.ego.pojo.TbItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/item/cat")
public class TbItemCatController {

    @Autowired
    TbItemCatService tbItemCatService;

    @RequestMapping("/showItemCatList")
    public List<TbItemCat> showItemCatList(long pid) {
        return tbItemCatService.show(pid);
    }

}
