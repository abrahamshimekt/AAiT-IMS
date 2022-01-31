package com.codewithabe.AAiT.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        exposeDirectory("../images",registry);
//        exposeDirectory("../css",registry);
//        exposeDirectory("../js",registry);
//
//
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/addmindashboard").setViewName("admindashboard");
        registry.addViewController("/userdashboard").setViewName("userdashboard");

    }
//    private void exposeDirectory(String pathPattern, ResourceHandlerRegistry registery){
//        Path path = Paths.get(pathPattern);
//        String absolutePath = path.toFile().getAbsolutePath();
//        String logicalPath = pathPattern.replace("../","") +"/**";
//        registery.addResourceLocations(logicalPath)
//                .addResourceLocations("file:/" + absolutePath +"/");
//    }
}
