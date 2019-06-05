package com.cafe24.jblog2.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog2.dto.JSONResult;
import com.cafe24.jblog2.service.BlogService;
import com.cafe24.jblog2.vo.BlogVo;
import com.cafe24.jblog2.vo.CategoryVo;
import com.cafe24.jblog2.vo.PostVo;
import com.cafe24.jblog2.vo.UserVo;

@Controller
@RequestMapping("/{blogid:^(?!assets|images|user).*}")
public class BlogController {
	@Autowired
	private BlogService blogService;

	// 회원 블로그로 이동
	@GetMapping({ "", "/{pathVariable}", "/{pathVariable1}/{pathVariable2}" })
	public String userBlog(
			@PathVariable Optional<String> blogid, 
			@PathVariable Optional<Integer> pathVariable,
			@PathVariable Optional<Integer> pathVariable1, 
			@PathVariable Optional<Integer> pathVariable2,
			ModelMap modelMap, BlogVo blogVo) {
		//사용자 있나 없나 체크
		UserVo usercheck = blogService.checkUser(blogid);
		if(usercheck==null) {
			return "/main/error";
		}
		modelMap.put("pathVariable", pathVariable);
		modelMap.put("pathVariable1", pathVariable1);
		modelMap.put("pathVariable2", pathVariable2);

		Map<Object, Object> result = blogService.get(modelMap);

		BlogVo resultBlogVo = (BlogVo) result.get("blogVoGet");
		List<CategoryVo> resultCategoryVo = (List<CategoryVo>) result.get("categoryVo");
		List<PostVo> resultPostVo = (List<PostVo>) result.get("postVoList");
		PostVo postVoOne = (PostVo) result.get("postVoOne");
		
		System.out.println(resultBlogVo);
		modelMap.addAttribute("resultBlogVo", resultBlogVo);
		modelMap.addAttribute("resultCategoryVo", resultCategoryVo);
		modelMap.addAttribute("resultPostVo", resultPostVo);
		modelMap.addAttribute("postVoOne", postVoOne);

		return "blog/blog-main";
	}

	// 블로그 관리 페이지
	@GetMapping("/admin/basic")
	public String blogAdminBasicGet(BlogVo blogVo, Model model) {
		BlogVo resultBlogVo = blogService.get(blogVo);
		model.addAttribute("resultBlogVo", resultBlogVo);
		return "blog/blog-admin-basic";
	}

	@PostMapping("/admin/basic")
	public String blogAdminBasicPost(@ModelAttribute BlogVo blogVo, Model model) {
		System.out.println(blogVo);
		blogVo.setBloglogo(blogService.restore(blogVo));
		blogService.updateBlog(blogVo);
		model.addAttribute("resultBlogVo", blogVo);
		return "redirect:/" + blogVo.getBlogid();
	}

	// 카테고리 이동
	@RequestMapping(value = "/admin/category", method = RequestMethod.GET)
	public String blogAdminCategory(@PathVariable Optional<String> blogid, ModelMap modelMap) {
		modelMap.put("blogid", blogid.get());
		List<CategoryVo> resultCategoryVo = blogService.getCategoryList(modelMap);
		System.out.println(resultCategoryVo);
		modelMap.addAttribute("resultCategoryVo", resultCategoryVo);

		BlogVo getTitle = new BlogVo();
		getTitle.setBlogid(blogid.get());
		BlogVo resultBlogVo = blogService.get(getTitle);
		modelMap.addAttribute("resultBlogVo", resultBlogVo);
		return "blog/blog-admin-category";
	}

	// 블로그 관리페이지 - 카테고리 작성
	@RequestMapping(value = "/admin/category", method = RequestMethod.POST)
	public String writeblogAdminCategory(@ModelAttribute CategoryVo categoryVo, @ModelAttribute BlogVo blogVo,
			ModelMap modelMap) {
		System.out.println(categoryVo);
		modelMap.put("blogid", blogVo.getBlogid());
		modelMap.put("c_name", categoryVo.getC_name());
		modelMap.put("c_desc", categoryVo.getC_desc());

		blogService.writeblogAdminCategory(modelMap);
		CategoryVo getCategoryNo = blogService.getCategoryNo(modelMap);
		blogService.insertdefaultPost(getCategoryNo);
		List<CategoryVo> resultCategoryVo = blogService.getCategoryList(modelMap);
		modelMap.addAttribute("resultCategoryVo", resultCategoryVo);

		return "redirect:/" + blogVo.getBlogid() + "/admin/category";
	}

	// 글 작성 이동
	@RequestMapping(value = "/admin/write", method = RequestMethod.GET)
	public String blogAdminWriteForm(@PathVariable Optional<String> blogid, ModelMap modelMap) {
		modelMap.put("blogid", blogid.get());
		List<CategoryVo> resultCategoryVo = blogService.getCategoryList(modelMap);
		modelMap.addAttribute("resultCategoryVo", resultCategoryVo);

		BlogVo getTitle = new BlogVo();
		getTitle.setBlogid(blogid.get());
		BlogVo resultBlogVo = blogService.get(getTitle);
		modelMap.addAttribute("resultBlogVo", resultBlogVo);
		return "blog/blog-admin-write";
	}

	@RequestMapping(value = "/admin/write", method = RequestMethod.POST)
	public String blogAdminWrite(@PathVariable Optional<String> blogid, @ModelAttribute PostVo postVo,
			ModelMap modelMap) {
		modelMap.put("blogid", blogid.get());
		modelMap.put("p_title", postVo.getP_title());
		modelMap.put("p_desc", postVo.getP_desc());
		modelMap.put("c_no", postVo.getC_no());

		List<CategoryVo> resultCategoryVo = blogService.getCategoryList(modelMap);

		blogService.blogAdminWrite(modelMap);
		modelMap.addAttribute("resultCategoryVo", resultCategoryVo);
		return "redirect:/" + blogid.get() + "/";
	}

	// 카테고리 삭제
	@ResponseBody
	@PostMapping("/delete/category")
	public JSONResult deleteCategory(@ModelAttribute CategoryVo categoryVo) {
		boolean data = blogService.deleteCategory(categoryVo);
		return JSONResult.success(data);
	}
}
