package main.java.service;

import java.util.ArrayList;
import java.util.List;

import main.java.persistence.dao.MemberDAO;
import main.java.persistence.dto.Course_RegisterDTO;
import main.java.persistence.dto.MemberDTO;
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
	
	public boolean Insert(MemberDTO dto) {
		
		int res = MemberDAO.GetMemberDAO().Insert(dto); 
		if(res>0) return true;
		return false;
		
		
	}
	
	public boolean UpdateProPhoneNum(String MemberId ,MemberDTO dto,String PhonNumb) {
		int res = MemberDAO.GetMemberDAO().UpdatePhonNum(MemberId,dto,PhonNumb); 
		if(res>0) return true;
		return false;
		
	}
	
	public boolean UpdateStName(String MemberId ,MemberDTO dto,String Name) {
		int res = MemberDAO.GetMemberDAO().UpdateStudentName(MemberId,dto,Name); 
		if(res>0) return true;
		return false;
		
	}
	
	public void ReadProfessor()
	{
		List<MemberDTO> list = new ArrayList<MemberDTO>();

		list = MemberDAO.GetMemberDAO().GetAllMember();
		String P ="Professor";
		for(MemberDTO m:list) {
			if(m.getPosition().equals(P) ) {
				System.out.println(m.toString());
			}
		}
		
	}
	public void ReadStudent()
	{
		List<MemberDTO> list = new ArrayList<MemberDTO>();

		list = MemberDAO.GetMemberDAO().GetAllMember();
		String S ="Student";

		for(MemberDTO m:list) {
			if(m.getPosition().equals(S)) {
				System.out.println(m.toString());
			}
		}
		
	}
	
	
}
