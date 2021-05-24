package absInterface;
// ** 캡슐화(Encapsulation)
// 1. 은닉 (보호) : 접근 제어자를 이용
// => 외부로부터 데이터를 보호하고,
//    내부적으로만 사용되는 부분은 감추어 준다 
// 2. 단위 기능 모듈화
// => 세분화 되어있는 모듈을 하나의 기능으로 처리할 수 있도록 묶어준다.
// => 종합 감기약 처럼 
// => 세분화 되어있는 모듈을 사용하면서 호출 순서에 따른 오류 등
//    발생가능한 논리적 오류를 예방하고, 생산성 및 유지보수 에 유리     
// ** 실습
// 감기 증상 : 두통, 콧물, 몸살
class HeadacheCap {
	void take() { System.out.println(" 두통 해결 ~~"); }
} // HeadacheCap
class SinivelCap {
	void take() { System.out.println(" 콧물 해결 ~~"); }
} // SinivelCap
class BodyPainCap {
	void take() { System.out.println(" 몸살 해결 ~~"); }
} // BodyPainCap

// 환자 발생 1 (BadCase Encapsulation)
// => 증상별 복용 순서에 따라 처방 받고 복용한다.
// => 세분화 되어있는 모듈을 사용하는 경우
class ColdPatient {
	void takeHead(HeadacheCap hc) { hc.take(); }  
	void takeSinivel(SinivelCap hc) { hc.take(); } 
	void takeBodyPain(BodyPainCap hc) { hc.take(); } 
}
 
// GoodCase Encapsulation
// => 증상별 복용 순서에 따른 처방을 캡슐화 한다.
// => 종합 감기약 (캡슐화)
class TotalCap {
	
	HeadacheCap hc = new HeadacheCap();
	SinivelCap sc = new SinivelCap();
	BodyPainCap bc = new BodyPainCap();
	
	void take() {
		// 처방에 따른 복용 순서
		hc.take();
		sc.take();
		bc.take();
	}
} // TotalCap

//=> 환자 발생 2 는 종합감기약 만 처방 받으면 됨
class NewPatient {
	void takeTotal(TotalCap tc) { tc.take(); }  
} 

public class EncapsulationEx {

	public static void main(String[] args) {
		// 환자 발생 1
		// => 인스턴스 생성, 메서드 호출 
		// => 단점 : 메서드 호출 순서는 사용자 맘대로 할 수 있다
		//          이로인해 부정확한 결과 가능성
		// => 컴파일오류, 런타임오류, 논리적오류(Logical Error)
		ColdPatient cp1 = new ColdPatient() ;
		cp1.takeBodyPain(new BodyPainCap());
		cp1.takeHead(new HeadacheCap());
		cp1.takeSinivel(new SinivelCap());
		
		// 환자 발생 2 
		NewPatient np = new NewPatient();
		np.takeTotal(new TotalCap());
		
	} // main
} // class
