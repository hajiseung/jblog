package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.jblog2.service.UserService;
import com.cafe24.jblog2.vo.UserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("프리핸들러를 통한 처리");
		String id = request.getParameter("userid");
		String password = request.getParameter("userpassword");
		UserVo userVo = new UserVo();
		userVo.setUserid(id);
		userVo.setUserpassword(password);
		UserVo authUser = userService.getUser(userVo);
		
		if (authUser == null) {
			response.sendRedirect(request.getContextPath()+"/user/loginform");
			return false;
		}

		// sessiong 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		response.sendRedirect(request.getContextPath());

		return false;
	}

}
