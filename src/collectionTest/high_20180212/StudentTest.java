package collectionTest.high_20180212;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 문제)
 * 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버변수로 갖는 
 * Student클래스를 만든다 (이름만 String, 나머지는 int)
 * 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 처리한다
 * 
 * 이 Student 객체들은 List에 저장하여 관리한다
 * List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
 * 총점의 역순으로 정렬하는 부분을 프로그램 하시오
 * (총점이 같으면 학번의 내림차순으로 정렬되도록 한다)
 * 
 * - 학번 정렬기준은 객체 자체에 구현하고
 * - 총점 정렬기준은 외부 객체로 구현한다
 */
public class StudentTest {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "김상준", 33, 35, 38));
		list.add(new Student(3, "김하준", 33, 35, 38));
		list.add(new Student(2, "김중준", 33, 35, 38));
		list.add(new Student(5, "하상준", 22, 25, 28));
		list.add(new Student(4, "나상준", 43, 45, 48));
		list.add(new Student(7, "이상준", 32, 35, 38));
		list.add(new Student(6, "상상준", 32, 35, 38));
		
		
		System.out.println("학생 리스트 출력");
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println("=============================");
		
		
		System.out.println("학번으로 오름차순 정렬");
		Collections.sort(list);
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println("=============================");

		
		Collections.sort(list, new TotalSort());
		System.out.println("총점으로 내림차순 정렬");
		
		int rank = 1;
		int totalScore = list.get(0).getTotalScore();
		for (int i = 0; i < list.size(); i++) {
			Student student = list.get(i);			
			if(totalScore != student.getTotalScore()){
				rank = i+1;
			}
			student.setRank(rank);
			totalScore = student.getTotalScore();
		}
		
		
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println("=============================");
		
	}
}

class TotalSort implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getTotalScore() == o2.getTotalScore()){
			Integer num = o1.getNum();
			return num.compareTo(o2.getNum()) * -1;
		}
		
		Integer totalScore = o1.getTotalScore();
		return totalScore.compareTo(o2.getTotalScore()) * -1;
	}	
}


class Student implements Comparable<Student>{
	
	private String name;
	private int num;
	private int korScore;
	private int engScore;
	private int mathScore;
	private int totalScore;
	private int rank;
	
	public Student(int num, String name, int korScore, int engScore, int mathScore){
		super();
		this.num = num;
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
		totalScore = korScore + engScore + mathScore;
	}
	
	@Override
	public String toString() {
		return "[학번 : " + num + ", 이름 : " + name + ", 국어점수 : " + korScore + ", 영어점수 : " + engScore + ", 수학점수 : " + mathScore + ", 총점 : " + totalScore + ", 등수 : " + rank + "]";
	}
	
	// 학번을 기준으로 오름차순 정렬이 될 수 있도록 설정
	@Override
	public int compareTo(Student o) {
//		return ((Integer)num).compareTo(o.getNum());
		return Integer.compare(num, o.getNum());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}