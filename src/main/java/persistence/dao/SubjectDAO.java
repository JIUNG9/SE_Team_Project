package main.java.persistence.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.java.persistence.dto.SubjectDTO;

interface Subject{
	
	public int Insert(SubjectDTO subject);
	public int Update(SubjectDTO subject, SubjectDTO sub);
	public List<SubjectDTO> ReadAll();
	public List<SubjectDTO> ReadOne();
	
}

public  class SubjectDAO implements Subject {
	//Singleton pattern
	    private static SqlSessionFactory sqlSessionFactory;
	     public SubjectDAO() {
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
	@Override
	public int Insert(SubjectDTO subject) {
			  int res=0;
		      SqlSession session = sqlSessionFactory.openSession();
		      res= session.insert("mapper.SubjectMapper.insert");
		      session.commit();
		      session.close();

		return res;
	}

	@Override
	public int Update(SubjectDTO subject, SubjectDTO sub) {
		int res;
        SqlSession session = sqlSessionFactory.openSession(); 
        res = session.update("mapper.SubjectMapper.update",sub);
        return res;

	}

	@Override
	public List<SubjectDTO> ReadAll() {
		SqlSession session = sqlSessionFactory.openSession();

			List<SubjectDTO> subject = session.selectList("mapper.SubjectMapper.getAll");
			session.close();
			return subject;
		
		
	}

	@Override
	public List<SubjectDTO> ReadOne() {
			SqlSession session = sqlSessionFactory.openSession();
			List<SubjectDTO> subject = session.selectList("mapper.SubjectMapper.getAll");
			session.close();
			return subject;

	}

	
}
