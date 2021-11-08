package main.java.persistence.dto;

import java.util.Date;

public class Course_RegisterDTO {

	int Reg_number;
	String Reg_subId;
	String SubjectName;
	int Reg_Stdid;
	String Reg_StdName;
	Date Reg_Date;
	Boolean SignClass_Able;
	
 public Course_RegisterDTO() {
	 
	 
 }

public int getReg_number() {
	return Reg_number;
}

public void setReg_number(int reg_number) {
	Reg_number = reg_number;
}

public String getReg_subId() {
	return Reg_subId;
}

public void setReg_subId(String reg_subId) {
	Reg_subId = reg_subId;
}

public String getSubjectName() {
	return SubjectName;
}

public void setSubjectName(String subjectName) {
	SubjectName = subjectName;
}

public int getReg_Stdid() {
	return Reg_Stdid;
}

public void setReg_Stdid(int reg_Stdid) {
	Reg_Stdid = reg_Stdid;
}

public String getReg_StdName() {
	return Reg_StdName;
}

public void setReg_StdName(String reg_StdName) {
	Reg_StdName = reg_StdName;
}

public Date getReg_Date() {
	return Reg_Date;
}

public void setReg_Date(Date reg_Date) {
	Reg_Date = reg_Date;
}

public Boolean getSignClass_Able() {
	return SignClass_Able;
}

public void setSignClass_Able(Boolean signClass_Able) {
	SignClass_Able = signClass_Able;
}

 
 
	
	
}
