package com.cist.frame.datasource;
import javax.sql.DataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

@Configuration
@MapperScan(basePackages="com.**.mapper", sqlSessionFactoryRef="masterSqlFactory")
public class MasterDataSourcesConfig {
	    @ConfigurationProperties("spring.datasource")
	    @Primary
	    @Bean(name = "masterDataSource")
	    public DruidDataSource druidDataSource() {
	        return new DruidDataSource();
	    }


	    @Bean(name = "masterTransactionManager")
	    @Primary
	    public DataSourceTransactionManager masterTransactionManager() {
	        return new DataSourceTransactionManager(druidDataSource());
	    }


	    @Bean(name = "masterSqlFactory")
	    @Primary
	    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource,@Qualifier("pageHelper") PageHelper pagehelper) throws Exception {
	        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
	        sessionFactoryBean.setDataSource(dataSource);
	        Interceptor[] plugins =  new Interceptor[]{pagehelper};  
	        sessionFactoryBean.setPlugins(plugins);  
	        return sessionFactoryBean.getObject();
	    }
}
