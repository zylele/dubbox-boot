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

//@Configuration
//@ConditionalOnClass(Exporter.class)
//@PropertySource(value = "classpath:/dubbo.properties")
public class DubboProviderConfiguration extends DubboConfiguration{

}
