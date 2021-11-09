package main.java.service;

import java.util.ArrayList;
import java.util.List;

import main.java.persistence.dao.SubjectDAO;
import main.java.persistence.dto.SubjectDTO;

//CRU
public class SubjectService {

	private static SubjectService instance;

	private SubjectService() {
		
	}
	
public static SubjectService getSubjectService(){ {
		
		if(instance ==null)
			instance =new SubjectService();
		
	}
	return instance;
}
	
public boolean insert(SubjectDTO dto) {
	
	int res= SubjectDAO.getSubjectDAO().Insert(dto);

	if(res>0) return true;
	
	return false;
}

public boolean Update(SubjectDTO dto,String Subname) {
	
	dto.setSubject_Name(Subname);
	int res=SubjectDAO.getSubjectDAO().Update(dto);
		
		if(res>0) return true;
		return false;
	}

public void ReadDataAll(){
	List<SubjectDTO> list=new ArrayList<SubjectDTO>();
	list =SubjectDAO.getSubjectDAO().ReadAll();

	
	for(SubjectDTO dto :list )
	{
		System.out.println(dto.toString());
	}
	
}

public void ReadByGrade(int grade){
	List<SubjectDTO> list=new ArrayList<SubjectDTO>();
	list =SubjectDAO.getSubjectDAO().ReadAll();

	
	for(SubjectDTO dto :list )
	{
		if(dto.getSubject_Grade()==grade) {
		System.out.println(dto.toString());
	}
	}
}
}
