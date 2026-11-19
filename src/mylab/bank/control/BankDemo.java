package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {

	// 은행 계좌 관리 시스템 실행 메서드
	// 계좌 생성, 입출금, 이자 적용, 이체 및 예외 처리를 테스트!
	public static void main(String[] args) {
		Bank bank = new Bank();

		// 계좌 생성
		// 저축 계좌 2개와 체킹 계좌 1개를 생성
		System.out.println("=== 계좌 생성 ===");

		SavingsAccount savingsAccount = bank.createSavingsAccount("홍길동", 10000, 3.0);

		bank.createCheckingAccount("김철수", 20000, 5000);
		bank.createSavingsAccount("이영희", 30000, 2.0);

		// 전체 계좌 목록 출력
		bank.displayAllAccounts();

		try {
			// 입금, 출금 테스트
			System.out.println("\n=== 입금/출금 테스트 ===");
			bank.deposit("AC1000", 5000);
			bank.withdraw("AC1001", 3000);

			// 이자 적용 테스트
			System.out.println("\n=== 이자 적용 테스트 ===");
			savingsAccount.applyInterest();

			// 계좌 이체 테스트
			System.out.println("\n=== 계좌 이체 테스트 ===");
			bank.transfer("AC1002", "AC1001", 5000);

			// 입출금, 이자 적용, 이체 후 전체 계좌 정보를 출력
			bank.displayAllAccounts();

		} catch (AccountNotFoundException | InsufficientBalanceException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		// 출금 한도 초과 테스트
		try {
			bank.withdraw("AC1001", 6000);
		} catch (AccountNotFoundException | InsufficientBalanceException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		// 이체 시 출금 한도 초과 테스트
		try {
			bank.transfer("AC1001", "AC1000", 10000);
		} catch (AccountNotFoundException | InsufficientBalanceException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		// 존재하지 않는 계좌 검색 테스트
		try {
			bank.findAccount("AC9999");
		} catch (AccountNotFoundException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		// 잔액 부족 테스트
		try {
			bank.withdraw("AC1000", 20000);
		} catch (AccountNotFoundException | InsufficientBalanceException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}
	}
}