package com.cafe24.jblog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog2.dao.UserDao;
import com.cafe24.jblog2.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public boolean checkId(String id) {
		UserVo uservo = userDao.checkId(id);
		return uservo != null;
	}

	public UserVo getUser(UserVo userVo) {
		return userDao.getUser(userVo);
	}

	public void join(UserVo userVo) {
		userDao.join(userVo);
	}

	public UserVo login(UserVo userVo) {
		return userDao.login(userVo);
	}

}
