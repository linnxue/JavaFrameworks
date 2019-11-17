package cn.qf.smbms.service;

import org.apache.ibatis.session.SqlSession;

import cn.qf.smbms.dao.UserDao;
import cn.qf.smbms.pojo.User;
import cn.qf.smbms.util.MyBatisUtil;

public class UserService {
	public boolean addUser(User user){
		//����dao�еķ���
		//mybatis��dao�еĽӿڼ��ӿڵĹ����ļ��Զ�����ʵ���࣬��ʵ�ֽӿ��еķ���
		//1��ͨ��������õ�SqlSession
		SqlSession session=null;
		int ret=0;
		try{
			session=MyBatisUtil.getSqlSession();
			ret=session.getMapper(UserDao.class).addUser(user);
			//�ύ����
			session.commit();
		}catch(Exception ex){
			//��ӡ�쳣��Ϣ
			ex.printStackTrace();
			//�ع�����
			session.rollback();
		}finally{
			//�ر�session
			MyBatisUtil.closeSqlSession(session);
		}
		if(ret==1){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateUser(User user){
		SqlSession session=null;
		int ret=0;
		try{
			session=MyBatisUtil.getSqlSession();
			ret=session.getMapper(UserDao.class).updateUser(user);
			session.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			session.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		if(ret==1){
			return true;
		}else{
			return false;
		}
	}
}
















