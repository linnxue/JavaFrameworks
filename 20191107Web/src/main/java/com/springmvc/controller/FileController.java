package com.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.pojo.User;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@RequestMapping(value="/up", method=RequestMethod.POST)
	public String fileup(User user,MultipartFile file, Model model, HttpServletRequest req ) {
		System.out.println(user);
		if(file.isEmpty()) {
			model.addAttribute("msg", "δѡ���ļ�");
			return "sccess";
		}
		String filename = "";
		try {
			//�ϴ��ļ�������
			filename = file.getOriginalFilename();
			//�ϴ�����·��
			String path = req.getServletContext().getRealPath("/files");
			//�����ϴ��ļ�����
			File descFile = new File(path, filename);
			file.transferTo(descFile);
			model.addAttribute("msg", filename+"�ϴ��ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", filename+"�ϴ�ʧ��");
		} 
		return "success";
	}
	
	@RequestMapping("/down")
	public void filedown(@RequestParam("filename")String fn,HttpServletResponse res,HttpSession session, Model model) throws IOException {
		String path = session.getServletContext().getRealPath("/files");
		File file = new File(path, fn);
		//��ȡfile�е�����
		byte[] data = FileUtils.readFileToByteArray(file);
		//������Ӧ��ʽΪ��������
	//	fn = new String(fn.getBytes("utf-8"),"iso8859-1");
		String urlfn = URLEncoder.encode(fn, "utf-8");
		//��IE������б�������setContentType("application/x-msdownload;");
		res.setContentType("application/x-msdownload;");
		res.setHeader("Content-disposition","attachment; filename=" +urlfn);
		res.getOutputStream().write(data);
	}

}
