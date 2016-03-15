package com.jasondyjohnson.config;

import com.jasondyjohnson.formatter.PersonFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Jason on 3/5/2016.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Autowired
    private PersonFormatter personFormatter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(personFormatter);
    }
}
