package main.java.service;

import java.util.ArrayList;
import java.util.List;

import main.java.persistence.dao.Established_SubjectDAO;
import main.java.persistence.dto.Established_SubjectDTO;

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
		
	int res= Established_SubjectDAO.getEstablished_SubjectService().Insert(dto);
		
		
		if(res>0) return true;
		return false;
	}


public boolean UpdateMaxNumber(Established_SubjectDTO dto,int id,int max) {
	
	int res=Established_SubjectDAO.getEstablished_SubjectService().UpdateMaxNumber(dto,id,max);
		
		
		if(res>0) return true;
		return false;
	}
public boolean UpdatePlace(Established_SubjectDTO dto,int id,String place) {
	
	int res=Established_SubjectDAO.getEstablished_SubjectService().UpdatePlace(dto,id,place);
		
		
		if(res>0) return true;
		return false;
	}

public void ReadDataAll(){
	List<Established_SubjectDTO> list=new ArrayList<Established_SubjectDTO>();
	list =Established_SubjectDAO.getEstablished_SubjectService().selectData();
	
	for(Established_SubjectDTO dto :list )
	{
		System.out.println(dto.toString());
	}
	
}

public void ReadProfessor(String name){
	List<Established_SubjectDTO> list=new ArrayList<Established_SubjectDTO>();
	list =Established_SubjectDAO.getEstablished_SubjectService().selectData();
	
	for(Established_SubjectDTO dto :list )
	{	if(dto.getProfesssor_Name().equals(name))
		System.out.println(dto.toString());
	}
	
}

public void ReadStudent(int grade){
	List<Established_SubjectDTO> list=new ArrayList<Established_SubjectDTO>();
	list =Established_SubjectDAO.getEstablished_SubjectService().selectData();
	
	for(Established_SubjectDTO dto :list )
	{	if(dto.getStd_grade()==grade)
		System.out.println(dto.toString());
	}
	
}

public void ReadStWithProf(String name, int grade){
	List<Established_SubjectDTO> list=new ArrayList<Established_SubjectDTO>();
	list =Established_SubjectDAO.getEstablished_SubjectService().selectData();
	
	for(Established_SubjectDTO dto :list )
	{	if(dto.getStd_grade()==grade && dto.getProfesssor_Name().equals(name))
		System.out.println(dto.toString());
	}
	
}










}