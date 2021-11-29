package main.java.persistence.dao;

import main.java.ConnecctionPool.PooledDataSource;
import main.java.persistence.dto.Course_RegisterDTO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


interface ICourseRegisterDAO{
	public int insert(Course_RegisterDTO Course);
	public List<Course_RegisterDTO> getAllSubject();
	public Course_RegisterDTO getOneSubject(String subName);
	public int delete(String subName);
	public int update(Course_RegisterDTO Course,String subName);


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
	private Course_RegisterDAO() {
	}

	//private constructor

	
	@Override
	public int insert(Course_RegisterDTO Course) {
		Connection conn=null;

		PreparedStatement pstmt =null;
	try {
		DataSource ds = PooledDataSource.getDataSource();
		conn = ds.getConnection();
		  
		String sql ="INSERT INTO Course_Register VALUES( ?, ?, ?, ?,?,?,?,?);";

		pstmt =conn.prepareStatement(sql);
		
		

		pstmt.setString(1, Course.getRegSubjectName());
		pstmt.setString(2, Course.getRegStdid());
		pstmt.setString(3, Course.getRegStdName());
		pstmt.setDate(4,  Course.getRegDate());
		pstmt.setBoolean(5,  Course.getSignClassAble());
		pstmt.setInt(6, Course.getRegGrade());
		pstmt.setString(5,  Course.getMemberID());
		pstmt.setInt(6, Course.getSubject_Id());


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
	public int delete(String subName) {
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {
		DataSource ds = PooledDataSource.getDataSource();
		conn = ds.getConnection();
		  
		String sql =" DELETE  FROM Course_Register WHERE Reg_subName=?"; // input the sql here
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, subName);
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
	public int update(Course_RegisterDTO dto, String subName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();

			String sql = "UPDATE Course_Register SET  Reg_SubName =?  Reg_StdId = ? Reg_StdName =? Reg_Date =? SignClass_Able =? Reg_grade =?  MemberID = ? Subject_Id = ? Where Reg_SubName=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getRegSubjectName());
			pstmt.setString(2, dto.getRegStdid());
			pstmt.setString(3, dto.getRegStdName());
			pstmt.setDate(4, dto.getRegDate());
			pstmt.setBoolean(5, dto.getSignClassAble());
			pstmt.setInt(6, dto.getRegGrade());
			pstmt.setString(7,  dto.getMemberID());
			pstmt.setInt(8, dto.getSubject_Id());
			pstmt.setString(9, dto.getRegSubjectName());


			int res = pstmt.executeUpdate();
			return res;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null) {
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
	public List<Course_RegisterDTO> getAllSubject() {

		Connection conn=null;
		PreparedStatement pstmt =null;
		List<Course_RegisterDTO> list =new ArrayList<Course_RegisterDTO>();
		ResultSet rs =null;
	try {
		DataSource ds = PooledDataSource.getDataSource();
		conn = ds.getConnection();
		String sql ="Select * From Course_Register;"; 
		pstmt =conn.prepareStatement(sql);
		pstmt.executeQuery();
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			Course_RegisterDTO dto=new Course_RegisterDTO();


//			dto.setReg_Date(rs.getDate("Reg_Date"));
			dto.setRegNumber(rs.getInt("Reg_number"));
			dto.setRegStdName(rs.getString("Reg_StdName"));
			dto.setSignClassAble(rs.getBoolean("SignClass_Able"));
			dto.setRegSubjectName(rs.getString("Reg_SubName"));
			dto.setRegStdid(rs.getString("Reg_Stdid"));
			dto.setRegGrade(rs.getInt("Reg_Grade"));
			dto.setMemberID(rs.getString("MemberID"));
			dto.setSubject_Id(rs.getInt("Subject_Id"));

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
	public Course_RegisterDTO getOneSubject( String subName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Course_RegisterDTO dto = new Course_RegisterDTO();
		ResultSet rs = null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();
			;

			String sql = "SELECT * FROM Subject WHERE Reg_Name=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subName);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				dto.setRegSubjectName(rs.getString("Reg_SubName"));
				dto.setRegStdid(rs.getString("Reg_StdId"));
				dto.setRegStdName(rs.getString("Reg_StdName"));
				dto.setRegDate(rs.getDate("Reg_Date"));
				dto.setSignClassAble(rs.getBoolean("SignClass_Able"));
				dto.setRegGrade(rs.getInt("Reg_Grade"));
				dto.setMemberID(rs.getString("MemberID"));
				dto.setSubject_Id(rs.getInt("Subject_Id"));



			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


		}
		return dto;
	}
	}

