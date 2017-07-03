package cn.zylele.base;

import java.util.concurrent.CountDownLatch;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = "classpath:*.xml")
@SpringBootApplication
public class UserServiceProvider {
	
	@Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }
	
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = new SpringApplicationBuilder()
        .sources(UserServiceProvider.class)
        .web(false)
        .run(args);
		CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
        closeLatch.await();
    }
}