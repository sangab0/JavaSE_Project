package workshop.account.entity;

public class Account extends Object {
	private String custId; // 고객번호
	private String acctId; // 계좌번호 
	private int balance; // 잔액 
	
	public Account() {
		
	}
	
	// 생성자 선언 
	public Account(String custId, String acctId, int balance) {
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}
	
	// Method 선언 
	public String getCustId() {
		return custId;
	}
	
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	public String getAcctId() {
		return acctId;
	}
	
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
	public int getBalance() {
		return balance;
	}
	
	// 계좌잔액(balance)을 입력한 금액만큼 증가(입금) 시키는 메서드
	public void deposit(int amount) {
//		this.balance = this.balance + amount;
		this.balance += amount;
	}
	
	// 계좌잔액을 입력한 금액만큼 감소(출금) 시키는 메서드
	public void withdraw(int amount) {
		this.balance -= amount;
	}

	/**
	 * Object 클래스의 toString() 재정의
	 * 계좌 정보(고객ID, 계좌번호, 잔액)를 문자열로 반환
	 */
	@Override
	public String toString() {
		return "Account [custId=" + custId + ", acctId=" + acctId + ", balance=" + balance + "]";
	}
	
	
}
