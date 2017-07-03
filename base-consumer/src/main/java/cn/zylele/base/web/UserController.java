package cn.zylele.base.web;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.zylele.base.user.model.User;
import cn.zylele.base.user.service.UserQueryService;
import cn.zylele.base.user.service.UserUpdateService;

@RestController
public class UserController {

	@Reference
	UserQueryService userQueryService;
	
	@Reference
	UserUpdateService userUpdateService;
	
	@RequestMapping(value="/user/get/{userid}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Map<String, Object>> getUser(@PathVariable("userid") Integer userid){
		return userQueryService.getUser(userid);
	}
	
	@RequestMapping(value="/user/update/{userid}/{nickname}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insert(@PathVariable("userid") String userid, @PathVariable("nickname") String nickname){
		int count = userUpdateService.updateNickname(nickname, userid);
		if(count == 1){
			return "success";
		}else{
			return "failed";
		}
	}
}
