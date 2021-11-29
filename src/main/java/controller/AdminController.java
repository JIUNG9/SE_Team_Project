package main.java.controller;

import main.java.persistence.dto.MemberDTO;
import main.java.persistence.dto.SubjectDTO;
import main.java.service.Course_RegisterService;
import main.java.service.Established_SubjectService;
import main.java.service.MemberService;
import main.java.service.SubjectService;

import java.sql.Date;

public class AdminController {
    //Singleton pattern
    private AdminController instance = null;

    private AdminController() {
    }

    public AdminController getInstance() {
        if (instance == null) {
            instance = new AdminController();
        }
        return instance;
    }

    //교수 학생 계정 생성
    public void MakeProfessorAndStudent(String id,
                                           String position,
                                           String name,
                                           String phoneNumber,
                                           String password) {
        MemberService ms = MemberService.getMemberService();
        MemberDTO dto = new MemberDTO(name, id, password, position, phoneNumber);
        boolean flag = ms.insert(dto);

        if(flag ==true){
            System.out.println("Member creation is completed");
        }
        else{
            System.out.println("Member creation is failed");
        }
    }

    //교과목 생성
    public void subjectCreate(int subjectId, String subjectName, int subjectGrade, String professor, Date startTime, Date endTime, String syllabus, Date syllabusDate, String dayOfWeek) {

        SubjectService ss = SubjectService.getSubjectService();
        SubjectDTO dto = new SubjectDTO(subjectId, subjectName, subjectGrade, professor, startTime, endTime, syllabus, syllabusDate, dayOfWeek);
        boolean flag = ss.insert(dto);
        if(flag ==true){
            System.out.println("Subject creation is completed");
        }
        else{
            System.out.println("Subject creation is failed");
        }
    }

    //교과목 수정
    //dto를 생성하여서 업데이트해야함
    public void subjectUpdate(SubjectDTO newDto, String subName) {
        SubjectService ss = SubjectService.getSubjectService();
        boolean flag = ss.Update(newDto, subName);
        if(flag ==true){
            System.out.println("Subject update is completed");
        }
        else{
            System.out.println("Subject update is failed");
        }

    }
    //삭제
    public void subjectDelete(String subName) {
        SubjectService ss = SubjectService.getSubjectService();
        boolean flag = ss.Delete(subName);
        if(flag ==true){
            System.out.println("Subject deletion is completed");
        }
        else{
            System.out.println("Subject deletion is failed");
        }

    }

    //강의 계획서 입력기간 설정

    public void settingSyllabusDate(Date D,String subName){
        SubjectService ss = SubjectService.getSubjectService();
        boolean flag =ss.setSyllabus_Date(D,subName);
        if(flag ==true){
            System.out.println("Subject Syllabus setting is completed");
        }
        else{
            System.out.println("Subject Syllabus setting is failed");
        }
    }

    //학년별 수강신청 기간 설정

    public void setCourseRegDate(Date d,int grade){
        Course_RegisterService cs = Course_RegisterService.getCourse_RegisterService();
        boolean flag =cs.setRegDateByGrade(grade,d);
        if(flag ==true){
            System.out.println("The setting of course register schedule is completed");
        }
        else{
            System.out.println("The setting of course register schedule is failed");
        }
    }

    // 교수/학생 정보 조회

    public void readStudentOrProfessor(String position){
        MemberService ms = MemberService.getMemberService();
        if(position.equals("교수")) {
            ms.readProfessor();
        }
        else{
            ms.readStudent();

        }
    }

    //개설 교과목 정보 조회
    public void readEstablishedSubject(String subName){
        Established_SubjectService es = Established_SubjectService.getEstablished_SubjectService();
        es.readOne(subName);
    }


    }




