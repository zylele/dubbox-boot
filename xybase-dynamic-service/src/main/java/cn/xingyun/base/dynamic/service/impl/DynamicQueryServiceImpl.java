package cn.xingyun.base.dynamic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import cn.xingyun.base.dynamic.mapper.DynamicMapper;
import cn.xingyun.base.dynamic.model.Dynamic;
import cn.xingyun.base.dynamic.service.DynamicQueryService;

@Component
@Service
public class DynamicQueryServiceImpl implements DynamicQueryService{

	@Autowired
	DynamicMapper dynamicMapper;
	
	@Override
	public Dynamic getDynamic(Integer id) {
		return dynamicMapper.getDynamic(id);
	}

	@Override
	public String insert(String s) {
		return s;
	}

}
