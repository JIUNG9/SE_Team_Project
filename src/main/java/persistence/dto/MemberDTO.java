package main.java.persistence.dto;



public abstract class MemberDTO{

	String Name;
	String Position;
	String PhoneNumber;
	String MemberID;
	
	
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
	
	
}


class Student extends MemberDTO {
	
	public Student() {
		
	}
	// do not have to another constructor have another field for update
	// because just use the where in query and could be update easily
	
	
}

class Professor extends MemberDTO{
	
	public Professor() {
		
	}
	
	
	
}


class Admin extends MemberDTO{
	
	public Admin() {
		
	}
	
}
