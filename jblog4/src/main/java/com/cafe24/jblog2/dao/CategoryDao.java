package com.cafe24.jblog2.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.cafe24.jblog2.vo.BlogVo;
import com.cafe24.jblog2.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;

	public List<CategoryVo> getList(BlogVo blogVo, ModelMap modelMap) {
		return sqlSession.selectList("category.getList", blogVo);
	}

//	public List<CategoryVo> getList2(BlogVo blogVo, ModelMap modelMap) {
//		return sqlSession.selectList("category.getList2", blogVo);
//	}

	public void writeblogAdminCategory(ModelMap modelMap) {
		sqlSession.insert("category.writeblogAdminCategory", modelMap);
	}

	public List<CategoryVo> getCategoryList(BlogVo blogVo) {
		return sqlSession.selectList("category.getList", blogVo);
	}

	public boolean deleteCategory(CategoryVo categoryVo) {
		return sqlSession.delete("category.deleteCategory", categoryVo) == 1;
	}

	public CategoryVo getCategoryNo(ModelMap modelMap) {
		return sqlSession.selectOne("category.getCategoryNo", modelMap);
	}

}
