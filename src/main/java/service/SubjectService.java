package main.java.service;

import java.util.ArrayList;
import java.util.List;

import main.java.persistence.dao.SubjectDAO;
import main.java.persistence.dto.SubjectDTO;

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
	
	int res= SubjectDAO.getSubjectDAO().Insert(dto);

	if(res>0) return true;
	
	return false;
}

public boolean Update(SubjectDTO dto,String subName) {
	
	int res=SubjectDAO.getSubjectDAO().Update(dto,subName);
		
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

public boolean Delete(String subName) {
	
	
	int res= SubjectDAO.getSubjectDAO().Delete(subName);
	if(res>0) return true;
	return false;


}

}
