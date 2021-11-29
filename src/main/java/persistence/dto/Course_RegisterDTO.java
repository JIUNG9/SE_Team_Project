package main.java.persistence.dto;

import java.sql.Date;

public class Course_RegisterDTO {

	int regNumber;
	String regSubjectName;
	String regStdid;
	String regStdName;
	Date regDate;
	Boolean signClassAble;
	int regGrade;
	String MemberID;
	int Subject_Id;


 public Course_RegisterDTO() {
	 
	 
 }

	public String getMemberID() {
		return MemberID;
	}

	public void setMemberID(String memberID) {
		MemberID = memberID;
	}

	public int getSubject_Id() {
		return Subject_Id;
	}

	public String getRegSubjectName() {
		return regSubjectName;
	}

	public void setRegSubjectName(String regSubjectName) {
		this.regSubjectName = regSubjectName;
	}

	public void setSubject_Id(int subject_Id) {
		Subject_Id = subject_Id;
	}

	public int getRegNumber() {
		return regNumber;
	}

	public int getRegGrade() {
		return regGrade;
	}

	public void setRegGrade(int regGrade) {
		this.regGrade = regGrade;
	}

	public void setRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}



	public String getRegStdid() {
		return regStdid;
	}

	public void setRegStdid(String regStdid) {
		this.regStdid = regStdid;
	}

	public String getRegStdName() {
		return regStdName;
	}

	public void setRegStdName(String regStdName) {
		this.regStdName = regStdName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Boolean getSignClassAble() {
		return signClassAble;
	}

	public void setSignClassAble(Boolean signClassAble) {
		this.signClassAble = signClassAble;
	}
}
