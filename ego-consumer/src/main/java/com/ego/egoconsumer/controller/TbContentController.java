package com.ego.egoconsumer.controller;

import com.ego.egoconsumer.service.TbItemConsumerService;
import com.ego.pojo.HansJSONResult;
import com.ego.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/content")
public class TbContentController {

    @Autowired
    TbItemConsumerService tbItemConsumerService;

    @RequestMapping("/searchByCid")
    public HansJSONResult searchByCid(@RequestParam(value = "cid") long cid, @RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows) {
        List<TbContent> tbContents = tbItemConsumerService.searchByCid(cid, page, rows);
        if (null == tbContents) {
            return HansJSONResult.errorMsg("查询失败");
        }
        return HansJSONResult.ok(tbContents);
    }

    @RequestMapping("/create")
    public HansJSONResult insertTbContent(@RequestBody TbContent tbContent) {
        int i = tbItemConsumerService.insertTbContent(tbContent);
        if (i == 1) {
            return HansJSONResult.ok("创建成功");
        }
        return HansJSONResult.errorMsg("创建失败");
    }
}
