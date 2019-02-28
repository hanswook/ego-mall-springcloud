package com.ego.egoconsumer.controller;


import com.ego.egoconsumer.service.TbItemConsumerService;
import com.ego.pojo.HansJSONResult;
import com.ego.pojo.TbItemCat;
import com.ego.pojo.entity.EasyUiTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rest/item/cat")
public class TbItemCatController {

    @Autowired
    TbItemConsumerService tbItemCatConsumerService;


    @RequestMapping("/list")
    public HansJSONResult showItemCatList(@RequestParam(defaultValue = "0") long pid) {

        List<TbItemCat> list = tbItemCatConsumerService.showItemCatList(pid);
        List<EasyUiTree> listTree = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            EasyUiTree tree = new EasyUiTree();
            tree.setId(tbItemCat.getId());
            tree.setText(tbItemCat.getName());
            tree.setState(tbItemCat.getIsParent() ? "closed" : "open");
            listTree.add(tree);
        }
        return HansJSONResult.ok(listTree);
    }


}
