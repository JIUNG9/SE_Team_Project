package main.java.persistence.dto;

import java.sql.Date;

public class SubjectDTO {


	int SubjectId;
	String subjectName;
	int subjectGrade;
	String professor;
	Date startTime;
	Date endTime;
	String syllabus;
	Date syllabusDate;
	String dayOfWeek;
	public SubjectDTO() {
	}

	public SubjectDTO(int subjectId, String subjectName, int subjectGrade, String professor, Date startTime, Date endTime, String syllabus, Date syllabusDate, String dayOfWeek) {
		SubjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectGrade = subjectGrade;
		this.professor = professor;
		this.startTime = startTime;
		this.endTime = endTime;
		this.syllabus = syllabus;
		this.syllabusDate = syllabusDate;
		this.dayOfWeek = dayOfWeek;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectGrade() {
		return subjectGrade;
	}

	public void setSubjectGrade(int subjectGrade) {
		this.subjectGrade = subjectGrade;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public Date getSyllabusDate() {
		return syllabusDate;
	}

	public void setSyllabusDate(Date syllabusDate) {
		this.syllabusDate = syllabusDate;
	}
}