package main.java.persistence.dto;


public  class MemberDTO{
	String password;
	String name;
	String position;
	String phoneNumber;
	String memberId;


	public MemberDTO(){

	}
	public MemberDTO(String name,String memberId, String password ,String position, String phoneNumber) {
		this.password = password;
		this.name = name;
		this.position = position;
		this.phoneNumber = phoneNumber;
		this.memberId = memberId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


}

