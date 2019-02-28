package com.ego.pojo.entity;

import java.util.List;

public class EasyUIDataGrid<T> {

    //当前页显示数据
    private List<T> rows;

    //总条数
    private long total;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
