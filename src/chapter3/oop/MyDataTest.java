package chapter3.oop;

// Run 실행 단축키 ctrl + f11 
public class MyDataTest {
	public static void main(String[] args) {
		MyDate date = new MyDate();
//		date.day = 32; -> public int day; 일 때 선언가능 
		date.setMonth(13);
		System.out.println(date.getMonth());
		date.setDay(31);
		System.out.println(date.getDay());
		
		MyDate date2 = new MyDate(2026, 13, 16);
		System.out.println(date2.getMonth());

	}
}
