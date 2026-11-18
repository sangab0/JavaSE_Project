package chapter5.oop.good;
/* 평사원 클래스: Employee를 상속받아 평사원의 급여 계산을 구현한다. */
public class MereClerk extends Employee {

    public MereClerk (String name, double salary) {
//      this.name = name;
//      this.salary = salary;
        // Employee의 name은 private이므로 자식 클래스에서 this.name = name;으로 직접 접근X
        // salary는 protected이므로 직접 접근할 수 있지만, 이름과 급여를 함께 초기화하도록 부모 생성자를 호출한다.
	  	super(name,salary); 
    }
    
    @Override
    public void manageSalary(double rate) {
        salary = salary+ salary*(rate/100);
    }
}