package main.java.persistence.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.java.persistence.dto.Established_SubjectDTO;
import main.mapper.EstablishedMapper;

public class Established_SubjectDAO{

	//Singleton pattern
		private static Established_SubjectDAO instance;
		 InputStream inputStream;
		   SqlSessionFactory sqlSessionFactory;
		   //how singleton works?
	     private Established_SubjectDAO() {   
	    	 String resource = "resource.Configuration.xml";
	         try {
	             inputStream = Resources.getResourceAsStream(resource);
	             sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
        } 
	     public static Established_SubjectDAO  getEstablished_SubjectService()
	     {
	    	   if (instance == null) {
	               instance = new Established_SubjectDAO();
	           }
	           return instance;
	    	 
	     }
	
	     public int Insert(Established_SubjectDTO dto) {
	    	       SqlSession session = sqlSessionFactory.openSession();
	    	       EstablishedMapper mapper = session.getMapper(EstablishedMapper.class);      

      session.getConfiguration().addMapper(EstablishedMapper.class);
      
      		      
      		      //need to know mapper.insertData return value
      		      int res =mapper.insertData(dto);
      		      session.commit();
      		      session.close();
				return res;
	    	 
	     }
	     
	     
	     public int UpdateMaxNumber(Established_SubjectDTO dto,int id,int max) {
	    	 SqlSession session = sqlSessionFactory.openSession();
	    	 EstablishedMapper mapper = session.getMapper(EstablishedMapper.class);      

	    	 dto=mapper.selectbyId(id);
	    	 dto.setMaximum_Student(max);
	    	 //change the data using setter
	    	 
	    	int res= mapper.updateMaxNumber(dto);
	    	 session.commit();
	    	 session.close();
	    	 return res;
	     }
	     
	     public int UpdatePlace(Established_SubjectDTO dto,int id,String place) {
	    	 SqlSession session = sqlSessionFactory.openSession();
	    	 EstablishedMapper mapper = session.getMapper(EstablishedMapper.class);      

	    	 dto=mapper.selectbyId(id);
	    	 dto.setClassroom(place);
	    	 //change the data using setter
	    	 
	    	int res= mapper.updatePlace(dto);
	    	 session.commit();
	    	 session.close();
	    	 return res;
	     }
	     
	     
	     
	     public List<Established_SubjectDTO >selectData(){
	    	 
	    	  SqlSession session = sqlSessionFactory.openSession();
	    	 EstablishedMapper mapper = session.getMapper(EstablishedMapper.class);      
	    	 List<Established_SubjectDTO> list =null;
	    	 list =mapper.selectDataAll();
	    	 return list;
	    	 
	     }
	     

	
}
