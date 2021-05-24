package absInterface;
// ** 추상 클래스 
// => J10 , 3page
// => 추상메서드가 하나라도 정의되면 그 클래스는 반드시 추상클래스로 정의 해야 함 
// => 직접 인스턴스를 생성하지 못함.
//    그러나 참조형 변수의 타입으로 선언은 가능하다.
//    그리고 후손으로 인스턴스를 생성할 수 있음. 

// ** 추상 메서드
// => Body 부분이 없고 Header 만 선언
// => 매개변수 뒤에 ; 붙여야됨.
// => Body 부분은 Child 클래스에서 반드시 재정의(오버라이딩) 해서
//    실행문을 작성 해야 함.
// => 추상 메서드 목적 : 후손에게 오버라이딩 의 강제성을 부여 (메서드명의 통일성)

public abstract class AnimalABS {
	public String kind;
	public void breathe() { System.out.println(kind+" 는 숨을 쉽니다 ~~"); }
	//public void sound() {  }  
	// body 가 없는 일반메서드 -> 후손에 특별한 영향을 주지 않는다
	public abstract void sound();
	public abstract void special();
} // class

class Cat extends AnimalABS {
	Cat() { kind="고양이"; } 
	@Override
	public void sound() { System.out.println("~~ 야옹 야옹  ~~"); }
	@Override
	public void special(){ System.out.println("~~ 눈이 예뻐요 ~~"); }
	public void color(){ System.out.println("~~ Silver Color 가 멋져요 ~~"); }
} // Cat

class Dog extends AnimalABS {
	Dog() { kind="강아지"; } 
	@Override
	public void sound() { System.out.println("~~ 멍 멍 멍 멍  ~~"); }
	@Override
	public void special(){ System.out.println("~~ 털이 길어요 ~~"); }
	public void playing(){ System.out.println("~~ 잘 뛰어 놀아요 ~~"); }
	
} // Dog

class Eagle extends AnimalABS {
	public Eagle() { kind="조류"; }
	public void sound() { System.out.println("독독수리~수리수리~~"); }
	public void special() { System.out.println("날개가 멋져요~~"); 	}
	public void flying() { System.out.println("훨 훨 잘 날아요~~"); 	}
}

class Bear {
	public void breathe() { System.out.println("곰 은 숨을 쉽니다 ~~"); }
	// @Override XXXXXX
	public void sound() { System.out.println("곰~곰 곰~~"); }
	public void special() { System.out.println("훨 훨 잘 날아요~~");	}
}
