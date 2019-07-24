package org.sbr.ServiceConsumer1.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return restTemplate.getForEntity("http://RPOVIDER-SERVICE1-HELLO/hello", String.class).getBody();
	}
	
	@GetMapping(value = "/hello1")
	public String hell01() {
		ServiceInstance instance = this.loadBalancerClient.choose("RPOVIDER-SERVICE1-HELLO");
		URI helloUri = URI.create(String.format("http://%s:%s/hello", instance.getHost(),instance.getPort()));
		logger.info("Target service Uri = {}", helloUri.toString());
		return new RestTemplate().getForEntity(helloUri, String.class).getBody();
	}
}
