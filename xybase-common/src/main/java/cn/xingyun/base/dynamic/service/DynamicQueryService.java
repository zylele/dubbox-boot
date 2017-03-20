package cn.xingyun.base.dynamic.service;

import cn.xingyun.base.dynamic.model.Dynamic;

public interface DynamicQueryService {
	
	Dynamic getDynamic(Integer id);
	
	String insert(String s);
}
