package com.wish.action;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Spring Boot应用启动类
 *
 * Created by fqh on 17/6/24.
 */
@MapperScan(basePackages = "com.wish.action.dao")
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    /**
     * 无 applicationContext.xml 和 web.xml, 靠下述方式进行配置：
     * <p>
     * 1. 扫描当前package下的class设置自动注入的Bean<br/>
     * 2. 也支持用@Bean标注的类配置Bean <br/>
     * 3. 根据classpath中的三方包Class及集中的application.properties条件配置三方包，如线程池 <br/>
     * 4. 也支持用@Configuration标注的类配置三方包.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}