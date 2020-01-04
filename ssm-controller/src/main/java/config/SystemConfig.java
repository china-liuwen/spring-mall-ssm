package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SystemConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 当你的项目只有一个spring 容器,那么只需要下面方法返回有值即可
     *
     * 如果有2个容器,那么这2个配置类的方法都需要返回配置类
     *
     * getRootConfigClasses 父类容器
     * getServletConfigClasses 子类容器
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    //映射  所有请求都接收

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
