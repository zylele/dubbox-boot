package cn.zylele.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = "classpath:*.xml")
@SpringBootApplication
public class UserServiceProvider implements EmbeddedServletContainerCustomizer{
	private static int port = 8081;
	
	public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(UserServiceProvider.class, args);
    }

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(port);
	}
}