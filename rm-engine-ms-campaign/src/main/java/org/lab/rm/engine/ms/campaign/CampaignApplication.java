package org.lab.rm.engine.ms.campaign;

import org.lab.rm.engine.core.config.RmEngineCoreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@Import(RmEngineCoreConfig.class)
public class CampaignApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampaignApplication.class, args);
	}

}
