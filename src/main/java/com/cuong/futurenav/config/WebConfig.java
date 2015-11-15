package com.cuong.futurenav.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableWebMvc /* Enables default SpringMVC configuration */
@ComponentScan(basePackages = {"com.cuong.futurenav.controller"}) /* packages to scan for spring beans (marked with @Controller, @Service, @Component) */
@Configuration /* marks this class as a source of @bean definitions */
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> originalMediaTypes = jsonConverter.getSupportedMediaTypes();
        List<MediaType> newJsonMediaTypes = new ArrayList<>();
        for (MediaType originalMediaType : originalMediaTypes) {
            newJsonMediaTypes.add(originalMediaType);
        }

        newJsonMediaTypes.add(new MediaType("text", "plain"));
        jsonConverter.setSupportedMediaTypes(newJsonMediaTypes);
        converters.add(jsonConverter);
    }
}
