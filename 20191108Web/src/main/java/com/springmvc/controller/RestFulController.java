package com.springmvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/restful")
public class RestFulController {
	
	@RequestMapping("/result")
	public String getResult() {
		return "result";
	}

	//��ȡ method="get"
	@RequestMapping(value="/dododo", method=RequestMethod.GET)
	public String get(String name, Model model) {
		model.addAttribute("msg", "get���󣬻�ȡ"+name+"����");
		return "result";
	}
	
	//���� method="post"
	@RequestMapping(value="/dododo", method=RequestMethod.POST)
	public String post(String name, Model model) {
		model.addAttribute("msg", "post��������"+name+"����");
		return "result";
	}
	
	//�޸� method="post" <input type="hidden" value="put" name="_method" />
	@RequestMapping(value="/dododo", method=RequestMethod.PUT)
	@ResponseBody
	public void put(String name, Model model, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//model.addAttribute("msg", "put�����޸�"+name+"����");
		//req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, res);
		req.getSession().setAttribute("msg", "put�����޸�"+name+"����");
		res.sendRedirect("result");
	}
	
	//ɾ�� method="post" <input type="hidden" value="delete" name="_method" />
	@RequestMapping(value="/dododo", method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(String name, Model model,HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getSession().setAttribute("msg", "delete����ɾ��"+name+"����");
		res.sendRedirect("result");
	}
}
