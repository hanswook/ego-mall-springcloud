package com.ego.egoprovider.controller;


import com.ego.egoprovider.service.TbContentService;
import com.ego.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("rest/content")
public class TbContentController {

    @Autowired
    TbContentService tbContentService;


    @RequestMapping("/searchByCid")
    public List<TbContent> searchByCid(long cid, int page, int rows) {
        return tbContentService.searchByCid(cid, page, rows);
    }

    @RequestMapping("/create")
    public int insertTbContent(@RequestBody TbContent tbContent) {
        Date date=new Date();
        tbContent.setCreated(date);
        tbContent.setUpdated(date);
        return tbContentService.insertTbContent(tbContent);
    }
}
