package cn.xingyun.base.dubbo;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DubboMonitor {  
	@AfterThrowing(throwing="ex", pointcut = "execution(* cn.xingyun.base.web.*.*(..))")  
	public void aroundMethod(Throwable ex) {
		if(ex instanceof com.alibaba.dubbo.rpc.RpcException){
//			#TODO
//			SendEmailBean bean = new SendEmailBean("xxxxxxxx@qq.com", "服务异常", ex.toString(), null);
//			CMSMailUtils.sendMail(bean);
		}
    }
}
