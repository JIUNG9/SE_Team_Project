package main.java.persistence.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.java.persistence.dto.MemberDTO;
import main.java.persistence.dto.SubjectDTO;

interface Subject{
	
	public int Insert(SubjectDTO subject);
	public int Update(SubjectDTO subject,String subjectName);
	public int Delete(String subName);
	public List<SubjectDTO> ReadAll();
	
}

public  class SubjectDAO implements Subject {

private static SubjectDAO instance;
	
	//this method make can get resource or make the resoure and return it
	public static SubjectDAO getSubjectDAO() {
		if(instance ==null) {
			instance =new SubjectDAO();
		}
		return instance;
		
	}
	//private constructor 
	private SubjectDAO() {
	}
	@Override
	public int Insert(SubjectDTO sub) {
		
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mydb", "root", "k1651227");
		String sql =" INSERT INTO Member VALUES(?, ?);";
			
		pstmt =conn.prepareStatement(sql);
		//need to add setString the number of "?"
		pstmt.setString(1, sub.getSubject_Name());
		pstmt.setInt(2, sub.getSubject_Grade());


		

		int res =pstmt.executeUpdate();
		return res;
	}	
	catch(SQLException ex) {
		ex.printStackTrace();
	}
	finally {
	
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
	
	}
	return 0;

	
	}
	
	
	
	@Override
	public int Update(SubjectDTO dto ,String subName) {
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mydb", "root", "k1651227");
		String sql ="UPDATE SET Subject_Name =? Subject_grade = ? Where Subject_Name=?";
			 
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1,dto.getSubject_Name());
		pstmt.setInt(2, dto.getSubject_Grade());
		pstmt.setString(3, dto.getSubject_Name());

		int res =pstmt.executeUpdate();
		return res;
	}	
	catch(SQLException ex) {
		ex.printStackTrace();
	}
	finally {
	
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
	
	}
	return 0;

	
		
	}

	
 	@Override
	public List<SubjectDTO> ReadAll() {
		Connection conn=null;
		PreparedStatement pstmt =null;
		List<SubjectDTO> list =new ArrayList<SubjectDTO>();
		ResultSet rs =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mydb", "root", "k1651227");
		 
		String sql ="SELECT * FROM Subject;"; 
		pstmt =conn.prepareStatement(sql);
		pstmt.executeQuery();
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			SubjectDTO dto=new SubjectDTO();
			
			dto.setSubject_id(rs.getInt("Subject_Id"));
			dto.setSubject_Name(rs.getString("Subject_Name"));
			dto.setSubject_Grade(rs.getInt("Subject_grade"));
			list.add(dto);
		}
		
		
	}	
	catch(SQLException ex) {
		ex.printStackTrace();
	}
	finally {
	
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

	
	}
return list;
	}
	@Override
	public int Delete(String subName) {
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mydb", "root", "k1651227");
		String sql ="DELETE FROM Subject Where Subject_Name =?";
			 
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1,subName);
	

		int res =pstmt.executeUpdate();
		return res;
	}	
	catch(SQLException ex) {
		ex.printStackTrace();
	}
	finally {
	
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
	
	}
	return 0;

	
		
	}

		
	}
	
	
	

