package com.huang.common;


/**
 * describe: 统计kpi的名称枚举类
 * @creat_user: c_huangzhijun
 * creat_date: 2018/2/12
 * creat_time: 14:19
 **/
public enum  KpiType {
    NEW_INSTALL_USER("new_install_user"),
    BROWSER_NEW_INSTALL_USER("browser_new_install_user");

    public final String name;

    private KpiType(String name){
        this.name = name;
    }

}
