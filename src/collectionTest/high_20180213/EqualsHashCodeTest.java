package collectionTest.high_20180213;

import java.util.HashSet;

/**
 * equals와 hashCode 오버라이드<br>
 * equals를 오버라이드 한경우 equals를 이용하여 비교 가능<br>
 * equals와 hashCode를 오버라이드 한경우 HashSet에 더해질때 다른 인스턴스여도 내용이 같으면 중복으로 처리 가능<br>
 * hashCode()와 equals()에 관련된 규칙 5개<br>
 * @author SangJun
 *
 */
public class EqualsHashCodeTest {
	public static void main(String[] args) {
		Person p1 = new Person(1, "일지매");
		Person p2 = new Person(1, "일지매");
		
		System.out.println(p1.equals(p2));
		System.out.println(p1 == p2);
		System.out.println("p1의 주소 : " + p1.toString());
		System.out.println("p1의 hashCode : " + p1.hashCode());
		System.out.println("p2의 주소 : " + p2.toString());
		System.out.println("p2의 hashCode : " + p2.hashCode());
		
		/*
		 * HashCode가 같은 경우 하나만 저장된다
		 * Person class에서 HashCode를 오버라이드 하여 사용할 경우
		 * 	다른 인스턴스 이지만 내용이 같으므로 같은 HashCode를 가진다
		 */
		HashSet<Person> hs = new HashSet<Person>();
		hs.add(p1);
		hs.add(p2);
		System.out.println("HashSet : " + hs);
		
		/*
		 * - equals() 메서드는 두 객체의 내용이 같은지 여부
		 * 		즉, 동등성(equality)을 비교하는 메서드이다.
		 * 
		 * - hashCode() 메서드는 두 객체가 같은 객체인지 여부
		 * 		즉, 동일성(identity)을 비교하는 메서드이다.
		 * 
		 * - HashSet, HashMap, HashTable 과 같은 객체들을 사용할 경우
		 * 		객체의 의미상의 동등성 비교를 위해 hashCode()메서드를 호출하여 비교한다
		 * 		그러므로, 객체가 같은지 여부를 결정하려면 "hashCode()메서드도 재정의" 해야 한다
		 * 
		 * hashCode()와 equals()에 관련된 규칙
		 * 1. 두 객체가 같으면 반드시 같은 hashcode를 가져야 한다.
		 * 2. 두 객체가 같으면 equals()메서드를 호출했을 때 true를 반환해야 한다.
		 * 		즉, a,b가 같으면 a.equlas(b)와 b.equals(a) 둘 다 true이어야 한다.
		 * 3. 두 객체의 hashcode가 같다고 해서 반드시 같은 객체는 아니다.
		 * 		하지만 두 객체가 같으면 두 hashcode는 반드시 같아야 한다.
		 * 4. equals()메서드를 override하면 반드시 hashCode()메서드도 override해야 한다.
		 * 5. hashCode()메서드에서는 기본적으로 Heap에 있는 각 객체의 메모리 주소
		 * 		매핑 정보를 기반으로 한 정수값을 반환한다.
		 * 		그래서 각 Class들은 hashCode()메서드를 override하지 않으면 절대로
		 * 		그 유형의 객체가 같은 것으로 간주될 수 없다.
		 * 
		 */
		
		
		
		
	}
}
class Person{
	private int id;
	private String name;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}


	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}