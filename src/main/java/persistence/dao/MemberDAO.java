package main.java.persistence.dao;


import main.java.ConnecctionPool.PooledDataSource;
import main.java.persistence.dto.MemberDTO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

interface IMemberDAO{
	public int insert(MemberDTO member);
	int delete(String Name,String Position);
	int update(MemberDTO member,String id);
	public  List<MemberDTO> getAllMember();
	public MemberDTO getLoginSession(String id, String password);
	public MemberDTO getOne(String id, String password);
	public List<MemberDTO> getStudentFromCourseReg(String subName);
}




public class MemberDAO implements IMemberDAO {
	
	private static MemberDAO instance;
	private String id;
	private String password;

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
	public int insert(MemberDTO member) {
		
		Connection conn=null;
		PreparedStatement pstmt =null;
	try {
		DataSource ds = PooledDataSource.getDataSource();

		conn = ds.getConnection();
		String sql =" INSERT MEMBER VALUE (?,?,?,?,?) ";
		pstmt =conn.prepareStatement(sql);
		//need to add setString the number of "?"
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getPosition());
		pstmt.setString(4, member.getPhoneNumber());
		pstmt.setString(5, member.getPassword());



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
	public int delete(String id, String password) {
		Connection conn=null;
		PreparedStatement pstmt =null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();

			String sql =" DELETE Member Where MemberID = ? AND Password = ?  ;";

			pstmt =conn.prepareStatement(sql);
			//need to add setString the number of "?"
			pstmt.setString(1, id);
			pstmt.setString(2, password);




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
	public int update(MemberDTO member ,String Id) {
		Connection conn=null;
		PreparedStatement pstmt =null;
		try {
			DataSource ds = PooledDataSource.getDataSource();

			conn = ds.getConnection();

			String sql =" Update Member SET MemberID =? MemberName =? Position =? PhoneNumber =? Password =? WHERE MemberID =?";

			pstmt =conn.prepareStatement(sql);
			//need to add setString the number of "?"
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPosition());
			pstmt.setString(4, member.getPhoneNumber());
			pstmt.setString(5, member.getPassword());
			pstmt.setString(6, Id);



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
	public List<MemberDTO> getAllMember() {
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
			
			dto.setMemberId(rs.getString("MemberID"));
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

	@Override
	public MemberDTO getLoginSession(String id, String password) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		MemberDTO dto = null;
		ResultSet rs = null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();


			String sql = "SELECT * FROM Member WHERE MemberID = ? Password = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				dto=new MemberDTO();
				dto.setMemberId(rs.getString("MemberID"));
				dto.setName(rs.getString("MemberName"));
				dto.setPhoneNumber(rs.getString("PhoneNumber"));
				dto.setPosition(rs.getString("Position"));
				dto.setPassword(rs.getString("Password"));





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

	@Override
	public MemberDTO getOne(String Position, String Name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		MemberDTO dto = null;
		ResultSet rs = null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();


			String sql = "SELECT * FROM Member WHERE Position = ? MemberName = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				dto=new MemberDTO();
				dto.setMemberId(rs.getString("MemberID"));
				dto.setName(rs.getString("MemberName"));
				dto.setPhoneNumber(rs.getString("PhoneNumber"));
				dto.setPosition(rs.getString("Position"));
				dto.setPassword(rs.getString("Password"));





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

	@Override
	//use the subid need to use getSubjectIdBySubName method in SubjectService
	public List<MemberDTO> getStudentFromCourseReg(String subId) {
			//first get the subjectId by sung subName

		Connection conn=null;
		PreparedStatement pstmt =null;
		List<MemberDTO> list =new ArrayList<MemberDTO>();
		ResultSet rs =null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();

			String sql =" SELECT Member.MemberName FROM Course_Register,Member,Subject where Member.MemberID=Course_Register.MemberID AND Subject.Reg_number = ? AND Course_Register.Reg_number = ?;";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, subId);
			pstmt.setString(2, subId);
			pstmt.executeQuery();
			rs=pstmt.executeQuery();


			while(rs.next())
			{
				MemberDTO dto=new MemberDTO();

				dto.setMemberId(rs.getString("MemberID"));
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
