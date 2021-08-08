package com.example.utils;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.xml.bind.PropertyException;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class}) })
public class PagePlugin implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(PagePlugin.class);

    /** 数据库方言 */
    private static String dialect = "mysql";
    /** 拦截以 Page 结尾的所有方法 */
    private static String pageSqlId;
    /** 分页对象信息对应的key值 */
    private static String pageParam;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();

        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        // 获取查询接口映射的相关信息
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        // 获取方法的全限定名, 或者通过boundSql.getParameterObject()获取
        String methodAllName = mappedStatement.getId();
        // 截取方法名
        String methodName = methodAllName.substring(methodAllName.lastIndexOf(".") + 1, methodAllName.length());
        // 获取方法的类型
        SqlCommandType sqlCmdType = mappedStatement.getSqlCommandType();
        // 如果是查询SQL并且和 pageSqlId 匹配则进行拦截, 进行统一的分页处理
        if (SqlCommandType.SELECT == sqlCmdType && methodName.matches(pageSqlId)) {
            // 获取方法的参数信息
            Map paramsMap = (Map) statementHandler.getParameterHandler().getParameterObject();
            // 如果参数中包含分页对象信息, 则进行重写SQL
            if (paramsMap.containsKey(pageParam)) {
                // 分页信息实体类
                PageInfo pageInfo = (PageInfo) paramsMap.get(pageParam);
                // 当前页码
                int currentPage = pageInfo.getCurrentPage();
                // 每页显示记录数
                int pageSize = pageInfo.getPageSize();
                // 记录偏移量
                int offset = (currentPage - 1) * pageSize;
                // 重写SQL, 加入分页逻辑
                sql = sql.trim() + " LIMIT " + offset + "," + pageSize;
                LOGGER.info("SQL Command Type【{}】, method【{}】 need paing.", sqlCmdType, methodName);
                // 将重写完的分页SQL语句覆盖掉原有的SQL语句
                metaObject.setValue("delegate.boundSql.sql", sql);
            }
        }
        LOGGER.info("mybatis intercept sqlID: {}, sql: \n{}", methodName, sql);

        // 打印 SQL 执行时间
        long startTime = System.currentTimeMillis();
        Object object = invocation.proceed();
        LOGGER.info("{} execute time: {} ms.", methodName, System.currentTimeMillis() - startTime);

        return object;
    }

    /**
     * 获取代理对象
     * */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 设置代理对象的参数
     *
     * @param properties config(sql-map-config.xml)中配置的 plugin 对应的 property
     * */
    @Override
    public void setProperties(Properties properties) {
        // 缺省时, 默认mysql
        dialect = properties.getProperty("dialect", "mysql");

        pageSqlId = properties.getProperty("pageSqlId");
        checkParam("pageSqlId", pageSqlId);

        pageParam = properties.getProperty("pageParam");
        checkParam("pageParam", pageParam);

        System.out.println("mybatis intercept dialect: " + dialect + ", pageSqlId: " + pageSqlId + ", pageParam: " + pageParam);
    }


    private void checkParam(String key, String value) {
        if (StringUtils.isEmpty(value)) {
            try {
                throw new PropertyException(key + " property is not found.");
            } catch (PropertyException e) {
                e.printStackTrace();
            }
        }
    }
}