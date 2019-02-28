package com.ego.egoconsumer.controller;


import com.ego.egoconsumer.service.TbItemConsumerService;
import com.ego.pojo.HansJSONResult;
import com.ego.pojo.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/content/category")
public class TbContentCategoryController {

    @Autowired
    private TbItemConsumerService tbItemConsumerService;

    @RequestMapping(value = "/showCategory", method = RequestMethod.GET)
    public HansJSONResult showCategory(long id) {
        List<TbContentCategory> tbContentCategories = tbItemConsumerService.selByPid(id);
        if (null != tbContentCategories) {
            return HansJSONResult.ok(tbContentCategories);
        }
        return HansJSONResult.errorMsg("类目请求失败！");

    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public HansJSONResult create(@RequestBody TbContentCategory tbContentCategory) {
        int i = tbItemConsumerService.create(tbContentCategory);
        if (i == 1) {
            return HansJSONResult.ok("创建类目成功");
        }
        return HansJSONResult.errorMsg("创建类目失败");
    }

    @RequestMapping(value = "/selById", method = RequestMethod.GET)
    public HansJSONResult selById(long id) {
        TbContentCategory tbContentCategory = tbItemConsumerService.selById(id);
        if (null != tbContentCategory) {
            return HansJSONResult.ok(tbContentCategory);
        }
        return HansJSONResult.errorMsg("失败");
    }

}
