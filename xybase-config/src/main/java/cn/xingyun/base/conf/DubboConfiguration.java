package cn.xingyun.base.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = "classpath:dubbo-config.xml")
public class DubboConfiguration {

}
