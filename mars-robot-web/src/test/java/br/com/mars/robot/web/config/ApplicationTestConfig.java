package br.com.mars.robot.web.config;

import br.com.mars.robot.web.Application;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Application.class)
public class ApplicationTestConfig {
}
