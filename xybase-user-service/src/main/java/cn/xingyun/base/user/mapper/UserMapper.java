package cn.xingyun.base.user.mapper;

import cn.xingyun.base.user.model.User;

public interface UserMapper {
	/**
	 * 读取用户基本信息
	 * @param userid
	 * @return
	 */
	User getUser(String userid);
}