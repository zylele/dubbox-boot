package cn.zylele.base.memcached;

import java.io.IOException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.TextCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.transcoders.SerializingTranscoder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class MemcacheConfiguration {
	Logger logger = Logger.getLogger(getClass());
	@Value("${memcached.server.hosts}")
	String memcacheHosts;
	@Value("${memcached.server.pool.size}")
	int connectionPoolSize;

	@Bean
	public MemcachedClient memcachedClient() {
		XMemcachedClientBuilder builder = new XMemcachedClientBuilder(memcacheHosts);
		builder.setConnectionPoolSize(connectionPoolSize);
		builder.setCommandFactory(new TextCommandFactory());
		builder.setSessionLocator(new KetamaMemcachedSessionLocator());
		builder.setTranscoder(new SerializingTranscoder());
		try {
			return builder.build();
		} catch (IOException e) {
			logger.error("memcache client build error!", e);
		}
		return null;
	}
}
