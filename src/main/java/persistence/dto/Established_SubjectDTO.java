package main.java.persistence.dto;

import java.util.Date;

public class Established_SubjectDTO {

	int Est_Subject;
	String Est_Subject_Name;
	String Professsor_Name;
	int Std_grade;
	String Classroom;
	Date Time;
	int Maximum_Student;
	String Day_Of_Week;
	Date StartTime;
	Date EndTime;
	
	
	public Established_SubjectDTO() {
		
	}


	public int getEst_Subject() {
		return Est_Subject;
	}


	public void setEst_Subject(int est_Subject) {
		Est_Subject = est_Subject;
	}


	public String getEst_Subject_Name() {
		return Est_Subject_Name;
	}


	public void setEst_Subject_Name(String est_Subject_Name) {
		Est_Subject_Name = est_Subject_Name;
	}


	public String getProfesssor_Name() {
		return Professsor_Name;
	}


	public void setProfesssor_Name(String professsor_Name) {
		Professsor_Name = professsor_Name;
	}


	public int getStd_grade() {
		return Std_grade;
	}


	public void setStd_grade(int std_grade) {
		Std_grade = std_grade;
	}


	public String getClassroom() {
		return Classroom;
	}


	public void setClassroom(String classroom) {
		Classroom = classroom;
	}


	public Date getTime() {
		return Time;
	}


	public void setTime(Date time) {
		Time = time;
	}


	public int getMaximum_Student() {
		return Maximum_Student;
	}


	public void setMaximum_Student(int maximum_Student) {
		Maximum_Student = maximum_Student;
	}


	public String getDay_Of_Week() {
		return Day_Of_Week;
	}


	public void setDay_Of_Week(String day_Of_Week) {
		Day_Of_Week = day_Of_Week;
	}


	public Date getStartTime() {
		return StartTime;
	}


	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}


	public Date getEndTime() {
		return EndTime;
	}


	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}
	
	
	
	
	
}
