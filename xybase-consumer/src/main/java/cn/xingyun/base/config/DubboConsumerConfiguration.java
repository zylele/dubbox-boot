package cn.xingyun.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.Exporter;

import cn.xingyun.base.conf.DubboConfiguration;

@Configuration
@ConditionalOnClass(Exporter.class)
@PropertySource(value = "classpath:/dubbo.properties")
public class DubboConsumerConfiguration extends DubboConfiguration{

    @Value("${dubbo.consumer.check}")
    private Boolean consumerCheck;

    /**
     * 消费者配置
     * @param applicationConfig
     * @param registryConfig
     * @param monitorConfig
     * @return
     */
    @Bean
    public ConsumerConfig consumerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig, MonitorConfig monitorConfig) {
    	ConsumerConfig consumerConfig = new ConsumerConfig();
    	consumerConfig.setApplication(applicationConfig);
    	consumerConfig.setRegistry(registryConfig);
    	consumerConfig.setMonitor(monitorConfig);
    	consumerConfig.setCheck(consumerCheck);
        return consumerConfig;
    }
    
}
