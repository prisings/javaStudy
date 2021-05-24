package absInterface;

//** instanceof 연산자
//=> A(Object) instanceof B(Class, Interface) 형태로 사용
//   즉 A위치에는 Object(인스턴스), B 위치에는 클래스 나 인터페이스

//=> A Object를 B 클래스나 인터페이스로 캐스팅이 가능한것인지를 확인하는 연산자
//   즉,명시적 형변환이 가능한지를 묻는 연산자 임.	
//   A 인스턴스가  B클래스 의 집안에 해당 되는지 (상속관계인지) 묻는 연산자 
//=> true / false  

//=> 따라서 B가 클래스일 경우에는 A가 반드시 B클래스와 상속관계에 있어야만 유효하며
//   상속관계가 없을 경우 캐스팅이 불가능하기에 컴파일 타임 에러 발생  
//   (왜냐하면 컴파일 타임에 내부적으로 캐스팅 처리를 해야 하기 때문) 
//=> 그러나 B가 인터페이스라면 컴파일 타임 에러는 안 나지만 런타임 에러 발생

interface InterNum {
	int NUM = 100;  // public static final int NUM = 100;
	int getNum();   // public abstract int getNum();
} // NumInter

class Adder {
	int addNum(int i, int j) { return i+j ; } // addNum
} // Adder

class Bear2 {
	public void sound() {
		System.out.println("야옹~야옹~~");
	}
} // Bear

public class Ex02_01InstanceofEx {

	public static void main(String[] args) {
		Bear2 bear = new Bear2() ;
		// 클래스와 비교
		if (bear instanceof Object) 
			 System.out.println("Yes Ok ~~~");
		else System.out.println("Oh~ No~No~"); 
		
		// Bear와 Adder 는 상속관계가 아니기 때문에 컴파일 오류
//		if (bear instanceof Adder)  
//			 System.out.println("Yes Ok ~~~");
//		else System.out.println("Oh~ No~No~"); 
		
		// Bear와 InterNum 은 상속관계가 아니지만 InterNum이 인터페이스 이기 때문에
		// 컴파일 오류 안나고 런타임시 확인 가능.
		if (bear instanceof InterNum)  
			 System.out.println("Yes Ok ~~~");
		else System.out.println("Oh~ No~No~"); 
		
	} // main
} // class
