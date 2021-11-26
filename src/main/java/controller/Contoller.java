package main.java.controller;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import main.java.persistence.dto.Course_RegisterDTO;
import main.java.persistence.dto.Established_SubjectDTO;
import main.java.persistence.dto.MemberDTO;
import main.java.persistence.dto.SubjectDTO;
import main.java.service.Course_RegisterService;
import main.java.service.Established_SubjectService;
import main.java.service.MemberService;
import main.java.service.SubjectService;



public class Contoller {
	
	private static Contoller instance;
	
	 private Contoller(){
	      /*Private Constructor will prevent 
	       * the instantiation of this class directly*/
	   }
	 
	public static Contoller getController(){ 
		
		if(instance ==null)
			instance =new Contoller();
		return instance;

	}

	public void testMember(){
		
	MemberDTO M1 = new MemberDTO("S1","구지웅","Student","1111");
	MemberDTO M2 =new MemberDTO("P1","김성렬","Professor","2222");
	List<Boolean> list = new ArrayList<Boolean>();
	
	boolean insert1=MemberService.getMemberService().Insert(M1);
	list.add(insert1);
	boolean insert2=MemberService.getMemberService().Insert(M2);
	list.add(insert2);
	boolean update1=MemberService.getMemberService().UpdateProPhoneNum("P1",M2,"3333");
	list.add(update1);
	boolean update2=MemberService.getMemberService().UpdateStName("S1",M1,"이우찬");
	list.add(update2);

	for(Boolean b : list) {
		if(b==false) {
			System.out.println(b);
		}
	}
	
	MemberService.getMemberService().ReadStudent();
	MemberService.getMemberService().ReadProfessor();

	
	}
	
	public void testCourse_Register() {
		  long millis=System.currentTimeMillis();  
	      java.sql.Date date=new java.sql.Date(millis);  
		Course_RegisterDTO C1 =new Course_RegisterDTO(1,"융합프로젝트","20191318","이우찬",date,false);
		List<Boolean> list = new ArrayList<Boolean>();
		boolean insert1=Course_RegisterService.getMemberService().Insert(C1);
		list.add(insert1);
		Course_RegisterService.getMemberService().Read();
	//Course_RegisterService.getMemberService().delete(1);

		
	}

	public void testEstablished() throws ParseException {
		
		 String str="2015-03-31";  
		 Date d1=Date.valueOf(str);//converting string into sql date  
		 String str2="2015-03-31";  
		 Date d2=Date.valueOf(str2);//converting string into sql date 

		

		//Established_SubjectDTO dto =new Established_SubjectDTO(1,"융합프로젝트","김성렬",2,"디지털관301호",3,"2일",d1,d2);
		Established_SubjectService.getEstablished_SubjectService().insert(dto);
		
		Established_SubjectService.getEstablished_SubjectService().UpdateMaxNumber(dto,1,4);
		Established_SubjectService.getEstablished_SubjectService().UpdatePlace(dto,1,"강당");

		Established_SubjectService.getEstablished_SubjectService().ReadProfessor("김성렬");
		Established_SubjectService.getEstablished_SubjectService().ReadStudent(1);
		Established_SubjectService.getEstablished_SubjectService().ReadStWithProf("김성렬",1);
		Established_SubjectService.getEstablished_SubjectService().ReadDataAll();

		
		
		
		
	}

	public void testSubject()
	{
		
		SubjectDTO dto1 =new SubjectDTO(1,"융프",2);
		SubjectDTO dto2=new SubjectDTO(1,"빅데이터",3);
		SubjectService.getSubjectService().insert(dto1);
		SubjectService.getSubjectService().insert(dto2);
		SubjectService.getSubjectService().Update(dto2,"디자인패턴");
		SubjectService.getSubjectService().ReadDataAll();
		//SubjectService.getSubjectService().ReadByGrade(2);
	
		
	}
	
	
	
	public static void main(String[] args) throws ParseException {
		
		Contoller C =new Contoller();
		//C.testMember();
		//C.testCourse_Register();
		C.testEstablished();
	}
}
