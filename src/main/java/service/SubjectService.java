package main.java.service;

import main.java.persistence.dao.SubjectDAO;
import main.java.persistence.dto.SubjectDTO;

import java.sql.Date;
import java.util.List;

public class SubjectService {

	private static SubjectService instance;

	private SubjectService() {
		
	}
	
public static SubjectService getSubjectService(){ 
		
		if(instance ==null) {
			instance =new SubjectService();
		
	}
	return instance;
}
	
public boolean insert(SubjectDTO dto) {
	
	int res= SubjectDAO.getSubjectDAO().insert(dto);

	if(res>0) return true;
	
	return false;
}

public boolean Update(SubjectDTO dto,String subName) {

	int res=SubjectDAO.getSubjectDAO().update(dto,subName);
		
		if(res>0) return true;
		return false;
	}


public int getSubjectIdBySubName(String subName){
	 SubjectDTO dto= null;
	 dto= SubjectDAO.getSubjectDAO().selectData(subName);
	 if(dto!=null){
		 return dto.getSubjectId();
	 }
	 else{
		 return -1;
	 }
}

public void ReadDataAll(){
	List<SubjectDTO> list=null;
	list =SubjectDAO.getSubjectDAO().readAll();

	if(list!=null) {
		for (SubjectDTO dto : list) {
			System.out.println(dto.toString());
		}
	}
	else{
		System.out.println("there is no matched data");
	}
}
//get schedule by using subject name
public void getSubjectSchedule(String subName){
	SubjectDTO dto = null;
	dto=SubjectDAO.getSubjectDAO().selectData(subName);
	if(dto!=null){
		System.out.println("요일: " + dto.getDayOfWeek());
		System.out.println("시작시간: " + dto.getStartTime());
		System.out.println("끝나는 시간: " + dto.getEndTime());
	}
	else{
		System.out.println("there is no matched data");
	}


}

public boolean setSyllabus_Date(Date exp, String subName){
	SubjectDTO dto=null;
	dto=SubjectDAO.getSubjectDAO().selectData(subName);
	dto.setSyllabusDate(exp);
	int res =SubjectDAO.getSubjectDAO().update(dto,subName);
	if(res>0 && dto!=null) return true;
	return false;
}


public SubjectDTO getSubBySubName(String subName){
	SubjectDTO dto=null;
	dto =SubjectDAO.getSubjectDAO().selectData(subName);
		return dto;

}
public SubjectDTO getSubjectBySUbName(String subName){

	SubjectDTO dto =SubjectDAO.getSubjectDAO().selectData(subName);

	return dto;
}




public void getOneSyllabus(String subName){
	SubjectDTO dto= null;
	dto=SubjectDAO.getSubjectDAO().selectData(subName);
	if(dto==null)
		System.out.println("there is no data from that subject name ");
	else{
		System.out.println(dto.getSyllabus());
	}
}
//getting schedule by using member id(SubQuery)
public void
getStudentTimeSchedule(String memberId) {
	List<SubjectDTO> list = null;
	list = SubjectDAO.getSubjectDAO().getStudnetSchedule(memberId);
	if(list!=null) {
		for (SubjectDTO dto : list) {
			System.out.println("요일: " + dto.getDayOfWeek());

			System.out.println("시작시간: " + dto.getStartTime());
			System.out.println("끝나는 시간: " + dto.getEndTime());

		}
	}
	else{
		System.out.println("there is no matched data");
	}
}
public boolean Delete(String subName) {
	
	
	int res= SubjectDAO.getSubjectDAO().delete(subName);
	if(res>0) return true;
	return false;


}

}
