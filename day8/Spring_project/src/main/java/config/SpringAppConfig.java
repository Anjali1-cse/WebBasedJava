package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"first","second", "config"})
public class SpringAppConfig {
      // bean declarations using @Bean if any(java based configuration)
	
}
