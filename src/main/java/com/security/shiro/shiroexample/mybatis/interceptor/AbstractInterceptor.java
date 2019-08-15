/*
package com.zfb.platform.service.base.datasource.mybatis.interceptor;

import com.sun.deploy.util.StringUtils;
 import org.apache.ibatis.mapping.*;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.plugin.Interceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

*/
/**
 * Mybatis拦截器基类
 * Created by yoara on 2015/12/21.
 *//*

public abstract class AbstractInterceptor implements Interceptor {
	protected MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource, boolean isCount) {
		Builder builder = new Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		if(ms.getKeyProperties()!=null){
			builder.keyProperty(StringUtils.join(Arrays.asList(ms.getKeyProperties()),","));
		}
		builder.timeout(ms.getTimeout());
		builder.parameterMap(ms.getParameterMap());
		if(isCount) {
			List<ResultMap> resultMaps = new ArrayList<ResultMap>();
			resultMaps.add(new ResultMap.Builder(ms.getConfiguration(), ms.getId(), Integer.class, new ArrayList<ResultMapping>()).build());
			builder.resultMaps(resultMaps);
		} else {
			builder.resultMaps(ms.getResultMaps());
		}
		builder.cache(ms.getCache());
		MappedStatement newMs = builder.build();
		return newMs;
	}

	public static class BoundSqlSqlSource implements SqlSource {
		BoundSql boundSql;

		public BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}

		public BoundSql getBoundSql(Object parameterObject) {
			return boundSql;
		}
	}
}
*/
