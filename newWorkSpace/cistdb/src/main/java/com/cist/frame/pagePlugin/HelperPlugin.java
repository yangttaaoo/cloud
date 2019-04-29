package com.cist.frame.pagePlugin;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.pagehelper.PageHelper;

@Configuration
public class HelperPlugin {
	@Autowired
	private HelperBean helper;
	
	@Bean(name="pageHelper")
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum",helper.getOffsetAsPageNum());
        properties.setProperty("rowBoundsWithCount",helper.getRowBoundsWithCount());
        properties.setProperty("reasonable",helper.getReasonable());
        properties.setProperty("dialect",helper.getHelperDialect());    //配置mysql数据库的方言
        properties.setProperty("params",helper.getParams()); 
        pageHelper.setProperties(properties);
        return pageHelper;
    }
	
	public HelperBean getHelper() {
		return helper;
	}
	public void setHelper(HelperBean helper) {
		this.helper = helper;
	}
}
