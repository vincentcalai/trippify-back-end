package com.trippify.trippify.common.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trippify.trippify.common.dao.IUserDao;
import com.trippify.trippify.common.model.StatusResponse;
import com.trippify.trippify.common.model.UserVO;
import com.trippify.trippify.common.model.request.CreateUserRest;
import com.trippify.trippify.common.view.UserView;
import com.trippify.trippify.util.Constants;

@Transactional
@Service
public class UserService {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<UserVO> retrieveRegUsers() {
		List<UserView> userView = this.userDao.findAllByDelInd(Constants.NO);
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
			user.setPassword(passwordEncoder.encode(userInputVO.getPassword()));
			user.setEmail(userInputVO.getEmail());
			user.setContactNo(userInputVO.getContactNo());
			user.setDelInd(Constants.NO);
			user.setCreatedDt(new Date());
		} else {
			response.setStatusCode(2);
			response.setResultMessage(Constants.ERR_USER_EXIST);
			return response;
		}

		this.userDao.save(user);
		response.setResultMessage(Constants.USER_CREATE_SUCCESS);

		return response;
	}

	public boolean isUsernameUnique(String username) {
		UserView user = userDao.findByUsername(username);
		return (user == null);
	}
}
