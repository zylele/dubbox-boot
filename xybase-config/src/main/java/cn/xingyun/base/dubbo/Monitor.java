package cn.xingyun.base.dubbo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Monitor {
	/**
	 * 消费的服务
	 * @return
	 */
	String serviceName() default "";
	
	/**
	 * 服务描述
	 * @return
	 */
	String desc() default "";
}
