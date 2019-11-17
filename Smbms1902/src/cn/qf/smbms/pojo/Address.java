package cn.qf.smbms.pojo;

import org.apache.ibatis.type.Alias;

@Alias("myaddress")  //ͨ��ע���������������Ĭ������±���������һ��
public class Address {
	private int id;
	//��ϵ��
	private String contact;
	//��ַ������Ϣ
	private String addressDesc;
	//�ʱ�
	private String postCode;
	//�绰
	private String tel;
	//�����û�
	private int userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddressDesc() {
		return addressDesc;
	}
	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
