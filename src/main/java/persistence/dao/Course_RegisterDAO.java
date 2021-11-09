package main.java.persistence.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.persistence.dto.Course_RegisterDTO;

interface ICourseRegisterDAO{
	public int Insert(Course_RegisterDTO Course);
	public List<Course_RegisterDTO> GetAllSubject();
	public int delete(int CourseId);
	

}

public class Course_RegisterDAO implements ICourseRegisterDAO {

private static Course_RegisterDAO instance;
	
	//this method make can get resource or make the resoure and return it
	public static Course_RegisterDAO GetCourse_RegisterDAO() {
		if(instance ==null) {
			instance =new Course_RegisterDAO();
		}
		return instance;
		
	}
	//private constructor 
	private Course_RegisterDAO() {
	}
	
	
	
	@Override
	public int Insert(Course_RegisterDTO Course) {
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost/mydb?serverTimezone=UTC&"
	           + "user=root&password=k1651227");
		  
		String sql ="INSERT INTO Course_Register VALUES(?, ?, ?, ?, ?,?);";

		pstmt =conn.prepareStatement(sql);
		
		
		pstmt.setInt(1, Course.getReg_number());
		pstmt.setString(2, Course.getSubjectName());
		pstmt.setString(3, Course.getReg_Stdid());
		pstmt.setString(4, Course.getReg_StdName());
		pstmt.setDate(5,  Course.getReg_Date());
		pstmt.setBoolean(6,  Course.getSignClass_Able());


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
	public int delete(int courseId) {
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost/mydb?serverTimezone=UTC&"
	           + "user=root&password=k1651227");
		  
		String sql =" DELETE  FROM Course_Register WHERE Reg_number=?"; // input the sql here
		pstmt =conn.prepareStatement(sql);
		pstmt.setInt(1, courseId);
		int res = pstmt.executeUpdate();
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
	public List<Course_RegisterDTO> GetAllSubject() {

		Connection conn=null;
		PreparedStatement pstmt =null;
		List<Course_RegisterDTO> list =new ArrayList<Course_RegisterDTO>();
		ResultSet rs =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost/mydb?serverTimezone=UTC&"
	           + "user=root&password=k1651227");
		 
		String sql ="Select * From Course_Register;"; 
		pstmt =conn.prepareStatement(sql);
		pstmt.executeQuery();
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			Course_RegisterDTO dto=new Course_RegisterDTO();
			
			
			dto.setReg_Date(rs.getDate("Reg_Date"));
			dto.setReg_number(rs.getInt("Reg_number"));
			dto.setReg_StdName(rs.getString("Reg_StdName"));
			dto.setSignClass_Able(rs.getBoolean("SignClass_Able"));
			dto.setSubjectName(rs.getString("Reg_SubName"));
			dto.setReg_Stdid(rs.getString("Reg_Stdid"));
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
	}
