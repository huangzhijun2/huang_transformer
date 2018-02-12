package com.huang.transformer.mr;


import com.huang.transformer.model.dim.base.BaseDimension;
import com.huang.transformer.model.value.BaseStatsValueWritable;
import com.huang.transformer.service.IDimensionConverter;
import org.apache.hadoop.conf.Configuration;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * describe: 自定义的配合自定义output进行具体sql输出的类
 * @creat_user: c_huangzhijun
 * creat_date: 2018/2/12
 * creat_time: 14:43
 **/
public interface IOutputCollector {

    /**
     * 具体执行统计数据插入的方法
     * @param conf
     * @param key
     * @param value
     * @param pstmt
     * @param converter
     * @throws SQLException
     * @throws IOException
     */
    public void collect(Configuration conf, BaseDimension key, BaseStatsValueWritable value, PreparedStatement pstmt, IDimensionConverter converter)throws SQLException, IOException;
}
