package main.java.service;



import java.util.ArrayList;
import java.util.List;

import main.java.persistence.dao.Course_RegisterDAO;
import main.java.persistence.dto.Course_RegisterDTO;

public class Course_RegisterService {

private static Course_RegisterService instance;

private Course_RegisterService(){
     /*Private Constructor will prevent 
      * the instantiation of this class directly*/
  }

public static Course_RegisterService getMemberService(){ {
	
	if(instance ==null)
		instance =new Course_RegisterService();
	
}
return instance;
}

public boolean Insert(Course_RegisterDTO dto) {
	
	
	int res = Course_RegisterDAO.GetCourse_RegisterDAO().Insert(dto); 
	if(res>0) return true;
	return false;
	
	
}



public void Read() {
	List<Course_RegisterDTO> list =new ArrayList<Course_RegisterDTO>(); 
	list =Course_RegisterDAO.GetCourse_RegisterDAO().GetAllSubject(); 
	
	for(Course_RegisterDTO dto : list) {
		System.out.println(dto.toString());
	}
	
}

public void delete(int CourseId)
{
	int res = Course_RegisterDAO.GetCourse_RegisterDAO().delete(CourseId); 
	if(res>0) System.out.println("delete is success");
	System.out.println(" delete is fail");

}

}
