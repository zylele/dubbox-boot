package cn.xingyun.base.db;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据库配置
 * 
 * @author ShimonXin
 * @created 2015-6-16
 * 
 */
@Configuration
@EnableAutoConfiguration
@MapperScan(basePackages = "cn.xingyun.base.*.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DatabaseConfiguration {
	
	@Autowired
	private ApplicationContext appContext;
	
	@Bean(name = "masterDataSource")
	@ConfigurationProperties(prefix = "master.datasource")
	@Primary
	public DataSource masterDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "slaveDataSource")
	@ConfigurationProperties(prefix = "slave.datasource")
	public DataSource slaveDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public AbstractRoutingDataSource roundRobinDataSouceProxy(@Qualifier("masterDataSource")DataSource master, @Qualifier("slaveDataSource") DataSource slave) {
		ReadWriteSplitRoutingDataSource proxy = new ReadWriteSplitRoutingDataSource();
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		targetDataSources.put(DbContextHolder.DbType.MASTER, master);
		targetDataSources.put(DbContextHolder.DbType.SLAVE,  slave);
		proxy.setDefaultTargetDataSource(master);
		proxy.setTargetDataSources(targetDataSources);
		return proxy;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource")DataSource master,	@Qualifier("slaveDataSource") DataSource slave) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();		
		sessionFactory.setDataSource((DataSource)appContext.getBean("roundRobinDataSouceProxy"));
		return sessionFactory.getObject();
	}
	
}
