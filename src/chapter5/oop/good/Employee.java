package chapter5.oop.good;

public abstract class Employee {

	// abstract(추상) 키워드로 선언한 클래스는 스스로 객체를 생성할 수 없다.
	// Employee e = new Employee(); → 추상 클래스의 생성자를 직접 호출하여 객체를 생성하는 것은 불가능
	// Employee e = new Manager("홍길동", 200); → 자식 객체를 생성하여 부모 타입으로 참조하는 것은 가능
	// 이 경우 e.getName()처럼 부모 클래스(Employee)에 정의된 메서드도 호출할 수 있다.
	
	private String name;
	protected double salary;

	public Employee() {
		super();
	}

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
	    return this.name;
	}

	public double getSalary() {
	    return this.salary;
	}
	
	public abstract void manageSalary(double rate);
    // abstract(추상) 메서드는 구현부인 중괄호 {} 없이 선언하며,
    // 추상 클래스가 아닌 자식 클래스는 반드시 재정의(오버라이딩)하여 구체적인 동작을 구현해야 한다.
    // 따라서 Manager 클래스에서 아래와 같이 manageSalary(double rate)를 구현하지 않으면 컴파일 오류가 발생한다.

	// @Override
	// public void manageSalary(double rate) {
	//	     salary = salary + salary * (rate / 100);
	//	     salary += 20; // 20만원을 추가로 받는다.
	// }
}