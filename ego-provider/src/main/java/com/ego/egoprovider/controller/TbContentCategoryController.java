package com.ego.egoprovider.controller;


import com.ego.egoprovider.service.TbContentCategoryService;
import com.ego.pojo.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("rest/content/category")
public class TbContentCategoryController {


    @Autowired
    TbContentCategoryService tbContentCategoryService;


    @RequestMapping(value = "/selByPid", method = RequestMethod.GET)
    public List<TbContentCategory> selByPid(long id) {
        return tbContentCategoryService.selByPid(id);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody TbContentCategory category) {

        List<TbContentCategory> tbContentCategories = tbContentCategoryService.selByPid(category.getParentId());
        for (TbContentCategory tbContentCategory : tbContentCategories) {
            if (tbContentCategory.getName().equalsIgnoreCase(category.getName())) {
                return 0;
            }
        }


        Date date = new Date();
        category.setCreated(date);
        category.setUpdated(date);
        category.setStatus(1);
        category.setSortOrder(1);
        category.setIsParent(false);
        int index = tbContentCategoryService.insTbContentCategory(category);
        if (index > 0) {
            TbContentCategory parent = new TbContentCategory();
            parent.setId(category.getParentId());
            parent.setIsParent(true);
            tbContentCategoryService.updIsParentById(parent);
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "/selById", method = RequestMethod.GET)
    public TbContentCategory selById(long id) {
        return tbContentCategoryService.selById(id);
    }





}
