package org.lab.rm.engine.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/random").setViewName("random");
		registry.addViewController("/combat").setViewName("combat");
		registry.addViewController("/movement").setViewName("movement");
		registry.addViewController("/error").setViewName("error");
	}

}