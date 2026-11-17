package workshop.account.control;

import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class AccountTest {
	public static void main(String[] args) {
		try {
			Account account = new Account();
			
			account.setCustId("A1100");
			account.setAcctId("221-22-3477");
			account.deposit(100000);
			
			System.out.println("고객번호 = " + account.getCustId());
			System.out.println("계좌번호 = "+ account.getAcctId());
			System.out.println("잔액 = " + account.getBalance());
			
			Account account2 = new Account("A1105", "221-22-3488", 100000);
			account2.withdraw(50000);
			System.out.println("고객번호 = " + account2.getCustId());
			System.out.println("계좌번호 = "+ account2.getAcctId());
			System.out.println("잔액 = " + account2.getBalance());
			
			account2.withdraw(60000);
			
			// toString();
			// getClass().getName() + "@" + Integer.toHexString(hashCode())
			System.out.println(account2);
			// workshop.account.entity.Account@2a139a55 이런 주소값은 의미가 없으니 재정의(overriding) 해주기
		} catch (InsufficientBalanceException e) { 
			// 부모 클래스인 Exception을 작성해도 예외 처리는 가능함
		    // 하지만 자식 클래스인 InsufficientBalanceException을 사용하면 정확한 원인(잔액 부족)을 구분해 처리할 수 있음
			System.out.println("Error 메시지 = " + e.getMessage());
		}
	}
}
