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
	int UpdatePhonNum(String UserId, MemberDTO member,String PhoneNum);
	int UpdateStudentName(String UserId, MemberDTO member,String Name);
	public  List<MemberDTO> GetAllMember();
	

}




public class MemberDAO implements IMemberDAO {
	
	private static MemberDAO instance;
	
	//this method make can get resource or make the resoure and return it
	public static MemberDAO GetMemberDAO() {
		if(instance ==null) {
			instance =new MemberDAO();
		}
		return instance;
		
	}
	//private constructor 
	private MemberDAO() {
	}
	@Override
	public int Insert(MemberDTO member) {
		
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mydb", "root", "k1651227");
		String sql =" INSERT INTO Member VALUES(?, ?, ?, ?);";
			
		pstmt =conn.prepareStatement(sql);
		//need to add setString the number of "?"
		pstmt.setString(1, member.getMemberID());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getPosition());
		pstmt.setString(4, member.getPhoneNumber());

		

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
	public int UpdatePhonNum(String UserId, MemberDTO member,String PhonNumber) {
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mydb", "root", "k1651227");
		String sql ="UPDATE Member SET PhoneNumber =? Where MemberID=?";
			 
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1,PhonNumber);
		pstmt.setString(2, UserId);
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
	public int UpdateStudentName(String UserId, MemberDTO member,String name) {
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mydb", "root", "k1651227");
		  
		String sql ="UPDATE Member SET MemberName=? WHERE MemberID=?;";
				
				
		pstmt =conn.prepareStatement(sql);
		//need to add setString the number of "?"
		pstmt.setString(1, name);
		pstmt.setString(2, UserId);

		

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
	public List<MemberDTO> GetAllMember() {
		Connection conn=null;
		PreparedStatement pstmt =null;
		List<MemberDTO> list =new ArrayList<MemberDTO>();
		ResultSet rs =null;
	try {	
		conn = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mydb", "root", "k1651227");
		 
		String sql ="SELECT * FROM Member;"; 
		pstmt =conn.prepareStatement(sql);
		pstmt.executeQuery();
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			MemberDTO dto=new MemberDTO();
			
			dto.setMemberID(rs.getString("MemberID"));
			dto.setName(rs.getString("MemberName"));
			dto.setPhoneNumber(rs.getString("PhoneNumber"));
			dto.setPosition(rs.getString("Position"));
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
