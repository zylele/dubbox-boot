package cn.zylele.base.user.mapper;

import org.apache.ibatis.annotations.Param;

import cn.zylele.base.user.model.User;

public interface UserMapper {
	/**
	 * 读取用户基本信息
	 * @param userid
	 * @return
	 */
	User getUser(String userid);
	
	/**
	 * 修改昵称
	 * @param nickname
	 * @param userid
	 * @return
	 */
	int updateNickname(@Param("nickname")String nickname, @Param("userid")String userid);
}