package cn.zylele.base.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.zylele.base.user.model.User;

public interface UserMapper {
	/**
	 * 读取用户基本信息
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> getUser(Integer userid);
	
	/**
	 * 修改昵称
	 * @param nickname
	 * @param userid
	 * @return
	 */
	int updateNickname(@Param("nickname")String nickname, @Param("userid")String userid);
}