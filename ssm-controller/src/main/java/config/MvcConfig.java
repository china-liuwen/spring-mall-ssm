package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
@ComponentScan("com.controller")  //扫描控制器
@EnableWebMvc   // 等价于xml的mvc:annotation-driven

public class MvcConfig implements WebMvcConfigurer {

    //配置视图解析器

    @Bean
    public InternalResourceViewResolver resourceViewResolver(){
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/views/");
        resourceViewResolver.setSuffix(".jsp");
        return resourceViewResolver;
    }

    //格式化器      	配置时间格式转换器 这个是在数据绑定的时候将字符串转换为日期格式

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    //配置信息转换器,这个是在响应回去的时候进行转换,重写这个方法会覆盖默认的

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(sdf);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
        converters.add(0,converter);
    }

    //拦截器

//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        //拦截登录
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
//        interceptorRegistration.addPathPatterns("/**");
//        List<String> exceptUrl = new ArrayList<>();
//        //以下地址放行
////        exceptUrl.add("/fe/loginView");
////        exceptUrl.add("/fe/login");
////        exceptUrl.add("/fe/exit");
//        interceptorRegistration.excludePathPatterns(exceptUrl);
//    }

    //配置静态资源

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //相当于xml中配置mapping(映射)
        ResourceHandlerRegistration registration = registry.addResourceHandler("/static/**");
        //相当于xml中配置location(地址)
        registration.addResourceLocations("classpath:/static/");
    }

}







