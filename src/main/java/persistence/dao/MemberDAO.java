package main.java.persistence.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.persistence.dto.MemberDTO;

interface IMemberDAO{
	public int Insert(MemberDTO member);
	public int Update(String UserId,MemberDAO member);
	public List<MemberDTO> GetAllMember();
	

}




public class MemberDAO implements IMemberDAO {
	
	private static MemberDAO instance;
	
	public static MemberDAO GetMemberDAO() {
		if(instance ==null) {
			instance =new MemberDAO();
		}
		return instance;
		
	}
	
	private MemberDAO() {
	}
	@Override
	public int Insert(MemberDTO member) {
		
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost/school?serverTimezone=UTC&"
	           + "user=root&password=1234");
		  
		String sql =" "; // input the sql here
		pstmt =conn.prepareStatement(sql);
		//need to add setString the number of "?"
		pstmt.setString(0, sql);
		

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
	public int Update(String UserId, MemberDAO member) {
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost/school?serverTimezone=UTC&"
	           + "user=root&password=1234");
		  
		String sql =" "; // input the sql here
		pstmt =conn.prepareStatement(sql);
		//need to add setString the number of "?"
		pstmt.setString(0, sql);
		

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
// 2.
 	@Override
	public List<MemberDTO> GetAllMember() {
		Connection conn=null;
		PreparedStatement pstmt =null;
		List<MemberDTO> list=new ArrayList<MemberDTO>();
		ResultSet rs =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost/school?serverTimezone=UTC&"
	           + "user=root&password=1234");
		 
		String sql =" "; // input the sql here EX) where  position =" 교수 " or "학생"
		pstmt =conn.prepareStatement(sql);
		pstmt.executeQuery();
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			MemberDTO dto=new MemberDTO();
			
			dto.setMemberID(rs.getString("MemberID"));
			dto.setName(rs.getString("Name"));
			dto.setPhoneNumber("PhoneNumber");
			dto.setPosition("Position");
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
