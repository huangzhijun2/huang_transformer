package com.huang.transformer.service;

import com.huang.transformer.model.dim.base.BaseDimension;

/**
 * describe: 提供专门操作dimension表的接口
 * @creat_user: c_huangzhijun
 * creat_date: 2018/2/12
 * creat_time: 14:48
 **/
public interface IDimensionConverter {

    /**
     * 根据dimension的value值获取id
     * 如果数据库中有，那么直接返回。如果没有，那么进行插入后返回新的id值
     * @param dimension
     * @return
     */
    public int getDimensionIdByValue(BaseDimension dimension);
}
