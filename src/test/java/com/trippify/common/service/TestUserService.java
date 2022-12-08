package com.trippify.common.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.trippify.TestWithSpringBoot;
import com.trippify.trippify.common.dao.IUserDao;
import com.trippify.trippify.common.model.UserVO;
import com.trippify.trippify.common.service.UserService;
import com.trippify.trippify.common.view.UserView;

public class TestUserService extends TestWithSpringBoot {

	@InjectMocks
	private UserService userService;

	@Mock
	public IUserDao userDao;

	private List<UserView> setupRegisteredUsers() {
		UserView userView1 = new UserView();
		userView1.setId(1L);
		userView1.setUsername("TESTUSER1");
		userView1.setEmail("TESTUSER1@GMAIL.COM");
		userView1.setContactNo("99999991");

		UserView userView2 = new UserView();
		userView2.setId(2L);
		userView2.setUsername("TESTUSER2");
		userView2.setEmail("TESTUSER2@GMAIL.COM");
		userView2.setContactNo("99999992");

		UserView userView3 = new UserView();
		userView3.setId(3L);
		userView3.setUsername("TESTUSER3");
		userView3.setEmail("TESTUSER3@GMAIL.COM");
		userView3.setContactNo("99999993");

		UserView userView4 = new UserView();
		userView4.setId(4L);
		userView4.setUsername("TESTUSER4");
		userView4.setEmail("TESTUSER4@GMAIL.COM");
		userView4.setContactNo("99999994");

		List<UserView> userViewList = new ArrayList<>();
		userViewList.add(userView1);
		userViewList.add(userView2);
		userViewList.add(userView3);
		userViewList.add(userView4);
		return userViewList;
	}

	@Test
	void retrieveUserSuccessful() throws Exception {
		List<UserView> userViewList = setupRegisteredUsers();
		when(userDao.findAllByDelInd(anyString())).thenReturn(userViewList);
		List<UserVO> userVO = userService.retrieveRegUsers();
		assertEquals(4, userVO.size());
	}

	@Test
	void retrieveUserReturnNull() throws Exception {
		when(userDao.findAllByDelInd(anyString())).thenReturn(null);
		List<UserVO> userVO = userService.retrieveRegUsers();
		assertNull(userVO);
	}

	@Test
	void retrieveUserReturnListSize0() throws Exception {
		when(userDao.findAllByDelInd(anyString())).thenReturn(new ArrayList<>());
		List<UserVO> userVO = userService.retrieveRegUsers();
		assertNull(userVO);
	}

}
