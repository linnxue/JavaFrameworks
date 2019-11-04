package com.template.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.template.dao.IAccountDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-jdbctemplate.xml")
public class TestDemo6 {
	@Autowired
	@Qualifier("accountDaoImpl")
	private IAccountDao dao;
	
	@Test
	public void test() {
		int cnt = dao.updateMoney(101, 1000);
		System.out.println(cnt);
	}
}
/*
 * spring������Junit��Ԫ����
 * 1������Junit��jar�� spring-test.jar
 * 2���������2��ע��
 * @RunWith(SpringJUnit4ClassRunner.class)  ָ��ʹ�õ�spring�е�Junit
 * @ContextConfiguration("classpath:application-jdbctemplate.xml") ָ����ȡ�������ļ�
 * 3��ĳ�����еķ������е�Ԫ���ԣ�����Ҫ�����ж������ԣ���@Autowired
 * 4) ���Եķ���ʹ��@Test���Ϳ��Խ��е�Ԫ������
 * */


