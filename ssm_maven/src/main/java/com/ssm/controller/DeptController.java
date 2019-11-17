package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.pojo.Dept;
import com.ssm.service.IDeptServcie;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	@Qualifier("deptServcie")
	private IDeptServcie ds;
	
	public void setDs(IDeptServcie ds) {
		this.ds = ds;
	}

	//��ѯȫ����¼����ת��showall.jsp
	//@RequestMapping(value="/all",method=RequestMethod.GET)
	@GetMapping("/all")
	public String all(Model model) {
		model.addAttribute("all", ds.getAllDepts());
		return "showall";
	}
	
	//����deptno��ѯ������Ϣ����ת��update.jsp
	//@RequestMapping(value="/getbyno", method=RequestMethod.GET)
	@GetMapping("/getbyno")
	public String getDeptbyNo(@RequestParam("deptno")int deptno, Model model) {
		model.addAttribute("dept", ds.getDeptByNo(deptno));
		return "update";
	}
	
	//@RequestMapping(value="/getbyno2/{deptno}", method=RequestMethod.GET)
	@GetMapping("/getbyno2/{deptno}")
	public String getDeptbyNo2(@PathVariable("deptno")int deptno, Model model) {
		model.addAttribute("dept", ds.getDeptByNo(deptno));
		return "update";
	}
	
	//���ݲ��ű�Ÿ��£����ص���ʾȫ��ҳ��
	@PutMapping("/update")
	public String updateDept(Dept dept) {
		ds.updateDept(dept);
		return "redirect:/dept/all";
	}
	
	//��ת�����ҳ��
	@GetMapping("/savepage")
	public String toSavepage() {
		return "save";
	}
	
	//��Ӳ�����Ϣ����ת��ʾȫ��ҳ��
	@PostMapping("/save")
	public String save(Dept dept) {
		ds.saveDept(dept);
		return "redirect:/dept/all";
	}
	
	//���ݲ��ű��ɾ������������ʾȫ��ҳ��
	@DeleteMapping("/delete/{deptno}")
	public String delete(@PathVariable("deptno") int deptno) {
		ds.deleteDeptByNo(deptno);
		return "redirect:/dept/all";
	}

}
