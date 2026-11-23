package mylab.book.entity;

public class Publication {

	private String title; 		// 출판물 제목 
	private String publishDate;	// 출간일 (yyyy-mm-dd 형식) 
	private int page;			// 페이지 수 
	private int price;			// 가격 

	public Publication() {
	}

	public Publication(String title, String publishDate, int page, int price) {
		this.title = title;
		this.publishDate = publishDate;
		this.page = page;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// toString() : 출판물 제목 반환 메서드
	// 과제 조건에 따라 제목만 반환
	@Override
	public String toString() {
		return title;
	}
}