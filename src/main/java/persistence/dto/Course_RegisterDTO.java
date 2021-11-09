package main.java.persistence.dto;

import java.sql.Date;

public class Course_RegisterDTO {

	int Reg_number;
	String SubjectName;
	String Reg_Stdid;
	String Reg_StdName;
	Date Reg_Date;
	Boolean SignClass_Able;
	
 public Course_RegisterDTO() {
	 
	 
 }

public Course_RegisterDTO(int reg_number, String subjectName,String reg_Stdid ,String reg_StdName,
		Date reg_Date, Boolean signClass_Able) {
	super();
	Reg_number = reg_number;
	SubjectName = subjectName;
	Reg_StdName = reg_StdName;
	Reg_Date = reg_Date;
	Reg_Stdid=reg_Stdid;
	SignClass_Able = signClass_Able;
}

public int getReg_number() {
	return Reg_number;
}

public void setReg_number(int reg_number) {
	Reg_number = reg_number;
}



public String getReg_Stdid() {
	return Reg_Stdid;
}

public void setReg_Stdid(String reg_Stdid) {
	Reg_Stdid = reg_Stdid;
}

public String getSubjectName() {
	return SubjectName;
}

public void setSubjectName(String subjectName) {
	SubjectName = subjectName;
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

@Override
public String toString() {
	return " Reg_number=" + Reg_number + ", SubjectName=" + SubjectName + ", Reg_Stdid=" + Reg_Stdid
			+ ", Reg_StdName=" + Reg_StdName + ", Reg_Date=" + Reg_Date + ", SignClass_Able=" + SignClass_Able ;
}

 
 
	
	
}
