package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

	// 유형별 평균 가격 계산 메서드
	// 유형별 가격 합계와 개수를 기록한 뒤 평균을 계산하여 반환
	public Map<String, Double> calculateAveragePriceByType(
			Publication[] publications) {

		Map<String, Double> totals = new HashMap<>();
		Map<String, Integer> counts = new HashMap<>();
		Map<String, Double> averages = new HashMap<>();

		for (Publication publication : publications) {
			String type = getPublicationType(publication);

			totals.put(type,
					totals.getOrDefault(type, 0.0) + publication.getPrice());
			counts.put(type, counts.getOrDefault(type, 0) + 1);
		}

		for (String type : totals.keySet()) {
			averages.put(type, totals.get(type) / counts.get(type));
		}

		return averages;
	}

	// 출판물 유형 분포 계산 메서드
	// 유형별 개수를 전체 출판물 수로 나누어 백분율을 계산
	public Map<String, Double> calculatePublicationDistribution(
			Publication[] publications) {

		Map<String, Integer> counts = new HashMap<>();
		Map<String, Double> distribution = new HashMap<>();

		for (Publication publication : publications) {
			String type = getPublicationType(publication);
			counts.put(type, counts.getOrDefault(type, 0) + 1);
		}

		for (String type : counts.keySet()) {
			double ratio = counts.get(type) * 100.0 / publications.length;
			distribution.put(type, ratio);
		}

		return distribution;
	}

	// 특정 연도 출판물 비율 계산 메서드
	// 출판일의 앞 4자리와 전달받은 연도를 비교하여 백분율을 계산
	public double calculatePublicationRatioByYear(
			Publication[] publications, String year) {

		if (publications.length == 0) {
			return 0.0;
		}

		int count = 0;

		for (Publication publication : publications) {
			String publishYear = publication.getPublishDate().substring(0, 4);

			if (publishYear.equals(year)) {
				count++;
			}
		}

		return count * 100.0 / publications.length;
	}

	// 출판물 유형 확인 메서드
	// 실제 객체의 타입에 해당하는 한글 유형명을 반환
	private String getPublicationType(Publication pub) {
		if (pub instanceof Novel) {
			return "소설";
		} else if (pub instanceof Magazine) {
			return "잡지";
		} else if (pub instanceof ReferenceBook) {
			return "참고서";
		}

		return "기타";
	}

	// 통계 정보 출력 메서드
	// 유형별 평균 가격, 유형 분포, 2007년 출판 비율을 출력
	public void printStatistics(Publication[] publications) {
		DecimalFormat numberFormat = new DecimalFormat("#,###.##");
		DecimalFormat priceFormat = new DecimalFormat("#,###");

		Map<String, Double> averages = calculateAveragePriceByType(publications);
		Map<String, Double> distribution = calculatePublicationDistribution(publications);

		// HashMap의 저장 순서와 관계없이 일정한 순서로 출력
		String[] types = { "소설", "참고서", "잡지", "기타" };

		System.out.println("\n===== 출판물 통계 분석 =====");
		System.out.println("1. 타입별 평균 가격:");

		for (String type : types) {
			if (averages.containsKey(type)) {
				System.out.println("   - " + type + ": " + priceFormat.format(averages.get(type)) + "원");
			}
		}

		System.out.println("\n2. 출판물 유형 분포:");

		for (String type : types) {
			if (distribution.containsKey(type)) {
				System.out.println("   - " + type + ": " + numberFormat.format(distribution.get(type)) + "%");
			}
		}

		double ratio = calculatePublicationRatioByYear(publications, "2007");

		System.out.println("\n3. 2007년에 출판된 출판물 비율: " + numberFormat.format(ratio) + "%");
	}
}