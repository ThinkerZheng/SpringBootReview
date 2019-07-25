package org.sbr.ServiceConsumer1.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.sbr.ServiceConsumer1.api.UserService;
import org.sbr.ServiceConsumer1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
		@GetMapping()
		public List<User> list(){
			return userService.list();
		}
		
		@GetMapping(value="/{userId}")
		public User GetUser(@PathVariable String userId) {
			return userService.getUser(userId);
		}

		
	

}
