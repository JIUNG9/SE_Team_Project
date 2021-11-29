package main.java.service;

import main.java.persistence.dao.MemberDAO;
import main.java.persistence.dto.MemberDTO;

import java.util.List;
public class MemberService {

	private static MemberService instance;
	
	 private MemberService(){
	      /*Private Constructor will prevent 
	       * the instantiation of this class directly*/
	   }
	 
	public static MemberService getMemberService(){ {
		
		if(instance ==null)
			instance =new MemberService();
		
	}
	return instance;
}


	public boolean login(String id, String password){
		MemberDTO dto =null;
		boolean flag =false;
		dto = MemberDAO.GetMemberDAO().getOne(id,password);
		if(dto!=null){
			flag =true;
		}
		return flag;
	}

	
	public boolean insert(MemberDTO dto) {
		
		int res = MemberDAO.GetMemberDAO().insert(dto);
		if(res>0) return true;
		return false;
		
		
	}

	public boolean updateInfo(MemberDTO newDto ,String currId, String currPassword)  {
		 boolean flag= false;
		MemberDTO dto =null;
		dto = MemberDAO.GetMemberDAO().getLoginSession(currId,currPassword);
		if(dto!=null){
			MemberDAO.GetMemberDAO().update(newDto ,currId);
			flag =true;
		}
return flag;
	}




	
	public void readProfessor()
	{
		List<MemberDTO> list = null;

		list = MemberDAO.GetMemberDAO().getAllMember();
		String P ="Professor";
		if(list!=null) {
			for (MemberDTO m : list) {
				if (m.getPosition().equals(P)) {
					System.out.println(m.getName());
					System.out.println(m.getPhoneNumber());

				}
			}
		}
		else{
			System.out.println("there is no matched data");
		}
		
	}
	public void readStudent()
	{
		List<MemberDTO> list =null;

		list = MemberDAO.GetMemberDAO().getAllMember();
		String S ="Student";
if(list!=null) {
	for (MemberDTO m : list) {
		if (m.getPosition().equals(S)) {
			System.out.println(m.getName());
			System.out.println(m.getPhoneNumber());
		}
	}
}
else{
	System.out.println("there is no matched data");
}
		
	}

	public void readStudentFromCourseReg(String subId){
		List<MemberDTO> list = null;
		String S ="Student";
		list = MemberDAO.GetMemberDAO().getStudentFromCourseReg(subId);
		if(list!=null){
			for (MemberDTO m : list) {
				if (m.getPosition().equals(S)) {
					System.out.println(m.getName());
				}
			}
		}
else{
			System.out.println("there is no matched data");
		}

	}

	
	
}
