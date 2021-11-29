package main.java.controller;

import main.java.persistence.dto.Course_RegisterDTO;
import main.java.persistence.dto.MemberDTO;
import main.java.service.Course_RegisterService;
import main.java.service.Established_SubjectService;
import main.java.service.MemberService;
import main.java.service.SubjectService;

public class StudentController {
    //개인정보 및 비밀번호 수정

    private StudentController instance = null;

    private StudentController() {
    }

    public StudentController getInstance() {
        if (instance == null) {
            instance = new StudentController();
        }
        return instance;
    }
//개인정보 및 비밀번호 수정 Member객체를 생성하고 parameter에 넣어야함,
    public void memberUpdate(MemberDTO dto ,String id,String password) {
        MemberService ms =MemberService.getMemberService();

        boolean flag =ms.updateInfo(dto,id,password);
        if(flag ==true){
            System.out.println("Member update is completed");
        }
        else{
            System.out.println("Member update is failed");
        }
    }
//수강신청
    public void courseRegisterSignUp(Course_RegisterDTO dto) {
        Course_RegisterService cs = Course_RegisterService.getCourse_RegisterService();
        boolean flag = cs.Insert(dto);
        if (flag == true) {
            System.out.println("Course registration is completed");
        } else {
            System.out.println("Course registration is failed");
        }
    }
//수강취소

    public void courseRegisterCancel(String subName){
        Course_RegisterService cs = Course_RegisterService.getCourse_RegisterService();
        boolean flag =cs.delete(subName);
        if(flag ==true){
            System.out.println("Course registration is canceled");
        }
        else{
            System.out.println("Member update is not canceled");
        }
    }
//개설 교과목 목록(전학년) 조회
public void establishedAllRead(String subName) {
    Established_SubjectService es = Established_SubjectService.getEstablished_SubjectService();
    es.readDataAll();
}
//선택 교과목 강의 계획서 조회
public void readSubjectSyllabus(String subName){
    SubjectService ss =SubjectService.getSubjectService();
    ss.getOneSyllabus(subName);
}
//본인 시간표 조회
public void readStudentSchedule(String id){
    SubjectService ss =SubjectService.getSubjectService();
    ss.getStudentTimeSchedule(id);
}





}
