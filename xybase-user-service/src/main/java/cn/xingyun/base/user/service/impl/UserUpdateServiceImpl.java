package cn.xingyun.base.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import cn.xingyun.base.user.mapper.UserMapper;
import cn.xingyun.base.user.service.UserUpdateService;

@Component
@Service
public class UserUpdateServiceImpl implements UserUpdateService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public int updateNickname(String nickname, String userid) {
		return userMapper.updateNickname(nickname, userid);
	}
	
}
