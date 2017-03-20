package cn.xingyun.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.Exporter;

import cn.xingyun.base.conf.DubboConfiguration;

@Configuration
@ConditionalOnClass(Exporter.class)
@PropertySource(value = "classpath:/dubbo.properties")
public class DubboProviderConfiguration extends DubboConfiguration{

    @Value("${dubbo.protocol.name}")
    private String protocolName;

    @Value("${dubbo.protocol.port}")
    private int protocolPort;

    @Value("${dubbo.provider.timeout}")
    private int timeout;

	@Value("${dubbo.provider.retries}")
    private int retries;

	@Value("${dubbo.provider.delay}")
    private int delay;
	
    /**
     * 默认基于dubbo协议提供服务
     * 
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        // 服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(protocolName);
        protocolConfig.setPort(protocolPort);
        protocolConfig.setThreads(200);
        return protocolConfig;
    }
    
    /**
     * dubbo服务提供
     * 
     * @param applicationConfig
     * @param registryConfig
     * @param protocolConfig
     * @return
     */
	@Bean
	public ProviderConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig, ProtocolConfig protocolConfig, MonitorConfig monitorConfig) {
	    ProviderConfig providerConfig = new ProviderConfig();
	    providerConfig.setTimeout(timeout);
	    providerConfig.setRetries(retries);
	    providerConfig.setDelay(delay);
	    providerConfig.setApplication(applicationConfig);
	    providerConfig.setRegistry(registryConfig);
	    providerConfig.setProtocol(protocolConfig);
	    providerConfig.setMonitor(monitorConfig);
	    return providerConfig;
	}
}
