package com.trippify.trippify.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trippify.trippify.common.model.ConfigResponseBean;
import com.trippify.trippify.common.model.StatusResponse;
import com.trippify.trippify.common.model.UserVO;
import com.trippify.trippify.common.model.request.CreateUserRest;
import com.trippify.trippify.common.service.UserService;

@CrossOrigin(origins = "http://localhost:4401", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/retrieveUsers")
	public ConfigResponseBean retrieveRegUsers() {
		ConfigResponseBean configResponseBean = new ConfigResponseBean();
		List<UserVO> userVOList = this.userService.retrieveRegUsers();
		configResponseBean.setRegUsersList(userVOList);
		return configResponseBean;
	}

	@PostMapping(value = "/createUser")
	public StatusResponse createUser(@RequestBody CreateUserRest userInput) {
		return userService.createUser(userInput);
	}

}
