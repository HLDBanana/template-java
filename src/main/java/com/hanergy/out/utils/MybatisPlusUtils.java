package com.hanergy.out.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @description: 数据库生成JAVA类
 * @author: Han LiDong
 * @create: 2020-07-20 14:00:00
 * @update: 2020-07-20 14:00:00
 */
public class MybatisPlusUtils {
    /**
     * mysql自动代码生成类
     *
     * @param includeTables
     * @param excludeTables
     */
    public static void generateMysql(String[] includeTables, String[] excludeTables, Boolean db1) {
        AutoGenerator autoGenerator = new AutoGenerator();
        /**
         * 数据库配置
         */
        buildMysqlDb(autoGenerator);
        StrategyConfig strategyConfig = new StrategyConfig();
        // 驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(includeTables);
        //strategyConfig.setExclude(excludeTables);
        strategyConfig.setTablePrefix("");
        autoGenerator.setStrategy(strategyConfig);
        /**
         * 全局配置
         */
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("Han LiDong");
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setActiveRecord(true);
        globalConfig.setIdType(IdType.INPUT);
        globalConfig.setOutputDir("C:/D/ORM");  //文件生成路径
        globalConfig.setMapperName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setSwagger2(true);
        globalConfig.setFileOverride(true);
        globalConfig.setBaseColumnList(false);
        globalConfig.setBaseResultMap(false);
        globalConfig.setEnableCache(false);
        autoGenerator.setGlobalConfig(globalConfig);

        /**
         * 包名配置
         */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("");
        packageConfig.setEntity("com.hanergy.out.entity");
        packageConfig.setMapper("com.hanergy.out.dao");
        packageConfig.setXml("mapper");
        packageConfig.setService("com.hanergy.out.service");
        packageConfig.setServiceImpl("com.hanergy.out.impl");
        packageConfig.setController("com.hanergy.out.controller");

        autoGenerator.setPackageInfo(packageConfig);
        // 采用默认模板,自定义模板参考@see com.baomidou.mybatisplus.generator.config.TemplateConfig
//        TemplateConfig templateConfig = new TemplateConfig();
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }

    /**
     * oracle自动代码生成类
     * @param includeTables
     * @param excludeTables
     */
    public static void generateOracle(String[] includeTables, String[] excludeTables, Boolean db1) {
        AutoGenerator autoGenerator = new AutoGenerator();
        buildOracleDb(autoGenerator);
        StrategyConfig strategyConfig = new StrategyConfig();
        // 驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(includeTables);
        strategyConfig.setExclude(excludeTables);
        strategyConfig.setTablePrefix("");
        autoGenerator.setStrategy(strategyConfig);
        /**
         * 全局配置
         */
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("Han LiDong");
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setActiveRecord(true);
        globalConfig.setIdType(IdType.AUTO);    //这里用oracle的序列和触发器实现主键自增
        globalConfig.setOutputDir("C:/D/ORM");  //文件生成路径
        globalConfig.setMapperName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setSwagger2(true);
        globalConfig.setFileOverride(true);
        globalConfig.setBaseColumnList(false);
        globalConfig.setBaseResultMap(false);
        globalConfig.setEnableCache(false);
        autoGenerator.setGlobalConfig(globalConfig);
        /**
         * 包名配置
         */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("");
        packageConfig.setEntity("com.hanergy.out.entity");
        packageConfig.setMapper("com.hanergy.out.dao");
        packageConfig.setXml("mapper");
        packageConfig.setService("com.hanergy.out.service");
        packageConfig.setServiceImpl("com.hanergy.out.impl");
        packageConfig.setController("com.hanergy.out.controller");

        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }

    private static void buildOracleDb(AutoGenerator autoGenerator) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbQuery(new MyDbQuery());   //自定义dbquery不然querydb.dbtype找不到
        dataSourceConfig.setDbType(DbType.ORACLE);
        dataSourceConfig.setDriverName("oracle.jdbc.driver.OracleDriver");
        dataSourceConfig.setUsername("multiplecheck");
        dataSourceConfig.setPassword("multiplecheck");
        dataSourceConfig.setUrl("jdbc:oracle:thin:@192.168.100.133/orcl");
        autoGenerator.setDataSource(dataSourceConfig);
    }

    private static void buildMysqlDb(AutoGenerator autoGenerator) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("15090667928Hh_");
        dataSourceConfig.setUrl("jdbc:mysql://182.92.219.202:3306/bank1?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        autoGenerator.setDataSource(dataSourceConfig);
    }

    public static void main(String[] args) {

        String[] includeTables = {"account_info"};
        generateMysql(includeTables,null,false);  //mysql映射文件生成
        //generateOracle(includeTables,null,false);      //oracle映射文件生成
    }
}
