package mylab.book.entity;

public class ReferenceBook extends Publication {

	private String field;	// 전문 분야 

	public ReferenceBook() {
	}

	public ReferenceBook(String title, String publishDate, int page, int price, String field) {
		super(title, publishDate, page, price);
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	// toString() : 참고서 정보 반환 메서드
	// 부모의 제목에 참고서의 상세 정보를 추가
	@Override
	public String toString() {
		return super.toString() + " [참고서] 분야:" + field
				+ ", " + getPage() + "쪽"
				+ ", " + getPrice() + "원"
				+ ", 출판일:" + getPublishDate();
	}
}