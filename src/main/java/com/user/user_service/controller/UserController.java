package com.user.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.user_service.entity.User̥;
import com.user.user_service.service.UserService;
import com.user.user_service.entity.*;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	@ResponseBody
	public User̥ getUser(@PathVariable Long userId) {
		System.out.println(userId);
		User̥ user = userservice.getUser(userId);
		System.out.println("localhost:9002/contact/user/" + user.getUserId());
		List list = this.restTemplate.getForObject("http://localhost:9002/contact/user/" + user.getUserId(), List.class);
		user.setContacts(list);
		return user;
	}
}
