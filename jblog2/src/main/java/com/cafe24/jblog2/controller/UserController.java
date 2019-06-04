package com.cafe24.jblog2.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog2.dto.JSONResult;
import com.cafe24.jblog2.service.UserService;
import com.cafe24.jblog2.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	// 회원 가입 Form화면
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public String joinform(@ModelAttribute UserVo userVo) {
		return "user/join";
	}

	// 회원 가입 정보 받아온 후 메인페이지
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			return "/user/join";
		}
		userService.join(userVo);
		return "/user/joinsuccess";
	}

	// 회원가입시 userid 체크용 메서드(Ajax)
	@ResponseBody
	@RequestMapping("/checkid")
	public JSONResult checkid(@RequestParam(value = "userid", defaultValue = "", required = true) String id) {
		boolean result = userService.checkId(id);
		return JSONResult.success(result);
	}

	// 회원 로그인
	@RequestMapping("/loginform")
	public String loginform() {
		return "user/login";
	}
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public void auth() {
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout() {
	}
	
//	@RequestMapping("/login")
//	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
//		UserVo resultUserVo = userService.login(userVo);
//		session.setAttribute("authUser", resultUserVo);
//		return "redirect:/";
//	}

	// 회원 로그아웃
}
