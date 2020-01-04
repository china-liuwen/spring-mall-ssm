package config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author LW
 */
@Configuration      //声明该类是一个配置文件类
@ComponentScan({"com.service"})//扫描当前包下的注解,进行spring管理
@MapperScan("com.dao")  //扫描当前包下的Mapper,目的是获得dao的实现类
@PropertySource("classpath:db.properties")  //扫描外部资源
@EnableTransactionManagement    //配置事务,然后在需要添加事务的地方添加@Transactional注解即可
@EnableWebMvc   //开启mvc的功能,等价于在xml配置mvc:annotation-driven

public class AppConfig {

    @Value("${jdbc.url}")
    private String URL;
    @Value("${jdbc.username}")
    private String USERNAME;
    @Value("${jdbc.password}")
    private String PASSWORD;


    //数据源

    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(URL);
        druidDataSource.setUsername(USERNAME);
        druidDataSource.setPassword(PASSWORD);
        return druidDataSource;
    }


    //配置视图解析器 设置前缀与后缀

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/WEB-INF/views/");
        return viewResolver;
    }

    // 配置日志
    private org.apache.ibatis.session.Configuration getConfiguration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(StdOutImpl.class);
        //开启驼峰命名法
        configuration.setMapUnderscoreToCamelCase(true);
        return configuration;
    }

    //      配置分页

    private PageInterceptor pageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        //支持方法参数
        properties.put("supportMethodsArguments", "true");
        properties.put("reasonable", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    //      会话工厂 数据源

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        //配置资源解析器
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource[] resources = resolver.getResources("classpath*:mappers/**/*Mapper.xml");
        Resource[] resources = resolver.getResources("classpath*:mappers/*Mapper.xml");

        //将Mapper注入
        sessionFactoryBean.setMapperLocations(resources);
        sessionFactoryBean.setConfiguration(getConfiguration());
        sessionFactoryBean.setPlugins(pageInterceptor());
        return sessionFactoryBean.getObject();
    }

    //  配置事务管理器

    @Bean
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }
}
















































