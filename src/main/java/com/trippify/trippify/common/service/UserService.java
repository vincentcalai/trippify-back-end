package com.trippify.trippify.common.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trippify.trippify.common.dao.IUserDao;
import com.trippify.trippify.common.model.StatusResponse;
import com.trippify.trippify.common.model.UserVO;
import com.trippify.trippify.common.model.request.CreateUserRest;
import com.trippify.trippify.common.view.UserView;

@Transactional
@Service
public class UserService {

	@Autowired
	private IUserDao userDao;

	public List<UserVO> retrieveRegUsers() {
		List<UserView> userView = this.userDao.findAllByDelInd("N");
		if (userView != null && userView.size() > 0) {
			List<UserVO> userVOList = new ArrayList<>();
			userView.forEach(user -> {
				UserVO userVO = new UserVO();
				userVO.setId(user.getId());
				userVO.setUsername(user.getUsername());
				userVO.setEmail(user.getEmail());
				userVO.setContactNo(user.getContactNo());
				userVOList.add(userVO);
			});
			return userVOList;
		}
		return null;
	}

	public StatusResponse createUser(CreateUserRest userInput) {
		StatusResponse response = new StatusResponse();
		UserView user = null;
		if (isUsernameUnique(userInput.getUser().getUsername())) {
			UserVO userInputVO = userInput.getUser();
			user = new UserView();
			user.setUsername(userInputVO.getUsername());
			user.setPassword(userInputVO.getPassword());
			user.setEmail(userInputVO.getEmail());
			user.setContactNo(userInputVO.getContactNo());
			user.setDelInd("N");
			user.setCreatedBy(null);
			user.setCreatedDt(new Date());
		} else {
			response.setStatusCode(2);
			response.setResultMessage("Username already existed. Please use another username");
			return response;
		}

		this.userDao.save(user);
		response.setResultMessage("User was created successfully.");

		return response;
	}

	public boolean isUsernameUnique(String username) {
		UserView user = userDao.findByUsername(username);
		return (user == null);
	}
}
