package cn.xingyun.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = "classpath:dubbo-config.xml")
@SpringBootApplication
public class XybaseConsumer implements EmbeddedServletContainerCustomizer{
    public static void main(String[] args) {
        SpringApplication.run(XybaseConsumer.class, args);
    }

	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(1000);
	}
}