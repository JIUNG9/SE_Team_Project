package main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import main.java.persistence.dto.Established_SubjectDTO;

public interface EstablishedMapper {

	//need to revise all of these query 
	
	@Select("select * from Established_Subject")

	public List<Established_SubjectDTO> selectDataAll();
	
	@Select("select * from Established_Subject")

	public List<Established_SubjectDTO> selectBygrade();

	@Select("select * from Established_Subject")
	
	public List<Established_SubjectDTO> selectByprof();

	
	@Select("select * from Established_Subject where id=#{id}")

	public Established_SubjectDTO selectbyId(int arg);


//If the insertData return 0 , or null need to change the return type
	@Insert("insert into Established_Subject values(#{id}, #{name}, #{pass}, now())")

	public int insertData(Established_SubjectDTO dto);

	

	@Update("update membertab set name=#{name}, pass=#{pass} where id=#{id}")

	public int updateData(Established_SubjectDTO dto);
	
	

}
