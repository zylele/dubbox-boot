package cn.xingyun.base.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;

import cn.xingyun.base.dynamic.service.DynamicQueryService;
import cn.xingyun.base.user.mapper.UserMapper;
import cn.xingyun.base.user.model.User;
import cn.xingyun.base.user.service.UserQueryService;

@Component
@Service
public class UserQueryServiceImpl implements UserQueryService{

	@Reference(check = false)
	DynamicQueryService dynamicQueryService;
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public User getUser(String userid) {
		return userMapper.getUser(userid);
	}

}
