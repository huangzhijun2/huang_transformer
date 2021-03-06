package com.huang.common;


/**
 * describe: 全局常量类
 * @creat_user: c_huangzhijun
 * creat_date: 2018/2/8
 * creat_time: 14:05
 **/
public class GlobalConstants {

    public static final String HDFS_LOG_PATH = "/cpic/bigdata/huang/";
    /**
     * 一天的毫秒数
     */
    public static final int DAY_OF_MILLISECONDS = 86400000;
    /**
     * 定义的运行时间变量名
     */
    public static final String RUNNING_DATE_PARAMES = "RUNNING_DATE";
    /**
     * 默认值
     */
    public static final String DEFAULT_VALUE = "unknown";
    /**
     * 维度信息表中指定全部列值
     */
    public static final String VALUE_OF_ALL = "all";

    /**
     * 定义的output collector的前缀
     */
    public static final String OUTPUT_COLLECTOR_KEY_PREFIX = "collector_";

    /**
     * 指定连接表配置为report
     */
//    public static final String WAREHOUSE_OF_REPORT = "report";
    public static final String WAREHOUSE_OF_REPORT = "chnldb";

    /**
     * 批量执行的key
     */
//    public static final String JDBC_BATCH_NUMBER = "mysql.batch.number";
    public static final String JDBC_BATCH_NUMBER = "oracle.batch.number";

    /**
     * 默认批量大小
     */
    public static final String DEFAULT_JDBC_BATCH_NUMBER = "500";

    /**
     * driver 名称
     */
//    public static final String JDBC_DRIVER = "mysql.%s.driver";
    public static final String JDBC_DRIVER = "oracle.%s.driver";

    /**
     * JDBC URL
     */
//    public static final String JDBC_URL = "mysql.%s.url";
    public static final String JDBC_URL = "oracle.%s.url";

    /**
     * username名称
     */
    public static final String JDBC_USERNAME = "oracle.%s.username";
//    public static final String JDBC_USERNAME = "mysql.%s.username";

    /**
     * password名称
     */
//    public static final String JDBC_PASSWORD = "mysql.%s.password";
    public static final String JDBC_PASSWORD = "oracle.%s.password";
}
