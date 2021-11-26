package main.java.persistence.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.java.persistence.dto.Established_SubjectDTO;
import main.java.persistence.dto.MemberDTO;
import main.java.persistence.dto.SubjectDTO;
import main.java.service.MemberService;


interface IEstablished {
	public int Insert(Established_SubjectDTO dto);
	public int Update(Established_SubjectDTO dto,String subName);
	public int Delete(String subName);
	public  List<Established_SubjectDTO> getAll();
	

}


public class Established_SubjectDAO implements IEstablished {

	private static Established_SubjectDAO instance;
	
	 private Established_SubjectDAO(){
	      /*Private Constructor will prevent 
	       * the instantiation of this class directly*/
	   }
	 
	public static Established_SubjectDAO getEstablished_SubjectDAO(){ 
		
		if(instance ==null) {
			instance =new Established_SubjectDAO();
		}
		return instance;

	}

	
	@Override
	public int Insert(Established_SubjectDTO dto) {
		
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mydb", "root", "k1651227");
		String sql =" INSERT INTO Established_Subject VALUES(?, ?, ?, ?, ? ,? ,?, ?);";
			
		pstmt =conn.prepareStatement(sql);
		//need to add setString the number of "?"
		pstmt.setString(1, dto.getEst_Subject_Name());
		pstmt.setString(2, dto.getProfesssor_Name());
		pstmt.setInt(3, dto.getStd_grade());
		pstmt.setString(4, dto.getClassroom());
		pstmt.setInt(5, dto.getMaximum_Student());
		pstmt.setString(6, dto.getDay_Of_Week());
		pstmt.setTimestamp(7, dto.getStartTime());
		pstmt.setTimestamp(8, dto.getEndTime());

		

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
	public int Update(Established_SubjectDTO dto , String subName ) {
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mydb", "root", "k1651227");
		String sql ="UPDATE Established_Subject SET Est_Subject_Name =? Professor_Name = ? Std_grade =? Classroom = ? Maximum_Student = ?  Day_Of_Week = ? StartTime = ? EndTime = ?  Where Est_Subject_Name=?";
			 
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, dto.getEst_Subject_Name());
		pstmt.setString(2, dto.getProfesssor_Name());
		pstmt.setInt(3, dto.getStd_grade());
		pstmt.setString(4, dto.getClassroom());
		pstmt.setInt(5, dto.getMaximum_Student());
		pstmt.setString(6, dto.getDay_Of_Week());
		pstmt.setTimestamp(7, dto.getStartTime());
		pstmt.setTimestamp(8, dto.getEndTime());
		pstmt.setString(9, dto.getEst_Subject_Name());

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

	
// How SelectPosition work?
// 1.just get the all meber of Member Table
// 2.and build the logic in service layer
//Ex) for(MemberDTO dto : list) if(dto.getPostion.equals("교수") printout => to.String
 	@Override
	public List<Established_SubjectDTO> getAll() {
		Connection conn=null;
		PreparedStatement pstmt =null;
		List<Established_SubjectDTO> list =new ArrayList<Established_SubjectDTO>();
		ResultSet rs =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mydb", "root", "k1651227");
		 
			
		String sql ="SELECT * FROM Established_Subject;"; 
		pstmt =conn.prepareStatement(sql);
		pstmt.executeQuery();
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			Established_SubjectDTO dto=new Established_SubjectDTO();
			
			dto.setEst_Subject_Name(rs.getString("Est_Subject_Name"));
			dto.setProfesssor_Name(rs.getString("Professor_Name"));
			dto.setStd_grade(rs.getInt("Std_grade"));
			dto.setClassroom(rs.getString("Classroom"));
			dto.setClassroom(rs.getString("Classroom"));
			dto.setMaximum_Student(rs.getInt("Maximum_Student"));
			dto.setDay_Of_Week(rs.getString("Day_Of_Week"));
			dto.setStartTime(rs.getTimestamp("StartTime"));
			dto.setStartTime(rs.getTimestamp("EndTime"));

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
	
	public int Delete( String subName ) {
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mydb", "root", "k1651227");
		String sql ="DELETE FROM Established_Subject WHERE Est_Subject_Name = ?";
			 
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, subName);
	

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

