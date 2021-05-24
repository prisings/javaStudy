package absInterface;

public class AnimalABSTest {

// ** 다형성(polymorphism)

// => 본래 '여러 개의 형태를 갖는다'라는 의미의 그리스어에서 유래
// => 또 사전에서 찾아보면 poly(하나 이상), morph(형태)가 합성된 단어로
//	    '하나 이상의 형태'를 뜻한다. 
	
// ** 다형성 적용
// => 조상의 타입 으로 변수 선언, 후손의 타입으로 인스턴스 생성
// => 조상에 정의된 범위내에서만 후손이 호출됨
	
// ** 다형성 적용의 장점
// => 계층구조에서 일괄 작업 가능
// => 클래스의 교체가 간편

	public static void main(String[] args) {
	/*	System.out.println("*** Test 1 ***");
		Cat cat = new Cat();
		cat.breathe();
		cat.sound();
		cat.color();
		
		Eagle eagle = new Eagle();
		eagle.breathe();
		eagle.sound();
		eagle.flying();
	
		//AnimalABS am = new AnimalABS(); // 직접 인스턴스를 생성하지 못함
		System.out.println("*** Test 2 ***");
	*/	
		
		// 참조형 변수의 타입으로 선언은 가능하고 후손으로 인스턴스를 생성할 수 있음
		// 그러나 이 인스턴스는 조상인 추상클래스 (AnimalABS) 에 정의된 만큼만 접근 가능하다.
		// => 클래스 교체가 편리해짐
		// => 이 범위내에서는 조상에 정의된 만큼만 사용했음을 의미함

//		am.color(); => 접근불가

		// 다형성 적용 -> 클래스를 매개변수로 ... 클래스 교체
		// => 매개변수로는 	AnimalABS 클래스와 그 후손 클래스들만 가능
		//    클래스간의 상속관계가 전혀없으면 컴파일 오류
		// animalUse(new Bear());  // XXXXXXXXXX
		// => 가능 여부 확인할수 있는 연산자가 : instanceof  
/*
 		Bear bear = new Bear();
 		//animalUse(bear); // 오류  => AnimalABS am = new Bear() ;
 		if (bear instanceof AnimalABS) 	animalUse(bear);  
		// => XXX 컴파일 오류 발생, 그러나 비교대상이 인터페이스라면 컴파일오류 없이 확인 가능
 		else System.out.println("bear 는 AnimalABS의 인스턴스를 생성 할 수 없습니다.~~");
*/		
/*		System.out.println("*** Test 3 ***");		
		if (dog instanceof AnimalABS) 	animalUse(dog);
		else System.out.println("cat 는 AnimalABS의 인스턴스를 생성 할 수 없습니다.~~");
*/		
		Dog dog = new Dog();
		dog.breathe();
		dog.sound();
		dog.playing();
		
		AnimalABS am = new Dog();
		am.breathe();
		am.sound();
		am.special();
		
		int i = 100;
		Integer ii =(Integer)i ;
		// 기본 자료형의 경우 래퍼 클래스로 자동 형변환이됨 
		
		animalUse((Dog)am); // 형변환 적용 
		//animalUse(new Dog());  // AnimalABS am = new Dog()
		animalUse(dog);  // AnimalABS am = new Dog()
		animalUse(new Eagle());// AnimalABS am = new Eagle()
		
		// 매개변수를 Object Type 으로 하면 모든 클래스의 인스턴스를 매개변수로 전달 가능 
		objectTest(new Dog());
		objectTest(new AnimalABSTest());
		objectTest(new Bear());
		
	} // main
	
	//public static void animalUse(Dog am) {  
	public static void animalUse(AnimalABS am) { 	
	//public static void animalSound(Object am) { // XXXXX
		am.breathe();
		am.sound();
		am.special();
	}
	
	public static void objectTest(Object ob) {
		System.out.println("** objectTest ob =>"+ob);
		System.out.println("** objectTest ob.toString()=>"+ob.toString());
	}
	
} // class
