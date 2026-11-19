package mylab.library.entity;

public class Book {
	private String title; 			// 제목 
	private String author;			// 저자 
	private String isbn;			// ISBN
	private int publishYear;		// 출판년도 
	private boolean isAvailable;	// 대출상태
	
	// 기본 생성자: 도서를 대출 가능 상태로 초기화
	public Book() {
		this.isAvailable = true;
	}

	// 전달받은 도서 정보를 저장하고 대출 가능 상태는 true로 초기화
	public Book(String title, String author, String isbn, int publishYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
	    this.isAvailable = true;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	// 도서 대출 메서드 
	public boolean checkOut() {
		// 대출 가능한 경우 isAvailable을 false로 변경하고 true를 반환
		// 이미 대출 중이면 false 반환 
		if (!isAvailable) {
			return false;
		}
		isAvailable = false;
		return true;
	}
	
    // 도서 반납 메서드 
	public void returnBook() {
		isAvailable = true; 	// 도서 반납 시 isAvailable을 true로 변경
	}

	@Override
	public String toString() {
		return "책 제목:" + title + ", 저자:" + author + ", ISBN:" + isbn + ", 출판년도:" + publishYear
				+ ", 대출 가능 여부:" + (isAvailable ? "가능" : "대출 중");
	}
}
