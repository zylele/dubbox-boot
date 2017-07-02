package cn.zylele.base.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.zylele.base.dynamic.model.Dynamic;
import cn.zylele.base.dynamic.service.DynamicQueryService;

@RestController
public class DynamicController {

	@Reference
	DynamicQueryService dynamicQueryService;
	
	@RequestMapping(value="/dynamic/get/{id}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Dynamic getDynamic(@PathVariable("id") Integer id){
		return dynamicQueryService.getDynamic(id);
	}
	
	@RequestMapping(value="/dynamic/insert/{s}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insert(@PathVariable("s") String s){
		return dynamicQueryService.insert(s);
	}
}
