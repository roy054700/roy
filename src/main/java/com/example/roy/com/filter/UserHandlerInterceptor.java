package com.example.roy.com.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.roy.com.controller.Const;
import com.example.roy.com.model.User;



//拦截modler获取用户信息
public class UserHandlerInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String servletPath = request.getServletPath();
		if (servletPath.endsWith(".css")||servletPath.endsWith(".js")||servletPath.endsWith(".jpg")||servletPath.endsWith(".png")) {
			return true;
		}
		System.out.println(servletPath);
		User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
		System.out.println("session"+request.getRequestedSessionId());
			//整合后不是要它
			if (user==null ) {
				
				//response.sendRedirect("/");
				return true;
			}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
