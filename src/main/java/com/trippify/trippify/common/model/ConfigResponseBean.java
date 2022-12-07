package com.trippify.trippify.common.model;

import java.util.List;
import java.util.Map;

public class ConfigResponseBean {
	private Map<String, ?> result;
	private List<UserVO> regUsersList;

	public Map<String, ?> getResult() {
		return result;
	}

	public void setResult(Map<String, ?> result) {
		this.result = result;
	}

	public List<UserVO> getRegUsersList() {
		return regUsersList;
	}

	public void setRegUsersList(List<UserVO> regUsersList) {
		this.regUsersList = regUsersList;
	}
}
