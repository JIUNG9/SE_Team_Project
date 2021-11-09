package main.java.persistence.dto;


public  class MemberDTO{

	String Name;
	String Position;
	String PhoneNumber;
	String MemberID;
	
	
	public MemberDTO() {
		
	}
	
	
	public MemberDTO(String memberID, String name, String position, String phoneNumber) {
		super();
		Name = name;
		Position = position;
		PhoneNumber = phoneNumber;
		MemberID = memberID;
	}


	public String getMemberID() {
		return MemberID;
	}
	
	public void setMemberID(String memberID) {
		MemberID=memberID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return " Name=" + Name + ", Position=" + Position + ", PhoneNumber=" + PhoneNumber + ", MemberID="
				+ MemberID;
	}
	
}

