package com.trippify.trippify.common.model.request;

import com.trippify.trippify.common.model.UserVO;

public class CreateUserRest {
	private UserVO userVO;

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
}
