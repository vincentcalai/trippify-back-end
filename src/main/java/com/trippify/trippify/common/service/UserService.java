package com.trippify.trippify.common.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trippify.trippify.common.dao.IUserDao;
import com.trippify.trippify.common.model.UserVO;
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
}
