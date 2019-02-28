package com.ego.pojo;

public class TbItemSaveReq {

    private TbItem tbItem;

    private String desc;

    private TbItemParamItem tbItemParamItem;

    public TbItem getTbItem() {
        return tbItem;
    }

    public void setTbItem(TbItem tbItem) {
        this.tbItem = tbItem;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TbItemParamItem getTbItemParam() {
        return tbItemParamItem;
    }

    public void setTbItemParam(TbItemParamItem tbItemParam) {
        this.tbItemParamItem = tbItemParam;
    }
}
