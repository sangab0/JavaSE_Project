package mylab.book.entity;

public class Magazine extends Publication {

	private String publishPeriod;

	public Magazine() {
	}

	public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
		super(title, publishDate, page, price);		 // 부모 생성자 호출 
		this.publishPeriod = publishPeriod;			// 자신만의 속성 초기화 
	}

	public String getPublishPeriod() {
		return publishPeriod;
	}

	public void setPublishPeriod(String publishPeriod) {
		this.publishPeriod = publishPeriod;
	}

	// toString() 오버라이드: 부모 생성자 호출 후 자신만의 속성 초기화 
	// 부모의 제목에 잡지의 상세 정보를 추가
	@Override
	public String toString() {
		return super.toString() + " [잡지] 발행주기:" + publishPeriod
				+ ", " + getPage() + "쪽"
				+ ", " + getPrice() + "원"
				+ ", 출판일:" + getPublishDate();
	}
}