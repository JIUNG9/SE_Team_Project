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
	    private static SqlSessionFactory sqlSessionFactory;
	     public Established_SubjectDAO() {
	          if(sqlSessionFactory == null){ 
            InputStream inputStream; 
            try{ 
                inputStream = Resources.getResourceAsStream("resource.Configuration.xml"); 
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
            }catch (IOException e){ 
                 e.printStackTrace(); 
      	  } 
        } 
	     
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
	     
	     
	     public int Update(Established_SubjectDTO dto) {
	    	 SqlSession session = sqlSessionFactory.openSession();
	    	 EstablishedMapper mapper = session.getMapper(EstablishedMapper.class);      

	    	 dto=mapper.selectbyId(2);
	    	 
	    	 //change the data using setter
	    	 
	    	int res= mapper.updateData(dto);
	    	 session.commit();
	    	 session.close();
	    	 return res;
	     }
	     
	     
	     public List<Established_SubjectDTO >selectDataAll(){
	    	 
	    	  SqlSession session = sqlSessionFactory.openSession();
	    	 EstablishedMapper mapper = session.getMapper(EstablishedMapper.class);      
	    	 List<Established_SubjectDTO> list =null;
	    	 list =mapper.selectDataAll();
	    	 return list;
	    	 
	     }
	     
	         public List<Established_SubjectDTO >selectBygrade(){
	    	 
	    	  SqlSession session = sqlSessionFactory.openSession();
	    	 EstablishedMapper mapper = session.getMapper(EstablishedMapper.class);      
	    	 List<Established_SubjectDTO> list =null;
	    	 list =mapper.selectDataAll();
	    	 return list;
	    	 
	     }
	         
	            public List<Established_SubjectDTO >selectByprof(){
	    	 
	    	  SqlSession session = sqlSessionFactory.openSession();
	    	 EstablishedMapper mapper = session.getMapper(EstablishedMapper.class);      
	    	 List<Established_SubjectDTO> list =null;
	    	 list =mapper.selectDataAll();
	    	 return list;
	    	 
	     }
	    	 

	
}
