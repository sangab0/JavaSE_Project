package workshop.animal.entity;

public class Fish extends Animal implements Pet {
	private String name;

	public Fish() {
		super(0); // 부모생성자 호출
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
		System.out.println("물고기는 어항에서 놀아요!");
	}

	@Override
	public void eat() {
		System.out.println("물고기는 플랑크톤을 먹어요!");
	}
	
	// 부모와 다르니까 오버라이딩함
	// 부모의 걷는 동작을 물고기의 헤엄치는 동작으로 재정의!
	@Override
	public void walk() {
		System.out.println("물고기는 걷지 않고 물에서 헤엄친다!");
	}
	
}
