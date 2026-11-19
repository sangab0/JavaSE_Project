package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

// 체킹 계좌를 표현하는 클래스로 Account 클래스를 상속
public class CheckingAccount extends Account {

	private double withdrawalLimit; // 1회 출금 한도

	// 부모 생성자로 기본 계좌 정보를 초기화하고 출금 한도를 저장
	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		setWithdrawalLimit(withdrawalLimit);
	}

	// 출금 한도 조회 메서드
	// 현재 계좌의 1회 출금 한도를 반환
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}

	// 출금 한도 변경 메서드
	// 전달받은 출금 한도를 저장
	public void setWithdrawalLimit(double withdrawalLimit) {
		if (withdrawalLimit < 0) {
			throw new IllegalArgumentException("출금 한도는 0 이상이어야 합니다.");
		}

		this.withdrawalLimit = withdrawalLimit;
	}

	// 출금 메서드 오버라이드
	// 출금 한도를 초과하면 예외를 발생시키고 한도 이내이면 부모 메서드에서 잔액 검사와 출금을 수행
	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > withdrawalLimit) {
			throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
		}
		super.withdraw(amount);
	}

	// 체킹 계좌 정보 반환 메서드
	// 부모 클래스의 계좌 정보에 출금 한도를 추가하여 반환
	@Override
	public String toString() {
		return super.toString() + ", 출금 한도: " + withdrawalLimit + "원";
	}
}