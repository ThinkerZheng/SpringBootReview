package org.sbr.ServiceProvider1.controller;

import java.util.Arrays;
import java.util.List;

import org.sbr.ServiceProvider1.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users",method = RequestMethod.GET, produces="application/json;charset=UTF-8")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private List<User>  userList = Arrays.asList(
			new User().setName("Guangbin").setEmail("guangbin@foxmail.com").setId(1),
			new User().setName("Robin").setEmail("Robin@foxmail.com").setId(2),
			new User().setName("God").setEmail("God@foxmail.com").setId(3)
			);
	
	@GetMapping()
	public List<User> list(){
		logger.info("Api List() is being invoking");
		return userList;
	}
	
	@GetMapping(value="/{userId}")
	public User GetUser(@PathVariable String userId) {
		logger.info("Api GetUser() is being invoking");
		for(User user:userList) {
			if(Integer.valueOf(user.getId()).equals(Integer.parseInt(userId.trim()))) {
				return user;
			}
		}
		return null;
	}
}
