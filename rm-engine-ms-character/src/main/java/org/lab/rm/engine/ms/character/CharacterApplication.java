package org.lab.rm.engine.ms.character;

import org.lab.rm.engine.core.config.RmEngineCoreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@EnableEurekaClient
@Import(RmEngineCoreConfig.class)
public class CharacterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharacterApplication.class, args);
	}

}
