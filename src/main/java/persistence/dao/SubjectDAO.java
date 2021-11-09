package main.java.persistence.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.java.persistence.dto.SubjectDTO;

interface Subject{
	
	public int Insert(SubjectDTO subject);
	public int Update(SubjectDTO subject);
	public List<SubjectDTO> ReadAll();
	
}

public  class SubjectDAO implements Subject {
	
	private static SubjectDAO instance;
	 private static SqlSessionFactory sqlSessionFactory = null;
	 
	    static {
	        try {
	            if(sqlSessionFactory == null) {
	            	ClassLoader classloader = Thread.currentThread().getContextClassLoader();

	            	InputStream is = classloader.getResourceAsStream("/mybatis-config");
	                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is); 
	            }
	        }catch(Exception e) {
	            System.out.println("오류 내용: " + e);
	        }
	    }
	   
    private SubjectDAO() {   
   	 
   }
    public static SubjectDAO  getSubjectDAO()
    {
   	   if (instance == null) {
              instance = new SubjectDAO();
          }
          return instance;
   	 
    }
    
	@Override
	public int Insert(SubjectDTO subject) {
			  int res=0;
			
			  
		      SqlSession session = SubjectDAO.sqlSessionFactory.openSession();
		      res= session.insert("mapper.SubjectMapper.insert",subject);
		      session.commit();
		      session.close();

		return res;
	}

	@Override
	public int Update(SubjectDTO subject) {
		int res;
        SqlSession session = sqlSessionFactory.openSession(); 
        res = session.update("mapper.SubjectMapper.update",subject);
        return res;

	}

	@Override
	public List<SubjectDTO> ReadAll() {
		SqlSession session = sqlSessionFactory.openSession();

			List<SubjectDTO> subject = session.selectList("mapper.SubjectMapper.getAll");
			session.close();
			return subject;
		
		
	}
	

	
	
}
