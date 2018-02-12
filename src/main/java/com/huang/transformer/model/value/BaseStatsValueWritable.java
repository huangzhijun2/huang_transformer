package com.huang.transformer.model.value;


import com.huang.common.KpiType;
import org.apache.hadoop.io.Writable;

/**
 * describe: 自定义顶级的输出value父类
 * @creat_user: c_huangzhijun
 * creat_date: 2018/2/12
 * creat_time: 14:10
 **/
public abstract class BaseStatsValueWritable implements Writable{
    /**
     * 获取当前value对应的kpi值
     * @return
     */
    public abstract KpiType getKpi();
}
