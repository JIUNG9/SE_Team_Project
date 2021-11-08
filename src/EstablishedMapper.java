

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import main.java.persistence.dto.Established_SubjectDTO;


public interface EstablishedMapper {

		@Select("select * from Established_Subject")

	public List<Established_SubjectDTO> selectDataAll();

	

	@Select("select * from Established_Subject where id=#{id}")

	public Established_SubjectDTO selectData(String arg);



	@Insert("insert into Established_Subject values(#{id}, #{name}, #{pass}, now())")

	public int insertData(Established_SubjectDTO dto);

	

	@Update("update membertab set name=#{name}, pass=#{pass} where id=#{id}")

	public int updateData(Established_SubjectDTO dto);

	

	@Delete("delete from membertab where id=#{id}")

	public int deleteData(String arg);

}



}
