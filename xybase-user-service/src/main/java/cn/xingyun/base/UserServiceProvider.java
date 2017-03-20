package cn.xingyun.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

@SpringBootApplication
public class UserServiceProvider implements EmbeddedServletContainerCustomizer{
    public static void main(String[] args) {
        SpringApplication.run(UserServiceProvider.class, args);
    }

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(1001);
	}
}