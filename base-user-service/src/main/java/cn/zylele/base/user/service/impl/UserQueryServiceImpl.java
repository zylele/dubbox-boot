package cn.zylele.base.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import cn.zylele.base.user.mapper.UserMapper;
import cn.zylele.base.user.model.User;
import cn.zylele.base.user.service.UserQueryService;

@Component
@Service
public class UserQueryServiceImpl implements UserQueryService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<Map<String, Object>> getUser(Integer userid) {
		return userMapper.getUser(userid);
	}

}
