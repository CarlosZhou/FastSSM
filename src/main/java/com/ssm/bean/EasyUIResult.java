package com.ssm.bean;

import java.util.List;

/**
 * 
 * All rights Reserved, Designed By carlos-y
 * @ClassName:  EasyUiResult   
 * @Description: 界面对应的数据实体类  pojo下的只对应数据库
 * @author: carlos-y
 * @date:   2016年11月28日 下午3:18:13
 */
public class EasyUIResult {
             
    private Long total;

    private List<?> rows;

    public EasyUIResult() {

    }

    public EasyUIResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
