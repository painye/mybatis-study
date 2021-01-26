package com.yp.mybatis.druid.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * 使用druid作为mybatis的数据源
 *      要用自己的数据源必须先继承UnpooledDataSourceFactory
 */
public class MyDataSource extends UnpooledDataSourceFactory {
    public MyDataSource(){
        //new了一个新的数据源替换了原来的数据源
        this.dataSource=new DruidDataSource();
    }
}
