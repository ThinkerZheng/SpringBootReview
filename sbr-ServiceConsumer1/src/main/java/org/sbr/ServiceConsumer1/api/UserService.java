package org.sbr.ServiceConsumer1.api;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.sbr.ServiceConsumer1.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient("RPOVIDER-SERVICE1-HELLO")
@FeignClient(name = "povider-service-hello")
@RequestMapping(value="/users",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
public interface UserService {
	@GetMapping()
	public List<User> list();
	
	@GetMapping(value="/{userId}")
	public User getUser(@PathVariable String userId);	
}
