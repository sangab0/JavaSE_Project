package workshop.animal.entity;

public class Cat extends Animal implements Pet {
	private String name;
	
	// Implicit super constructor Animal() is undefined. Must explicitly invoke another constructor 오류 발생
	// 부모에 기본 생성자 Animal()이 없으므로 super(4)로 다른 생성자를 호출해야 한다.
	public Cat(String name) {
		super(4); // 부모 생성자를 호출하여 다리 수를 4로 초기화
		this.name = name;
	}
	
	public Cat() {
		this(""); // 이름을 지정하지 않으면 빈 문자열로 설정하고, Cat(String name)의 초기화 코드를 재사용한다.
		// 호출된 생성자에서 super(4)가 실행되어 다리 수도 초기화됨
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println("고양이는 장화를 신고 놀아요!");
	}

	@Override
	public void eat() {
		System.out.println("고양이는 생선을 먹어요!");
	}
}
