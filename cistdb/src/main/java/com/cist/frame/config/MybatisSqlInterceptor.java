package com.cist.frame.config;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/***
 * 
 * @Title:MybatisSqlInterceptor.java
 * @Package:com.cist.frame.config
 * @Description:
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
					if(null == map.get(dept) || "".equals(map.get(dept))||(map.get(dept) instanceof List&&((ArrayList)map.get(dept)).size()==0)) {
						
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
		   	 
		   	 
//		   	 获取当前用户，获取部门
		   	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                            HttpSession session = request.getSession();
            				Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
            				//当前用户的部门信息
            				String sypi_dept_code = userMap.get("sypi_dept_code")==null?null:userMap.get("sypi_dept_code").toString();
            				String newsql = "select * from("+sql+") "
            			   			 +"where exists(select * from ("
            				   	    			+ "select "
            				   	    			+ deptcode
            				   	    			+ " dept_yt from sys_depart_info sec"  
            				   	   	    		+ " start with "
            				   	   	    		+"DEPT_CODE"
            				   	   	    		+ " = '"+sypi_dept_code+"' connect by prior DEPT_PK = sec.dept_superior) "+"where dept_yt = "+dept+")";
		   	    System.out.println(newsql);
		   	    //拼接在原sql最前面的sql
		   	 String beforeSql = "select * from(";
		   	 //拼接在原sql最后面的sql
		   	    String afterSql = ") "
			   			 +"where exists(select * from ("
		   	    			+ "select "
		   	    			+ deptcode
		   	    			+ " dept_yt from sys_depart_info sec"  
		   	   	    		+ " start with "
		   	   	    		+"DEPT_CODE"
		   	   	    		+ " = '"+sypi_dept_code+"' connect by prior DEPT_PK = sec.dept_superior) "+"where dept_yt = "+dept+")";
						// 包装sql后，重置到invocation中
						resetSql2Invocation(invocation,newsql,beforeSql,afterSql);

						// 返回，继续执行
						return invocation.proceed();

					} else {
						resetSql2Invocation1(invocation, sql1.toString());
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
	private void resetSql2Invocation(Invocation invocation, String sql, String beforeSql, String afterSql) throws SQLException, IllegalArgumentException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		final Object[] args = invocation.getArgs();
		final MappedStatement statement = (MappedStatement) args[0];
		final SqlSource sq = statement.getSqlSource();
		Object parameterObject = args[1];
		BoundSql boundSql =sq.getBoundSql(parameterObject);
    	// 重新new一个查询语句对像
         BoundSql newBoundSql = new BoundSql(statement.getConfiguration(), sql, boundSql.getParameterMappings(), boundSql.getParameterObject());
         //由于foreach参数报无效列类型 使用反射将解析后的参数设置到parameterObject
         Field field = newBoundSql.getClass().getDeclaredField("parameterObject");
         field.setAccessible(true);
          HashMap<String,Object> sqln = (HashMap<String,Object>) field.get(newBoundSql);
         for (ParameterMapping mapping : boundSql.getParameterMappings()) {
             String prop = mapping.getProperty();
             if (boundSql.hasAdditionalParameter(prop)) {
                 newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
                 //将解析后的参数put到map
                 sqln.put(prop, boundSql.getAdditionalParameter(prop));
             }
         }
         //利用反射设置值
         field.set(newBoundSql, sqln);
         //利用反射修改newBoundSql的metaParameters 不设置该参数会为空
         Field metaParamsField = ReflectUtil.getFieldByFieldName(boundSql, "metaParameters");
         if (metaParamsField != null) {
        	 //获取boundSql metaParameters信息
        	 MetaObject mo = (MetaObject) ReflectUtil.getValueByFieldName(boundSql, "metaParameters");
        	 //利用反射将boundSql的metaParameters设置到newBoundSql
             ReflectUtil.setValueByFieldName(newBoundSql, "metaParameters", mo);
         }
        SqlSource stsout = new StaticSqlSource(statement.getConfiguration(), sql, newBoundSql.getParameterMappings())
        {
			
			@Override
			public BoundSql getBoundSql(Object parameterObject) {
				return  new BoundSql(statement.getConfiguration(), sql, newBoundSql.getParameterMappings(), parameterObject);
			}
		};
    	//将修改后的sql重置到MappedStatement解析
      MappedStatement newMs = copyFromMappedStatement(statement, stsout);
        args[0] = newMs;
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
	private void resetSql2Invocation1(Invocation invocation, String sql) throws SQLException, IllegalArgumentException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		final Object[] args = invocation.getArgs();
		MappedStatement statement = (MappedStatement) args[0];
		Object parameterObject = args[1];
		BoundSql boundSql = statement.getBoundSql(parameterObject);
		MappedStatement newStatement = new MappedStatement.Builder(statement.getConfiguration(), statement.getId(),
//		 sq	 或 new StaticSqlSource(statement.getConfiguration(),sql,boundSql.getParameterMappings())
				//静态的StaticSqlSource 拼接的sql的参数不能以#{}进行动态参数设置 若要动态设置参数需要使用DynamicSqlSource 利用反射修改sqlNode节点
				statement.getSqlSource(), statement.getSqlCommandType()).resultMaps(statement.getResultMaps()).build();
		args[0] = newStatement;
	}
	 private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
	        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
	        builder.resource(ms.getResource());
	        builder.fetchSize(ms.getFetchSize());
	        builder.statementType(ms.getStatementType());
	        builder.keyGenerator(ms.getKeyGenerator());
	        if (ms.getKeyProperties() != null && ms.getKeyProperties().length > 0) {
	            builder.keyProperty(ms.getKeyProperties()[0]);
	        }
	        builder.timeout(ms.getTimeout());
	        builder.parameterMap(ms.getParameterMap());
	        builder.resultMaps(ms.getResultMaps());
	        builder.resultSetType(ms.getResultSetType());
	        builder.cache(ms.getCache());
//	        builder.flushCacheRequired(ms.isFlushCacheRequired());
	        builder.flushCacheRequired(true);
	        builder.useCache(false);
//	        builder.useCache(ms.isUseCache());
	        return builder.build();
//	        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(),ms.getId(),newSqlSource,ms.getSqlCommandType());
//	        
//	        builder.resource(ms.getResource());
//	        builder.fetchSize(ms.getFetchSize());
//	        builder.statementType(ms.getStatementType());
//	        builder.keyGenerator(ms.getKeyGenerator());
//	        if(ms.getKeyProperties() != null && ms.getKeyProperties().length !=0){
//	            StringBuffer keyProperties = new StringBuffer();
//	            for(String keyProperty : ms.getKeyProperties()){
//	                keyProperties.append(keyProperty).append(",");
//	            }
//	            keyProperties.delete(keyProperties.length()-1, keyProperties.length());
//	            builder.keyProperty(keyProperties.toString());
//	        }
//	 
//	        //setStatementTimeout()
//	        builder.timeout(ms.getTimeout());
//	 
//	        //setStatementResultMap()
//	        builder.parameterMap(ms.getParameterMap());
//	 
//	        //setStatementResultMap()
//	        builder.resultMaps(ms.getResultMaps());
//	        builder.resultSetType(ms.getResultSetType());
//	 
//	        //setStatementCache()
//	        builder.cache(ms.getCache());
//	        builder.flushCacheRequired(ms.isFlushCacheRequired());
//	        builder.useCache(ms.isUseCache());
//	 
//	        return builder.build();

	    }
	
}