package main.java.controller;

import main.java.persistence.dto.MemberDTO;
import main.java.persistence.dto.SubjectDTO;
import main.java.service.MemberService;
import main.java.service.SubjectService;

public class ProfessorController {

    private ProfessorController instance = null;

    private ProfessorController() {
    }

    public ProfessorController getInstance() {
        if (instance == null) {
            instance = new ProfessorController();
        }
        return instance;
    }
    //개인정보 및 비밀번호 수정 Member객체를 생성하고 parameter에 넣어야함,
    public boolean memberUpdate(MemberDTO dto , String id, String password) {
        MemberService ms =MemberService.getMemberService();

        boolean flag =ms.updateInfo(dto,id,password);
        return flag;
    }
    //강의 계획서 입력/수정 => SubjectName으로 해당 객체를 읽은 뒤에 강의계획서를 업데이트 하는 방식
    public void insertSyllasbus(String Syllabus,String subName){
        SubjectService ss =SubjectService.getSubjectService();
        SubjectDTO dto =null;
        dto =ss.getSubBySubName(subName);
        if(dto!=null){
            dto.setSyllabus(Syllabus);
            System.out.println("Insert/Update is completed");
        }
        System.out.println("Insert/Update is failed");
    }

  //교과목 목록 조회
    public void readAllSubject(){
        SubjectService ss =SubjectService.getSubjectService();
        ss.ReadDataAll();
    }
//교과목 강의계획서 조회
    public void findSyllabus(String subName){
        SubjectService ss =SubjectService.getSubjectService();
        ss.getOneSyllabus(subName);
    }

//교과목 수강 신청 학생 목록 조회
    public void getStudentFromCourseRegister(String id){

        MemberService ms =MemberService.getMemberService();
        ms.readStudentFromCourseReg(id);

    }
//교과목 시간표 조회
    public void getScheduleOfSubject(String subName){
        SubjectService ss =SubjectService.getSubjectService();
        ss.getSubjectSchedule(subName);
    }

}
