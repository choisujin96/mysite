package com.javaex.vo;

public class UserVO {

	//필드
	private int no;
	private String id;
	private String password;
	private String name;
	private String gender;
	
	
	
	//생성자
	public UserVO() {
		super();
	}




	public UserVO(int no, String id, String password, String name, String gender) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
	}



	//메소드gs
	public int getNo() {
		return no;
	}




	public void setNo(int no) {
		this.no = no;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getpassword() {
		return password;
	}




	public void setpassword(String password) {
		this.password = password;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}



	//메소드일반
	@Override
	public String toString() {
		return "UserVO [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + "]";
	}
	
	
	
	
	
	
}
