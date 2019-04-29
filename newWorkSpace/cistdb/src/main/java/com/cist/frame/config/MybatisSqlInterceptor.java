package com.cist.frame.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;


/***
 * 
 * @Title:MybatisSqlInterceptor.java
 * @Package:com.cist.frame.config
 * @Description:TODO
 * @author:YT
 * @date:2019年3月30日
 * @version V1.0
 */
@Component
@Intercepts(@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
		RowBounds.class, ResultHandler.class }))
public class MybatisSqlInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		StringBuffer sql1 = new StringBuffer(getSqlByInvocation(invocation).toUpperCase());
		if (args.length > 0) {
			MappedStatement obj = (MappedStatement) args[0];
			ResultHandler object = (ResultHandler)args[3];
//			//获取SqlSessionFactory 用户获取SqlSession执行刷新mybatis缓存
//			SqlSessionFactory beanByName = SpringContextUtil.getBeanByName("masterSqlFactory", SqlSessionFactory.class);
//			//刷新缓存
//			beanByName.openSession().clearCache();
//			//关闭sqlSession
//			beanByName.openSession().close();
			// 获取查询方法的id
			String str = obj.getId();
			// 判断方法的id是否是需要权限 是否包含SecurityBy
			int indexOf = str.indexOf("SecurityBy");
			// 包含SecurityBy 并且包含To To后面是code 或者 pk 标识部门字段使用的是code还是pk
			int index = str.indexOf("To");
			// 判断参数是否可以转换map
			if(null != args[1] && args[1] instanceof Map) {
				HashMap map = (HashMap) args[1];
				// 如果不包含SecurityBy则不改变sql直接返回
				if (indexOf != -1 && index != -1) {
					// 查询表中部门字段的字段名  前台传递的参数 key 需要与表中字段名相同 如：dept_code = ""
					String dept = str.substring(indexOf + 10, index);//+10为SecurityBy的长度
					// 表中是使用的code还是pk
					String flagStr = str.substring(index + 2, str.length());//+2 为To的长度
					if(null == map.get(dept) || "".equals(map.get(dept))) {
						
						// 动态改变sql
						// 获取sql 拼接部门权限 将SQL转换成大写
						StringBuffer sql = new StringBuffer(getSqlByInvocation(invocation).toUpperCase());
						if (StringUtils.isBlank(sql.toString())) {
							return invocation.proceed();
						}
						
						String deptcode = "";
						// 如果为部门code则字段名为
						if ("code".equals(flagStr)) {
							deptcode = "DEPT_CODE";
						} else {
							deptcode = "DEPT_PK";
						}
						// 判断查询sql中是否包含where子句 和order by
		   	 int where = sql.indexOf("WHERE");
		   	 int lastIndexOf = sql.lastIndexOf("WHERE");
		   	 int lastIndexOf2 = sql.lastIndexOf("FROM");
		   	 int order = sql.indexOf("ORDER");
		   
		   	    if(where == -1 && order == -1 ) {
		   	    	sql =sql.append(" where exists(select * from sys_depart_info sec  where sec.dept_code = "+dept
		   	   	    		+ " start with "
		   	   	    		+deptcode
		   	   	    		+ " = "+map.get("dept")+" connect by prior DEPT_PK = sec.dept_superior)");
		   	    }else if(where == -1 && order != -1 ){
		   	    	sql = sql.insert(order, " where exists(select * from sys_depart_info sec  where sec.dept_code = "+dept
		   	   	    		+ " start with "
		   	   	    		+deptcode
		   	   	    	+ " = "+map.get("dept")+" connect by prior DEPT_PK = sec.dept_superior) ");
		   	    }else if(where != -1 && order != -1 && lastIndexOf!=-1&& lastIndexOf>lastIndexOf2) {
		   	    	sql = sql.insert(order,"  and exists(select * from sys_depart_info sec  where sec.dept_code = "+dept
		   	   	    		+ " start with "
		   	   	    		+deptcode
		   	   	    	+ " = "+map.get("dept")+" connect by prior DEPT_PK = sec.dept_superior)");
		   	    }
		   	    
		   	 else if(where != -1 && order == -1 && lastIndexOf<lastIndexOf2) {
		   	  	sql = sql.append(" where  exists(select * from sys_depart_info sec  where sec.dept_code = "+dept
	   	   	    		+ " start with "
	   	   	    		+deptcode
	   	   	    		+ " = "+map.get("dept")+" connect by prior DEPT_PK = sec.dept_superior)");
		   	    }
		   	    
		   	 else if(where != -1 && order == -1 && lastIndexOf>lastIndexOf2) {
			   	  	sql = sql.append(" and exists(select * from sys_depart_info sec  where sec.dept_code = "+dept
		   	   	    		+ " start with "
		   	   	    		+deptcode
		   	   	    		+ " = "+map.get("dept")+" connect by prior DEPT_PK = sec.dept_superior)");
			   	    }
		   	    //
		   	 else if(where != -1 && order != -1 && lastIndexOf<lastIndexOf2) {
		   		sql = sql.insert(order," where exists(select * from sys_depart_info sec  where sec.dept_code = "+dept
	   	   	    		+ " start with "
	   	   	    		+deptcode
	   	   	    	+ " = "+map.get("dept")+" connect by prior DEPT_PK = sec.dept_superior)");
			   	    }
		   	    
		   	 else if(where != -1 && order != -1 && lastIndexOf>lastIndexOf2) {
		   		sql = sql.insert(order," and exists(select * from sys_depart_info sec  where sec.dept_code = "+dept
	   	   	    		+ " start with "
	   	   	    		+deptcode
	   	   	    	+ " = "+map.get("dept")+" connect by prior DEPT_PK = sec.dept_superior)");
			   	    }
		   	    System.out.println(sql);
						// 包装sql后，重置到invocation中
						resetSql2Invocation(invocation, sql.toString());

						// 返回，继续执行
						return invocation.proceed();

					} else {
						resetSql2Invocation(invocation, sql1.toString());
						return invocation.proceed();
					}
					}
					
					
			}
			

			
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object obj) {
		return Plugin.wrap(obj, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		// doSomething
	}

	/**
	 * 获取sql语句
	 * 
	 * @param invocation
	 * @return
	 */
	private String getSqlByInvocation(Invocation invocation) {
		final Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement) args[0];
		Object parameterObject = args[1];
		BoundSql boundSql = ms.getBoundSql(parameterObject);
		ms.getSqlSource();
		return boundSql.getSql();
	}

	/**
	 * 包装sql后，重置到invocation中
	 * 
	 * @param invocation
	 * @param sql
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	private void resetSql2Invocation(Invocation invocation, String sql) throws SQLException, IllegalArgumentException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		final Object[] args = invocation.getArgs();
		MappedStatement statement = (MappedStatement) args[0];
		Object parameterObject = args[1];
		BoundSql boundSql = statement.getBoundSql(parameterObject);
		MappedStatement newStatement = new MappedStatement.Builder(statement.getConfiguration(), statement.getId(),
//		 sq	 或 new StaticSqlSource(statement.getConfiguration(),sql,boundSql.getParameterMappings())
				//静态的StaticSqlSource 拼接的sql的参数不能以#{}进行动态参数设置 若要动态设置参数需要使用DynamicSqlSource 利用反射修改sqlNode节点
				new StaticSqlSource(statement.getConfiguration(),sql,boundSql.getParameterMappings()), statement.getSqlCommandType()).resultMaps(statement.getResultMaps()).build();
		args[0] = newStatement;
	}
}