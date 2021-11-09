package main.java.persistence.dto;

public class SubjectDTO {


	int Subject_id;
	String  Subject_Name;
	int Subject_Grade;
	
	
	public SubjectDTO() {
		
		
	}


	public SubjectDTO(int subject_id, String subject_Name, int subject_Grade) {
		super();
		Subject_id = subject_id;
		Subject_Name = subject_Name;
		Subject_Grade = subject_Grade;
	}


	public int getSubject_id() {
		return Subject_id;
	}


	public void setSubject_id(int subject_id) {
		Subject_id = subject_id;
	}


	public String getSubject_Name() {
		return Subject_Name;
	}


	public void setSubject_Name(String subject_Name) {
		Subject_Name = subject_Name;
	}


	public int getSubject_Grade() {
		return Subject_Grade;
	}


	public void setSubject_Grade(int subject_Grade) {
		Subject_Grade = subject_Grade;
	}
	
	
	
	
	
}
