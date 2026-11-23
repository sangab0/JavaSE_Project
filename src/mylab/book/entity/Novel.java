package mylab.book.entity;

public class Novel extends Publication {
	private String author; 	// 저자 	
	private String genre;	// 장르 
	
	public Novel() {
	}

	public Novel(String title, String publishDate, int page, int price, String author, String genre) {
		super(title, publishDate, page, price);
		this.author = author;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	// toString() : 소설 정보 반환 메서드
	// 부모의 제목에 소설의 상세 정보를 추가
	@Override
	public String toString() {
		return super.toString() + " [소설] 저자:" + author
				+ ", 장르:" + genre
				+ ", " + getPage() + "쪽"
				+ ", " + getPrice() + "원"
				+ ", 출판일:" + getPublishDate();
	}
}