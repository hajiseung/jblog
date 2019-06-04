package com.cafe24.jblog2.dao;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog2.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;

	public UserVo checkId(String id) {
		return sqlSession.selectOne("user.checkid",id);
	}


	public UserVo getUser(UserVo userVo) {
		return sqlSession.selectOne("user.get", userVo);
	}


	public void join(UserVo userVo) {
		sqlSession.insert("user.join",userVo);
		sqlSession.insert("user.joinBlog",userVo);
		sqlSession.insert("user.joinCategory",userVo);
		sqlSession.insert("user.joinPost",userVo);
	}


	public UserVo login(UserVo userVo) {
		return sqlSession.selectOne("user.login", userVo);
	}


}
