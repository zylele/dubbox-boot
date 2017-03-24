package cn.xingyun.base.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.rpc.Exporter;

@Configuration
@ImportResource(value = "classpath:dubbo-config.xml")
@ConditionalOnClass(Exporter.class)
@PropertySource(value = "classpath:/dubbo.properties")
public class DubboConfiguration {

    @Value("${dubbo.application.name}")
    private String applicationName;
    
    @Value("${dubbo.registry.address}")
    private String registryAddress;
    
	@Value("${dubbo.monitor.protocol}")
    private String monitorProtocol;
	
    /**
     * 设置dubbo扫描包
     * @param packageName
     * @return
     */
    @Bean
    public static AnnotationBean annotationBean(@Value("${dubbo.annotation.package}") String packageName) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(packageName);
        return annotationBean;
    }

    /**
     * 注入dubbo上下文
     * 
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        // 当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applicationName);
        return applicationConfig;
    }

    /**
     * 注入dubbo注册中心配置,基于zookeeper
     * 
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress(registryAddress);
        registry.setFile("c:/dubbo/" + applicationName + ".cache");
        return registry;
    }

    /**
     * 监控中心配置
     * @return
     */
    @Bean
    public MonitorConfig monitorConfig() {
    	MonitorConfig monitor = new MonitorConfig();
    	monitor.setProtocol(monitorProtocol);
        return monitor;
    }
}
