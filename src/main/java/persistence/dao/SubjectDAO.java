package main.java.persistence.dao;

import main.java.ConnecctionPool.PooledDataSource;
import main.java.persistence.dto.SubjectDTO;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

interface Subject{
	
	 int insert(SubjectDTO subject);
	 int update(SubjectDTO subject,String subjectName);
	 int delete(String subName);
	 SubjectDTO selectData(String subName);
	public List<SubjectDTO> readAll();
	public  List<SubjectDTO> getStudnetSchedule(String memberId);

}

public  class SubjectDAO implements Subject {

	private static SubjectDAO instance;

	//this method make can get resource or make the resoure and return it
	public static SubjectDAO getSubjectDAO() {
		if (instance == null) {
			instance = new SubjectDAO();
		}
		return instance;

	}

	//private constructor
	private SubjectDAO() {
	}

	@Override
	public int insert(SubjectDTO sub) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();
			String sql = " INSERT INTO Subject VALUES(?, ?,?,?,?,?,?,?,?);";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, sub.getSubjectName());
			pstmt.setInt(2, sub.getSubjectGrade());
			pstmt.setString(3, sub.getProfessor());
			pstmt.setDate(4, sub.getStartTime());
			pstmt.setDate(5, sub.getEndTime());
			pstmt.setString(6, sub.getSyllabus());
			pstmt.setDate(7, sub.getSyllabusDate());
			pstmt.setString(7, sub.getDayOfWeek());


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
	public int update(SubjectDTO dto, String subName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();
			;
			String sql = "UPDATE Subject SET  Subject_Name =? Subject_grade = ? Professor =? StartTime =? EndTime =? Syllabus =? SyllasbusDate =?   Where Subject_Name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubjectName());
			pstmt.setInt(2, dto.getSubjectGrade());
			pstmt.setString(3, dto.getProfessor());
			pstmt.setDate(4, dto.getStartTime());
			pstmt.setDate(5, dto.getEndTime());
			pstmt.setString(6, dto.getSyllabus());
			pstmt.setDate(7, dto.getSyllabusDate());
			pstmt.setString(8, dto.getSubjectName());
			pstmt.setString(8, dto.getDayOfWeek());

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
	public List<SubjectDTO> readAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<SubjectDTO> list = new ArrayList<SubjectDTO>();
		ResultSet rs = null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();
			;

			String sql = "SELECT * FROM Subject;";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SubjectDTO dto = new SubjectDTO();

				dto.setSubjectName(rs.getString("Subject_Name"));
				dto.setSubjectGrade(rs.getInt("Subject_grade"));
				dto.setProfessor(rs.getString("Professor"));
				dto.setStartTime(rs.getDate("StartTime"));
				dto.setEndTime(rs.getDate("EndTime"));
				dto.setSyllabus(rs.getString("Syllabus"));
				dto.setSyllabusDate(rs.getDate("SyllabusDate"));
				dto.setDayOfWeek(rs.getString("DayOfWeek"));

				list.add(dto);

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
		return list;
	}

	@Override
	public List<SubjectDTO> getStudnetSchedule(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<SubjectDTO> list = new ArrayList<SubjectDTO>();
		ResultSet rs = null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();


			String sql = "select * From Subject WHERE Reg_number IN( SELECT Reg_number FROM Course_Register where ? IN(SELECT ? FROM Member));";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberId);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				SubjectDTO dto =new SubjectDTO() ;
				dto.setSubjectName(rs.getString("Subject_Name"));
				dto.setSubjectGrade(rs.getInt("Subject_grade"));
				dto.setProfessor(rs.getString("Professor"));
				dto.setStartTime(rs.getDate("StartTime"));
				dto.setEndTime(rs.getDate("EndTime"));
				dto.setSyllabus(rs.getString("Syllabus"));
				dto.setSyllabusDate(rs.getDate("SyllabusDate"));
				dto.setDayOfWeek(rs.getString("DayOfWeek"));
				list.add(dto);

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
		return list;
	}



	@Override
	public int delete(String subName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();
			String sql = "DELETE FROM Subject Where Subject_Name =?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subName);


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
	public SubjectDTO selectData(String subName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		SubjectDTO dto = new SubjectDTO();
		ResultSet rs = null;
		try {
			DataSource ds = PooledDataSource.getDataSource();
			conn = ds.getConnection();
			;

			String sql = "SELECT * FROM Subject WHERE Subject_Name=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subName);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				dto.setSubjectName(rs.getString("Subject_Name"));
				dto.setSubjectGrade(rs.getInt("Subject_grade"));
				dto.setProfessor(rs.getString("Professor"));
				dto.setStartTime(rs.getDate("StartTime"));
				dto.setEndTime(rs.getDate("EndTime"));
				dto.setSyllabus(rs.getString("Syllabus"));
				dto.setSyllabusDate(rs.getDate("SyllabusDate"));
				dto.setDayOfWeek(rs.getString("DayOfWeek"));


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


	

