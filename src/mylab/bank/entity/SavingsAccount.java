package mylab.bank.entity;

// 저축 계좌를 표현하는 클래스로 Account 클래스를 상속
public class SavingsAccount extends Account {

	private double interestRate; // 이자율(%)

	// 저축 계좌 생성자
	// 부모 생성자로 기본 계좌 정보를 초기화하고 이자율을 저장합니다.
	public SavingsAccount(String accountNumber, String ownerName,
			double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		setInterestRate(interestRate);
	}

	// 이자율 조회 메서드
	public double getInterestRate() {
		return interestRate;
	}

	// 이자율 변경 메서드
	// 전달받은 이자율을 저장
	public void setInterestRate(double interestRate) {
		if (interestRate < 0) {
			throw new IllegalArgumentException("이자율은 0 이상이어야 합니다.");
		}

		this.interestRate = interestRate;
	}

	// 이자 적용 메서드
	// 현재 잔액과 이자율로 계산한 이자를 계좌에 입금
	public void applyInterest() {
		double interest = getBalance() * interestRate / 100;

		if (interest > 0) {
			deposit(interest);
		}

		System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + getBalance() + "원");
	}

	// 저축 계좌 정보 반환 메서드
	// 부모 클래스의 계좌 정보에 이자율을 추가하여 반환
	@Override
	public String toString() {
		return super.toString() + ", 이자율: " + interestRate + "%";
	}
}