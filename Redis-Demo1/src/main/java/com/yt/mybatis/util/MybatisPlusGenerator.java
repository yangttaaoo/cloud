package com.yt.mybatis.util;
 
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
 

/***
 * 
 * @Title:MybatisPlusGenerator.java
 * @Package:com.example.demo.mybatis.util
 * @Description:代码生成器
 * @author:YT
 * @date:2019年4月29日
 * @version V1.0
 */
public class MybatisPlusGenerator {
	private static MybatisPlusGenerator single = null;
	
	private MybatisPlusGenerator() {
		super();
	}
	
	private static MybatisPlusGenerator getSingle() {
		if(single == null) {
			single =new MybatisPlusGenerator();
		}
		return single;
	}
	
	public void autoGeneration() {
		 GlobalConfig config = new GlobalConfig();
	        String dbUrl = "jdbc:mysql://129.204.34.168:3306/test?sys_config";
	        DataSourceConfig dataSourceConfig = new DataSourceConfig();
	        dataSourceConfig.setDbType(DbType.MYSQL)
	                .setUrl(dbUrl)
	                .setUsername("root")
	                .setPassword("123456")
	                .setDriverName("com.mysql.cj.jdbc.Driver");
	        StrategyConfig strategyConfig = new StrategyConfig();
	        strategyConfig
	                .setCapitalMode(true)
	                .setEntityLombokModel(false)
	                .setDbColumnUnderline(true)
	                .setNaming(NamingStrategy.underline_to_camel);
	        config.setActiveRecord(false)
	                .setEnableCache(false)
	                .setAuthor("yt")
	                //指定输出文件夹位置
	                .setOutputDir("D:\\JiChuang\\Redis-Demo1\\src\\main\\java")
	                .setFileOverride(true)
	                .setServiceName("%sService");
	        new AutoGenerator().setGlobalConfig(config)
	                .setDataSource(dataSourceConfig)
	                .setStrategy(strategyConfig)
	                .setPackageInfo(
	                        new PackageConfig()
	                                .setParent("com.yt.demo")
	                                .setController("controller")
	                                .setEntity("entity")
	                ).execute();
	}
 
	public static void main(String[] args) {
		// TODO 生成
		MybatisPlusGenerator generator = MybatisPlusGenerator.getSingle();
		generator.autoGeneration();
	}
 
}
