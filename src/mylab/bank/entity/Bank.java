package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {

	private List<Account> accounts; // 은행에서 관리하는 계좌 목록
	private int nextAccountNumber;  // 다음 계좌번호에 사용할 숫자

	public Bank() {
		this.accounts = new ArrayList<>(); 	// 빈 계좌 목록을 생성
		this.nextAccountNumber = 1000; 		// 시작 계좌번호를 1000으로 설정
	}

	// 저축 계좌 생성 메서드
	// 계좌번호를 부여하고 저축 계좌를 생성하여 목록에 추가
	public SavingsAccount createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
		String accountNumber = "AC" + nextAccountNumber;

		SavingsAccount account = new SavingsAccount(
				accountNumber, ownerName, initialBalance, interestRate);

		accounts.add(account);
		nextAccountNumber++;

		System.out.println("저축 계좌가 생성되었습니다: " + account);
		return account;
	}

	// 체킹 계좌 생성 메서드
	// 계좌번호를 부여하고 체킹 계좌를 생성하여 목록에 추가
	public CheckingAccount createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		String accountNumber = "AC" + nextAccountNumber;

		CheckingAccount account = new CheckingAccount(
				accountNumber, ownerName, initialBalance, withdrawalLimit);

		accounts.add(account);
		nextAccountNumber++;

		System.out.println("체킹 계좌가 생성되었습니다: " + account);
		return account;
	}

	// 계좌 검색 메서드
	// 계좌번호가 일치하는 계좌를 반환하고 없으면 예외를 발생시키기
	public Account findAccount(String accountNumber)
			throws AccountNotFoundException {
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}

		throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
	}

	// 계좌 입금 메서드
	// 계좌번호로 계좌를 찾아 입금
	public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
		Account account = findAccount(accountNumber);
		account.deposit(amount);
	}

	// 계좌 출금 메서드
	public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
		Account account = findAccount(accountNumber); // 계좌번호로 계좌를 찾아 출금
		account.withdraw(amount); // 실제 계좌 유형에 맞는 withdraw() 실행
	} 

	// 계좌 이체 메서드
	// 두 계좌가 모두 존재하는지 확인한 뒤 출금 계좌에서 출금하고 입금 계좌에 입금 -> 출금에 실패하면 입금은 실행X
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
		Account fromAccount = findAccount(fromAccountNumber);
		Account toAccount = findAccount(toAccountNumber);

		fromAccount.withdraw(amount);
		toAccount.deposit(amount);

		System.out.println(amount + "원이 " + fromAccountNumber + "에서 " + toAccountNumber + "로 송금되었습니다.");
	}

	// 전체 계좌 출력 메서드
	// 모든 계좌의 toString()을 호출하여 계좌별 정보를 출력
	public void displayAllAccounts() {
		System.out.println("\n=== 모든 계좌 목록 ===");

		for (Account account : accounts) {
			System.out.println(account);
		}

		System.out.println("===================");
	}
}