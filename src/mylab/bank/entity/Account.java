package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {

	private String accountNumber; // 계좌번호
	private String ownerName;     // 계좌 소유자
	private double balance;       // 현재 잔액

	public Account(String accountNumber, String ownerName, double balance) {
		if (balance < 0) {
			throw new IllegalArgumentException("초기 잔액은 0 이상이어야 합니다.");
		}

		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	// 계좌번호 조회 메서드
	public String getAccountNumber() {
		return accountNumber;
	}

	// 계좌 소유자 조회 메서드
	public String getOwnerName() {
		return ownerName;
	}

	// 계좌 소유자 변경 메서드
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	// 잔액 조회 메서드
	public double getBalance() {
		return balance;
	}

	// 입금 메서드
	// 입금액만큼 잔액을 증가시키고 입금 결과를 출력
	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("입금액은 0보다 커야 합니다.");
		}

		balance += amount;
		System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
	}

	// 출금 메서드
	// 잔액이 부족하면 예외를 발생시키고 충분하면 출금액만큼 차감
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount <= 0) {
			throw new IllegalArgumentException("출금액은 0보다 커야 합니다.");
		}

		if (amount > balance) {
			throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액: " + balance + "원");
		}

		balance -= amount;
		System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
	}

	// 계좌 정보 반환 메서드
	// 계좌번호, 소유자, 잔액을 문자열로 반환
	@Override
	public String toString() {
		return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원";
	}
}