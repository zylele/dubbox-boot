import java.util.List;
import java.util.Map;

import cn.zylele.base.user.service.UserQueryService;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;


public class LocalConsumerTest {

	public static void main(String[] args) throws Exception {
		testConfirgService();
//		testInitRegisterData();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T getService(Class<T> type) {
		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("LocalConsumerTest");

		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("zookeeper://127.0.0.1:2181");
		
		// 引用远程服务
		ReferenceConfig reference = new ReferenceConfig(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
		reference.setApplication(application);
		reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
		reference.setInterface(type);
		
		return (T)reference.get();
	}
	
	public static void testConfirgService() {
		// 和本地bean一样使用xxxService
		// 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
		UserQueryService service = (UserQueryService)getService(UserQueryService.class); 

//		for(int i = 0; i<1000; i++) {
//			 service.createMobileRegisterSendVC("");
//		}
		
		List<Map<String, Object>> list = service.getUser(1);
		
		System.out.println("--------------"+list);

		
	}
	
//	public static void testInitRegisterData() {
//		// 和本地bean一样使用xxxService
//		// 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
//		UserSecurityService service = (UserSecurityService)getService(UserSecurityService.class); 
//		
//		try {
//			service.registerUserMobile("22557444400",null,null,null);
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}