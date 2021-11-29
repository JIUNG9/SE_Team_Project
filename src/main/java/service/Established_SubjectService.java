package main.java.service;

import main.java.persistence.dao.Established_SubjectDAO;
import main.java.persistence.dto.Established_SubjectDTO;

import java.util.List;

public class Established_SubjectService {

	
	private static Established_SubjectService instance;

	private Established_SubjectService() {
		
	}
	
public static Established_SubjectService getEstablished_SubjectService(){ {
		
		if(instance ==null)
			instance =new Established_SubjectService();
		
	}
	return instance;
}
	public boolean insert(Established_SubjectDTO dto) {
		
	int res= Established_SubjectDAO.getEstablished_SubjectDAO().Insert(dto);
		
		
		if(res>0) return true;
		return false;
	}


public boolean Update(Established_SubjectDTO dto,String subName) {
	
	int res=Established_SubjectDAO.getEstablished_SubjectDAO().Update(dto,subName);
		
		
		if(res>0) return true;
		return false;
	}

public boolean Delete(String subName) {
	
	int res=Established_SubjectDAO.getEstablished_SubjectDAO().Delete(subName);
		
		
		if(res>0) return true;
		return false;
	}

public void readOne(String subName){
	Established_SubjectDTO dto =Established_SubjectDAO.getEstablished_SubjectDAO().getOne(subName);
	System.out.println(dto.toString());
}

public void readDataAll(){
	List<Established_SubjectDTO> list=null;
	list =Established_SubjectDAO.getEstablished_SubjectDAO().getAll();
	if(list!=null) {
		for (Established_SubjectDTO dto
				: list) {
			System.out.println(dto.toString());
		}
	}
	else{
		System.out.println("There is no matched data");
	}
}







}