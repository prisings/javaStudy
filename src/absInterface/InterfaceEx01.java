package absInterface;

// ** Interface 특징 1
//=> interface 로 정의
//=> 상수와 추상메서드 만 가질 수 있음.
//=> 모든 변수는 상수  public static final -> 그러므로 생략가능
//=> 모든 메서드  public abstract -> 그러므로 생략가능
//=> 직접 인스턴스를 생성하지 못함.
//		그러나 참조형 변수로 선언은 가능하다.
//		그리고 후손으로 인스턴스를 생성할 수 있음.
//=> 다형성의 적용은 가능하다.

interface NumInter {
	int NUM = 100;
	// public final static 생략가능
	int getNum();
	// public abstract 생략가능
}
class NumChild1 implements NumInter { 
	// 오버라이딩 
	// => 접근범위가 조상보다 같거나 넓어야 함. 
	public int getNum() { return NUM; }
}

class NumChild2 implements NumInter { 
	public int getNum() { return NUM*NUM; }
}

public class InterfaceEx01 {

	public static void main(String[] args) {
		NumChild1 nc1 = new NumChild1();
		System.out.println("nc1.getNum() =>"+nc1.getNum());
		
		NumChild2 nc2 = new NumChild2();
		System.out.println("nc2.getNum() =>"+nc2.getNum());
		
		// NumInter ni = new NumInter(); // 직접 인스턴스를 생성하지 못함
		NumInter ni = new NumChild2();
		System.out.println("ni.getNum() =>"+ni.getNum());
		
	} // main
} // class
