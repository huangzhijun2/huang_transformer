package com.huang.transformer.mr.nu;

import com.huang.common.KpiType;
import com.huang.transformer.model.dim.StatsUserDimension;
import com.huang.transformer.model.value.map.TimeOutputValue;
import com.huang.transformer.model.value.reduce.MapWritableValue;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * describe: 计算new isntall user的reduce类
 * @creat_user: c_huangzhijun
 * creat_date: 2018/2/13
 * creat_time: 9:43
 **/
public class NewInstallUserReducer extends Reducer<StatsUserDimension,TimeOutputValue,StatsUserDimension,MapWritableValue>{
    private MapWritableValue outputValue = new MapWritableValue();
    private Set<String> unique = new HashSet<String>();

    @Override
    protected void reduce(StatsUserDimension key, Iterable<TimeOutputValue> values, Context context) throws IOException, InterruptedException {
        this.unique.clear();

        // 开始计算uuid的个数
        for (TimeOutputValue value : values) {
            this.unique.add(value.getId());
        }
        MapWritable map = new MapWritable();
        map.put(new IntWritable(-1), new IntWritable(this.unique.size()));
        outputValue.setValue(map);

        // 设置kpi名称
        String kpiName = key.getStatsCommon().getKpi().getKpiName();
        if (KpiType.NEW_INSTALL_USER.name.equals(kpiName)) {
            // 计算stats_user表中的新增用户
            outputValue.setKpi(KpiType.NEW_INSTALL_USER);
        } else if (KpiType.BROWSER_NEW_INSTALL_USER.name.equals(kpiName)) {
            // 计算stats_device_browser表中的新增用户
            outputValue.setKpi(KpiType.BROWSER_NEW_INSTALL_USER);
        }
        context.write(key, outputValue);
    }
}
