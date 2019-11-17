package cn.qf.smbms.util;
//mybatis�������ݿ�Ĺ�����

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	//ͨ����̬������ȡ�����ļ�
	static{
		try {
			//ͨ������ȡ�����ļ�
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			factory=new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡsession�ķ���
	public static SqlSession getSqlSession(){
		return MyBatisUtil.factory.openSession();
	}
	//�ر�session�ķ���
	public static void closeSqlSession(SqlSession session){
		if(session!=null){
			session.close();
		}
	}
}










