package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	private String studentId; // 학번 
	private String name; // 이름 
	private String major; // 전공 
	private int grade; // 학년 
	
	public Student() {
		
	}
	
	public Student(int grade) throws InvalidGradeException {
	    setGrade(grade);
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) throws InvalidGradeException {
		if(grade < 1 || grade > 4) {
			throw new InvalidGradeException("학년은 1~4 사이의 값이어야 합니다.");
		}
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", major=" + major + ", grade=" + grade + "]";
	}
}
