package cn.qf.smbms.dao;

import cn.qf.smbms.pojo.User;

//����smbms_user�����ɾ�Ĳ鷽��
public interface UserDao {
	//��ӷ���
	public int addUser(User user);
	//�޸ķ���
	public int updateUser(User user);
	//ɾ������
	public int deleteUser(int id);
}
