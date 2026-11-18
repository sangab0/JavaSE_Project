package workshop.animal.entity;

public interface Pet {
	// 인터페이스의 아래 메서드들은 public abstract가 자동 적용됨
	String getName();
	
	// abstract void setName(String name); → abstract는 생략 가능하며, 붙여도 오류가 나지 않남
	void setName(String name);
	
	public abstract void play();
}
