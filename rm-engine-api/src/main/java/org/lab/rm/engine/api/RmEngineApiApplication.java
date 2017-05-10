package org.lab.rm.engine.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class RmEngineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RmEngineApiApplication.class, args);
	}

}
