package com.cafe24.jblog2.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog2.vo.BlogVo;

@Repository
public class BlogDao {
	@Autowired
	private SqlSession sqlSession;

	public BlogVo get(BlogVo blogVo) {
		BlogVo result = sqlSession.selectOne("blog.get", blogVo);
		System.out.println("Dao::::::::::::::::"+result);
		return result;
	}

	public void updateBlog(BlogVo blogVo) {
		sqlSession.update("blog.updateBlog", blogVo);
	}

}
