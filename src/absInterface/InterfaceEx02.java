package absInterface;

// ** Interface 특징 2  
// 1) 인터페이스간의 상속
// => 인터페이스 끼리의 상속(extends)이 가능하며 다중상속, 계층적상속 가능.
// 2) 클래스와 인터페이스
// => 클래스가 인터페이스를 다중으로 implements 하는것도 가능
// => 클래스가 클래스를 extends 하고 동시에 
//    인터페이스를 implements (다중도) 하는것도 가능

// ** instanceof 연산자
// => A(객체, 인스턴스명) instanceof B(Class, Interface) 형태로 사용
// => 즉 A위치에는 Object(인스턴스), B 위치에는 클래스 나 인터페이스
// => A Object를 B 클래스나 인터페이스로 캐스팅이 가능한것인지를 확인하는 연산자
// => 따라서 B가 클래스일 경우에는 A가 반드시 B클래스와 상속관계에 있어야만 유효하며
//    상속관계가 없을 경우 캐스팅이 불가능하기에 컴파일 타임 에러 발생  
//   (왜냐하면 컴파일 타임에 내부적으로 캐스팅 처리를 해야 하기 때문) 
// => 그러나 B가 인터페이스라면 컴파일 타임 에러 없고 런타임 시 결과 알려줌 

interface Inter1 {
	float PI=3.14159f;
	int getA();
} // Inter1

interface Inter2 {	int getB(); } // Inter2
interface Inter3 extends Inter1, Inter2 {
	float getC();
}
// 다중구현
class InterMul1 implements Inter1, Inter2, Inter3 {
	int a=100; int b=123;
	@Override
	public int getA() { return a; }
	@Override
	public int getB() { return b; }
	@Override
	public float getC() { return (a+b)*PI; }
} // InterMul1

// extends & implements
class Add {
	int addNum(int a, int b) { return a+b; }
}

//class InterMul2  extends Add implements Inter3 {
class InterMul2  extends Add implements Inter1, Inter2, Inter3 {	
	int a=100; int b=123;
	@Override
	public int getA() { return a*2; }
	@Override
	public int getB() { return b*2; }
	@Override
	public float getC() { return addNum(a,b)*PI; }
} // InterMul2

public class InterfaceEx02 {
	public static void main(String[] args) {
		
		InterMul1 im1 = new InterMul1();
		System.out.println("im1 getA() =>"+im1.getA());
		System.out.println("im1 getB() =>"+im1.getB());
		System.out.println("im1 getC() =>"+im1.getC());
		
		InterMul2 im2 = new InterMul2();
		System.out.println("im2 getA() =>"+im2.getA());
		System.out.println("im2 getB() =>"+im2.getB());
		System.out.println("im2 getC() =>"+im2.getC());
		
		// 다형성 적용시 적합 여부 확인 => instanceof
		if (im1 instanceof Inter1) {
			System.out.println("** True **");
			Inter1 it = new InterMul1();
			System.out.println("it getA() =>"+it.getA());
		}else  System.out.println("** im1 instanceof Inter1 => False");
		
		// 비교 대상이 인터페이스 인경우 컴파일 오류 없음
		// 런타임시에 적합여부 알려줌
		if (new Add() instanceof Inter1) {
			System.out.println("** True **");
			// Inter1 it = new Add(); -> 컴파일 오류
		}
		else  System.out.println("** new Add() instanceof Inter1 => False **");
		
	} // main
} // class
