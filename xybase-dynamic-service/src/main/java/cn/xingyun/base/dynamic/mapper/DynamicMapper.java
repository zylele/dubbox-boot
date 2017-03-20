package cn.xingyun.base.dynamic.mapper;

import cn.xingyun.base.dynamic.model.Dynamic;

public interface DynamicMapper {
	/**
	 * 读取动态基本信息
	 * @param dynamicid
	 * @return
	 */
	Dynamic getDynamic(Integer id);
}