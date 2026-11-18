package chapter5.oop.good;

public class InFlexibleCompanyDemo {
    public static void main(String[] args) {
        // Employee는 abstract(추상) 클래스이므로 직접 객체를 생성할 수 없다.
        // Employee e = new Employee();
    	
        // 자식 객체를 부모 타입의 변수로 참조할 수 있다. (업캐스팅)
        // 실제 객체는 MereClerk이지만, 변수의 타입은 Employee이다.
    	Employee mereClerk1 = new MereClerk("철수", 100); // 가능: MereClerk 객체를 생성하여 부모 타입인 Employee 변수로 참조한다.
        Employee mereClerk2 = new MereClerk("영희", 100);
        
	    // Employee 타입은 부모에 선언된 메서드만 호출할 수 있고, Manager 타입은 자식 고유의 메서드도 호출할 수 있다.
	    // 다형성(Polymorphism): Poly(다양한) + morphism(형태)으로, 같은 부모 타입으로 여러 자식 객체를 다루며 실제 객체에 따라 다르게 동작하는 성질이다.
        Employee manager = new Manager("홍길동", 200, "인사부");  // (1) List list = new ArrayList()처럼 부모 타입으로 자식 객체를 참조한다.
        Manager manager2 = new Manager("둘리", 250, "개발부"); // (2) ArrayList list2 = new ArrayList()처럼 실제 객체와 같은 타입으로 참조한다.
        // (2)는 변수의 선언 타입이 Manager이므로 Employee에서 상속받은 메서드와 Manager 자체에 정의된 메서드까지 호출할 수 있다.
        // 단, (1)도 실제 객체는 Manager이므로 Manager 타입으로 형변환하면 Manager 고유의 메서드를 호출할 수 있다.
        
        
        // Employee 타입: Employee에 정의된 getName()과 getSalary()를 형변환 없이 호출할 수 있다.
    	System.out.println(manager.getName() + " " + manager.getSalary());
    	
    	// Casting: Employee 타입으로 참조하던 manager를 Manager 타입으로 형변환한다. (다운캐스팅)
    	// 실제 객체가 Manager이므로 형변환할 수 있으며, 이후 Manager 고유의 getDepartment()를 호출할 수 있다.
    	Manager m = (Manager) manager;
    	m.getDepartment();
    	
    	// Manager 타입: 상속받은 getName(), getSalary()와 Manager 고유의 getDepartment()를 모두 호출할 수 있다.
    	System.out.println(manager2.getName() + " " + manager2.getSalary() + " " + manager2.getDepartment());
    	
//        MereClerk mereClerk1 = new MereClerk("철수", 100);
//        MereClerk mereClerk2 = new MereClerk("영희", 100);
//        Manager manager = new Manager("홍길동", 200);

    	// Employee 타입 배열 선언: 공통 부모인 Employee 타입의 배열에 서로 다른 자식 객체를 함께 저장한다.
    	// 이를 Heterogeneous Collection(이종 컬렉션)이라고 하며, 여기서는 MereClerk과 Manager 객체를 하나의 배열로 다룬다.
    	Employee[] emps = new Employee[3];
    	emps[0] = new MereClerk("철수", 100);
    	emps[1] = new MereClerk("영희", 100);
    	emps[2] = new Manager("둘리", 250, "개발부");
    	
    	for (Employee employee : emps) {
    		System.out.println("현재 월급입니다.");
    		if (employee instanceof Manager) {
    			System.out.print("부서명 = " + ((Manager)employee).getDepartment() + "관리자"); // employee를 Manager 타입으로 형변환  				
			}
    		System.out.println(employee.getName() + "의 현재 월급은 " + employee.getSalary() + " 만원 입니다.");
    		System.out.println("");
    		
    		System.out.println("올린 후의 월급입니다.");
    		mereClerk1.manageSalary(10);
    		System.out.println(employee.getName() + "의 현재 월급은 " + employee.getSalary() + " 만원 입니다.");
		}
   }
}

