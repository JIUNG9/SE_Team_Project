package main.java.persistence.dto;

import java.sql.Timestamp;
import java.util.Date;

public class Established_SubjectDTO {

	int Est_Subject;
	String Est_Subject_Name;
	String Professor_Name;
	int Std_grade;
	String Classroom;
	int Maximum_Student;
	String Day_Of_Week;
	Timestamp StartTime;
	Timestamp EndTime;
	
	
	public Established_SubjectDTO() {
		
	}


	public Established_SubjectDTO(int est_Subject, String est_Subject_Name, String professsor_Name, int std_grade,
			String classroom, int maximum_Student, String day_Of_Week, Timestamp startTime, Timestamp endTime) {
		super();
		Est_Subject = est_Subject;
		Est_Subject_Name = est_Subject_Name;
		Professor_Name = professsor_Name;
		Std_grade = std_grade;
		Classroom = classroom;
		Maximum_Student = maximum_Student;
		Day_Of_Week = day_Of_Week;
		StartTime = startTime;
		EndTime = endTime;

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


	public String getProfessor_Name() {
		return Professor_Name;
	}


	public void setProfessor_Name(String professor_Name) {
		Professor_Name = professor_Name;
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


	public Timestamp getStartTime() {
		return StartTime;
	}


	public void setStartTime(Timestamp startTime) {
		StartTime = startTime;
	}


	public Timestamp getEndTime() {
		return EndTime;
	}


	public void setEndTime(Timestamp endTime) {
		EndTime = endTime;
	}
	
	
	
	
	
}
