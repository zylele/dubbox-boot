package cn.zylele.base.dynamic.mapper;

import cn.zylele.base.dynamic.model.Dynamic;

public interface DynamicMapper {
	/**
	 * 读取动态基本信息
	 * @param dynamicid
	 * @return
	 */
	Dynamic getDynamic(Integer id);
}