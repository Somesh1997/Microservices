package com.user.user_service.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.user.user_service.entity.User̥;

@Service
public class UserServiceImpl implements UserService {

	List<User̥> list = List.of(new User̥(1311L, "somesh gangwar", "27e372e467"),
			new User̥(1321L, "Rajesh", "27372e47"));

	public User̥ getUser(Long id) {
		User̥ user=list.stream().filter(i -> i.getUserId().equals(id)).findAny().orElse(null);
        System.out.println(user);
        return user;
		// return null;
	}
}
