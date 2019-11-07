package com.springmvc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor2 implements HandlerInterceptor {

	@Override
	// ����֮ǰִ�еĲ������������true���������������false��ֹ����
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		System.out.println(uri+"֮ǰִ����--preHandle222222()");
		return true;
	}

	@Override
	//����ִ����Ϻ�ִ�д˷���
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String uri = request.getRequestURI();
		System.out.println(uri+"ִ�����--postHandle22222()");

	}

	@Override
	//��ͼ������ϣ���Ⱦ��ͼ֮��ִ�д˷���
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String uri = request.getRequestURI();
		System.out.println(uri+"��Ⱦ���--afterCompletion222222()");

	}

}
