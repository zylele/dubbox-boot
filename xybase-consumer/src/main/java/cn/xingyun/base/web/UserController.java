package cn.xingyun.base.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.xingyun.base.user.model.User;
import cn.xingyun.base.user.service.UserQueryService;
import cn.xingyun.base.user.service.UserUpdateService;

@RestController
public class UserController {

	@Reference
	UserQueryService userQueryService;
	
	@Reference
	UserUpdateService userUpdateService;
	
	@RequestMapping(value="/user/get/{userid}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable("userid") String userid){
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
