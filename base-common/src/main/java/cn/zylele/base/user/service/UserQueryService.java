package cn.zylele.base.user.service;

import java.util.List;
import java.util.Map;

import cn.zylele.base.user.model.User;

public interface UserQueryService {
	
	List<Map<String, Object>> getUser(Integer userid);
	
}
