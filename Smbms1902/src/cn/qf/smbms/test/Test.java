package cn.qf.smbms.test;

import cn.qf.smbms.pojo.User;
import cn.qf.smbms.service.UserService;

public class Test {
	UserService us=new UserService();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Test.add();
		Test test=new Test();
		test.update();
	}
	public  void update(){
		User u=new User();
		u.setId(16);
		u.setUserCode("huanhuan");
		u.setUserName("����");
		boolean ret=us.updateUser(u);
		if(ret){
			System.out.println("�޸ĳɹ���");
		}else{
			System.out.println("�޸�ʧ�ܣ�");
		}
	}
	public void add(){
		
		User  u=new User();
		u.setUserCode("wangcai");
		u.setUserName("ĳ����");
		u.setUserPassword("123456");
		boolean ret=us.addUser(u);
		if(ret){
			System.out.println("��ӳɹ�");
		}else{
			System.out.println("���ʧ��");
		}
	}

}
