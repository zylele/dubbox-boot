package cn.zylele.base.dynamic.service;

import cn.zylele.base.dynamic.model.Dynamic;

public interface DynamicQueryService {
	
	Dynamic getDynamic(Integer id);
	
	String insert(String s);
}
