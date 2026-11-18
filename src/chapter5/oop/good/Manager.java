package chapter5.oop.good;
/* 관리자 클래스: Employee를 상속받아 관리자의 급여 계산과 부서 정보를 관리한다. */
public class Manager extends Employee {
    // 부서명: Manager에서만 사용하는 필드이며, private이므로 외부에서는 getDepartment()로 조회
	private String deparment;
    
	public Manager (String name, double salary) {
//        this.name = name;
//        this.salary = salary;
        // Employee의 name은 private이므로 자식 클래스에서 this.name = name;으로 직접 접근X
        // salary는 protected이므로 직접 접근할 수 있지만, 이름과 급여를 함께 초기화하도록 부모 생성자를 호출한다.
    	super(name,salary); 
    } 
	
	public Manager (String name, double salary, String deparmant) {
		this(name, salary); // 같은 클래스의 이름과 급여를 받는 생성자를 호출
		this.deparment = deparmant;
	}

	@Override
	public void manageSalary(double rate) {
        salary = salary+ salary*(rate/100);
        salary += 20; // 20만원을 추가로 받는다.
    }
	
	public String getDepartment() {
		return deparment;
	}
}
