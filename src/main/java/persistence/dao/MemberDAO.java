package main.java.persistence.dao;


import main.java.ConnecctionPool.PooledDataSource;
import main.java.persistence.dto.MemberDTO;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

interface IMemberDAO{
	public int Insert(MemberDTO member);
	int Delete(String Name,String Position);
	int Update(MemberDTO member, String name, String position);
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
		DataSource ds = PooledDataSource.getDataSource();

		conn = ds.getConnection();
		String sql =" INSERT MEMBER VALUE (?,?,?) ";
		pstmt =conn.prepareStatement(sql);
		//need to add setString the number of "?"
		pstmt.setString(1, member.getName());
		pstmt.setString(2, member.getPosition());
		pstmt.setString(3, member.getPhoneNumber());

		

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
	public int Delete(String Name, String Position) {
		Connection conn=null;
		PreparedStatement pstmt =null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();

			String sql =" DELETE Member Where MemberName = ? AND Position = ? ;";

			pstmt =conn.prepareStatement(sql);
			//need to add setString the number of "?"
			pstmt.setString(1, Name);
			pstmt.setString(2, Position);




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
	public int Update(MemberDTO member, String name, String position) {
		Connection conn=null;
		PreparedStatement pstmt =null;
		try {
			DataSource ds = PooledDataSource.getDataSource();

			conn = ds.getConnection();

			String sql =" Update Member SET MemberName =? Position =? PhoneNumber =?  VALUES(?, ?, ?, ?);";

			pstmt =conn.prepareStatement(sql);
			//need to add setString the number of "?"
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
		DataSource ds = PooledDataSource.getDataSource();
		conn = ds.getConnection();

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
