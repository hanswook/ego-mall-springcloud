package com.ego.egoconsumer.service;

import com.ego.pojo.*;
import com.ego.pojo.entity.EasyUIDataGrid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "ego-provider", fallback = TbItemConsumerServiceHystric.class)
public interface TbItemConsumerService {

    @RequestMapping(value = "rest/item/show", method = RequestMethod.GET)
    EasyUIDataGrid show(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows);

    @RequestMapping(value = "rest/item/update", method = RequestMethod.GET)
    int update(@RequestParam(value = "tbItem") TbItem tbItem);


    @RequestMapping(value = "rest/item/update2", method = RequestMethod.GET)
    int update(@RequestParam(value = "ids") String ids, @RequestParam(value = "status") byte status);

    @RequestMapping(value = "rest/item/searchByPage", method = RequestMethod.GET)
    HansJSONResult searchByPage(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows);


    @RequestMapping(value = "rest/item/cat/showItemCatList", method = RequestMethod.GET)
    List<TbItemCat> showItemCatList(@RequestParam(value = "pid") long pid);


    @RequestMapping(value = "rest/item/desc/insDesc", method = RequestMethod.POST)
    int insDesc(@RequestBody TbItemDesc tbItemDesc);

    @RequestMapping(value = "rest/item/insTbItem", method = RequestMethod.POST)
    int insTbItem(@RequestBody TbItem tbItem);

    @RequestMapping(value = "rest/item/param/searchByPage", method = RequestMethod.GET)
    List<TbItemParam> searchParamsByPage(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows);

    @RequestMapping(value = "rest/item/param/delIds", method = RequestMethod.GET)
    int deleteIds(@RequestParam(value = "ids") String ids);


    @RequestMapping(value = "rest/item/param/selByCatId/{catId}")
    TbItemParam selByCatId(@PathVariable(value = "catId") long catId);


    @RequestMapping(value = "rest/item/param/insParam", method = RequestMethod.POST)
    int insParam(@RequestBody TbItemParam tbItemParam);

    @RequestMapping(value = "rest/item/insTbItemV2", method = RequestMethod.POST)
    int insTbItem(@RequestBody TbItemSaveReq tbItemSaveReq);


    @RequestMapping(value = "rest/content/category/selByPid", method = RequestMethod.GET)
    List<TbContentCategory> selByPid(@RequestParam(value = "id") long id);

    @RequestMapping(value = "rest/content/category/create", method = RequestMethod.POST)
    int create(@RequestBody TbContentCategory category);

    @RequestMapping(value = "rest/content/category/selById", method = RequestMethod.GET)
    TbContentCategory selById(@RequestParam(value = "id") long id);

    @RequestMapping(value = "rest/content/category/update", method = RequestMethod.POST)
    int updateCategory(@RequestBody TbContentCategory category);

    @RequestMapping(value = "rest/content/searchByCid", method = RequestMethod.GET)
    List<TbContent> searchByCid(@RequestParam(value = "cid") long cid, @RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows);

    @RequestMapping(value = "rest/content/create", method = RequestMethod.POST)
    int insertTbContent(@RequestBody TbContent tbContent);

}


