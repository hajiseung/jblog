package com.cafe24.jblog2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.cafe24.jblog2.vo.BlogVo;
import com.cafe24.jblog2.vo.CategoryVo;
import com.cafe24.jblog2.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	private SqlSession sqlSession;

	public List<PostVo> getList(ModelMap modelMap) {
		return sqlSession.selectList("post.getList", modelMap);
	}

	public void blogAdminWrite(ModelMap modelMap) {
		sqlSession.insert("post.blogAdminWrite", modelMap);
	}

	public PostVo getOne(ModelMap modelMap) {
		return sqlSession.selectOne("post.getOne", modelMap);
	}

	public int deletePost(CategoryVo categoryVo) {
		return sqlSession.delete("post.deleteCategory", categoryVo);
	}

	public void insertdefaultPost(CategoryVo getCategoryNo) {
		sqlSession.insert("post.insertdefaultPost",getCategoryNo);
	}

}
