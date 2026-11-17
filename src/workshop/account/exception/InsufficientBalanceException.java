package workshop.account.exception;

/*
 * Account의 잔액(balance)가 부족할 때 사용되는 사용자정의 Exception 클래스
 */
public class InsufficientBalanceException extends Exception {
	// 현재 잔액 
	private int currentBalance;

	public InsufficientBalanceException(String message, int currentBlance) {
		// 부모 클래스의 생성자를 호출한다. 
		super(message);
		this.currentBalance = currentBlance;
	}
	public int getCurrentBalance() {
		return currentBalance;
	}
}
