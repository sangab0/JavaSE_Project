package workshop.animal.entity;

public abstract class Animal {
	protected int legs; 
	
	protected Animal(int legs) {
		this.legs = legs;
	}
	
	// abstract method (추상메서드): 일반 자식 클래스에서 구현해야함 
	public abstract void eat();
	
	// concrete method (구체 메서드): 구현부가 있어 자식 클래스에서 그대로 사용 가능 
	public void walk() {
		System.out.println("동물은 " + legs + " 발로 걷는다!");
	}
}
