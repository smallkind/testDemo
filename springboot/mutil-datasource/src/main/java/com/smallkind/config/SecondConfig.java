package com.smallkind.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author xiang.zhou
 * @create 2017-05-20-10:57
 */
@Configuration
@MapperScan(basePackages = SecondConfig.PACKAGE, sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondConfig {

    public static final String PACKAGE = "com.smallkind.secondDao";

    public static final String MAPPER_LOCATION = "classpath:mapper/second/*.xml";

    @Bean(name = "secondDataSource")
    @Qualifier("secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager secondTransactionManager(@Qualifier("secondDataSource") DataSource secondDataSource) {
        return new DataSourceTransactionManager(secondDataSource);
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secondDataSource") DataSource secondDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(secondDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SecondConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}
