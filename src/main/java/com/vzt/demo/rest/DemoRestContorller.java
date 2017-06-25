package com.vzt.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vzt.demo.service.DemoService;

@RestController
public class DemoRestContorller {
	@Autowired
	DemoService demoService;
	
	@RequestMapping(value="/rest/demo", method=RequestMethod.GET)
	public Long demoHello(){
		return demoService.getAccountId();
	}
	
	@RequestMapping(value="/rest/demo/post", method=RequestMethod.POST)
	public String echo(@RequestBody String message){
		System.out.println(demoService);
		return message + " This is a Post Call";
	}
}
