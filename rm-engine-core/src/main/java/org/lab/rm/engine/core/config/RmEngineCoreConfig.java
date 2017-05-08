package org.lab.rm.engine.core.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "org.lab.rm.engine.core.model")
@ComponentScan(basePackages = "org.lab.rm.engine.core")
public class RmEngineCoreConfig {

}
