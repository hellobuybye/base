// package com.cyh.base.config;

// import com.cyh.base.intercepter.ControllerInterceptor;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.CacheControl;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
// import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// import java.util.concurrent.TimeUnit;

// @Configuration
// public class WebConfig implements WebMvcConfigurer {
// //    @Bean
// //    MappingJackson2JsonView jsonView() {
// //        return new MappingJackson2JsonView();
// //    }

//     @Override
//     public void addResourceHandlers(ResourceHandlerRegistry registry) {
//         registry.addResourceHandler("/**")

//                 .addResourceLocations("classpath:/static/")
//                 .addResourceLocations("classpath:/templates/")
//                 .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
//     }

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
// //        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
//         registry.addMapping("/**").allowedOrigins("*");
//     }

//     @Override
//     public void addInterceptors(InterceptorRegistry registry) {
// //        registry.addInterceptor(new ControllerInterceptor()).excludePathPatterns("/static/**", "/favicon.ico");
//     }


// }