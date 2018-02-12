package com.huang.transformer.mr.nu;

import com.huang.common.EventLogConstants;
import com.huang.common.KpiType;
import com.huang.transformer.model.dim.StatsUserDimension;
import com.huang.transformer.model.dim.base.KpiDimension;
import com.huang.transformer.model.value.map.TimeOutputValue;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

import java.io.IOException;


/**
 * describe: 自定义的计算新用户的mapper类
 * @creat_user: c_huangzhijun
 * creat_date: 2018/2/12
 * creat_time: 14:57
 **/
public class NewInstallUserMapper extends TableMapper<StatsUserDimension,TimeOutputValue> {
    private static final Logger logger = Logger.getLogger(NewInstallUserMapper.class);
    private StatsUserDimension statsUserDimension = new StatsUserDimension();
    private TimeOutputValue timeOutputValue = new TimeOutputValue();
    private byte[] family = Bytes.toBytes(EventLogConstants.EVENT_LOGS_FAMILY_NAME);
    private KpiDimension newInstallUserKpi = new KpiDimension(KpiType.NEW_INSTALL_USER.name);
    private KpiDimension newInstallUserOfBrowserKpi = new KpiDimension(KpiType.BROWSER_NEW_INSTALL_USER.name);


    @Override
    protected void map(ImmutableBytesWritable key, Result value, Context context) throws IOException, InterruptedException {
        super.map(key, value, context);
    }
}
