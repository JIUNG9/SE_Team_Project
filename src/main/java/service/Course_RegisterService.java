package main.java.service;


import main.java.persistence.dao.Course_RegisterDAO;
import main.java.persistence.dto.Course_RegisterDTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Course_RegisterService {

private static Course_RegisterService instance;

private Course_RegisterService(){
     /*Private Constructor will prevent 
      * the instantiation of this class directly*/
  }

public static Course_RegisterService getCourse_RegisterService(){ {
	
	if(instance ==null)

		instance =new Course_RegisterService();
	
}
return instance;
}

public boolean Insert(Course_RegisterDTO dto) {
	
	
	int res = Course_RegisterDAO.GetCourse_RegisterDAO().insert(dto);
	if(res>0) return true;
	return false;
	
	
}

public boolean update(Course_RegisterDTO dto, String subName){
	int res = Course_RegisterDAO.GetCourse_RegisterDAO().update(dto,subName);
	if(res>0) return true;
	return false;

}

public boolean setRegDateByGrade(int grade, Date exp){
	List<Course_RegisterDTO> list =new ArrayList<Course_RegisterDTO>();
	list =Course_RegisterDAO.GetCourse_RegisterDAO().getAllSubject();
	boolean flag =false;
	for(Course_RegisterDTO c : list){
		if(c.getRegGrade()==grade){
			c.setRegDate(exp);
			update(c,c.getRegSubjectName());
			flag =true;
		}
	}
	return flag;
}


public void readAll() {
	List<Course_RegisterDTO> list =new ArrayList<Course_RegisterDTO>();
	list =Course_RegisterDAO.GetCourse_RegisterDAO().getAllSubject();
	
	for(Course_RegisterDTO dto : list) {
		System.out.println(dto.toString());
	}
	
}

public boolean delete(String subName)
{
	int res = Course_RegisterDAO.GetCourse_RegisterDAO().delete(subName);
	if(res>0) return true;
	return false;


}

}
