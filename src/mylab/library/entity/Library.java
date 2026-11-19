package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private String name;
	private List<Book> books;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// 도서 추가 메서드 
	public void addBook(Book book) {
		books.add(book);
		System.out.println("도서가 추가되었습니다: " + book.getTitle());
	}
	
	// 제목으로 도서 검색 메서드 
	// 제목이 일치하는 첫 번째 도서를 반환하고  없으면 null을 반환
	public Book findBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
		
	}
	
	// 저자로 도서 검색 메서드
	// 저자가 일치하는 모든 도서를 리스트에 담아 반환
	// 일치하는 도서가 없으면 빈 리스트를 반환
	public List<Book> findBooksByAuthor(String author) {
		List<Book> result = new ArrayList<>();
		
		for (Book book : books) {
			if (book.getAuthor().equals(author)) {
				result.add(book);
			}
		}
		return result;
	}
	
	// ISBN으로 도서 검색 메서드
	// ISBN이 일치하는 도서를 반환하고 없으면 null을 반환
	public Book findBookByISBN(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}
	
	// ISBN으로 도서 대출 메서드
	// ISBN으로 도서를 찾아 Book의 checkOut()을 호출
	// 대출에 성공하면 true, 도서가 없거나 이미 대출 중이면 false를 반환
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		
		if (book == null) {
			return false;
		}
		return book.checkOut();
	}
	
	// ISBN으로 도서 반납 메서드
	// ISBN으로 도서를 찾아 Book의 returnBook()을 호출
	// 반납에 성공하면 true, 도서가 없거나 이미 반납된 상태이면 false를 반환
	public boolean returnBook(String isbn) {
		Book book = findBookByISBN(isbn);
		
		if (book == null || book.isAvailable()) {
			return false;
		}
		book.returnBook();
		return true;
	}
	
	// 대출 가능한 도서 목록 조회 메서드
	// 대출 가능 상태인 도서만 새 리스트에 담아 반환
	public List<Book> getAvailableBooks() {
		List<Book> availableBooks = new ArrayList<>();
		
		for (Book book : books) {
			if (book.isAvailable()) {
				availableBooks.add(book);
			}
		}
		return availableBooks;
	}
	
	// 모든 도서 목록 메서드 
	// 내부 목록을 복사하여 반환
	// 반환된 리스트에 도서를 추가하거나 삭제해도 내부 목록에는 영향을 주지 않음 
	public List<Book> getAllBooks() {
		return new ArrayList<>(books);	// books에 있는 책들을 담은 새 리스트 생성
	}
	
	// 모든 도서 갯수 반환 메서드 
	public int getTotalBooks() {
		return books.size();
	}
	
	// 대출 가능한 도서 갯수 반환 메서드 
	public int getAvailableBooksCount() {
		int count = 0;
		for (Book book : books) {
			if (book.isAvailable()) {
				count++;
			}
		}
		return count;
	}
	
	// 대출 중인 도서 갯수 반환 메서드 
	// 전체 도서 수에서 대출 가능한 도서 수 빼기 
	public int getBorrowedBooksCount() {
		return getTotalBooks() - getAvailableBooksCount();
	}
}
