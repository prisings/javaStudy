package try_Catch;

public class Try_Catch {

	public static void main(String[] args) {
/*		 Error(에러)와 Exception(예외의 차이) 
		 에러(Error)란 컴퓨터 하드웨어의 오동작 또는 고장으로 인해 응용프로그램에 이상이 생겼거나 JVM 실행에 문제가 생겼을 경우 발생하는것을 말합니다. 이 경우 개발자는 대처할 방법이 극히 제한적입니다. 하지만 예외(Exception)은 다릅니다. 예외란 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인해 발생하는 프로그램 오류를 말합니다. 예외가 발생하면 프로그램이 종료가 된다는것은 에러와 동일하지만 예외는 예외처리(Exception Handling)을 통해 프로그램을 종료 되지 않고 정상적으로 작동되게 만들어줄 수 있습니다. 자바에서 예외처리는 Try Catch문을 통해 해줄 수 있습니다.



		  여러가지 예외들 
		  예외 구문

		 이유 

		 ArithmeticException

		 정수를 0으로 나눌경우 발생 

		 ArrayIndexOutOfBoundsExcetion

		 배열의 범위를 벗어난 index를 접근할 시 발생

		 ClassCastExcetion

		 변환할 수 없는 타입으로 객체를 반환 시 발생 

		 NullPointException 

		  존재하지 않는 레퍼런스를 참조할때 발생 

		 IllegalArgumentException

		 잘못된 인자를 전달 할 때 발생 

		 IOException

		 입출력 동작 실패 또는 인터럽트 시 발생 

		 OutOfMemoryException 

		 메모리가 부족한 경우 발생  

		 NumberFormatException 

		 문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환시 발생 



		 ※ 빈도수가 높은 예외

		 NullPointException

		 자바 프로그램에서 가장 빈번하게 발생하는 에러입니다. 이 에러는 객체 참조가 없는 상태, 즉 null 값을 갖는 참조변수로 객체 접근 연사자인 토드(.)를 사용했을 때 발생합니다. 객체가 없는 상태에서 객체를 사용하려 했으니 예외가 발생하는 것입니다.



		 ArrayIndexOutOfBoundsExcetion

		 배열에서 인덱스 범위를 초과하여 사용할 경우 발생합니다. 예를 들어 길이가 3인 int[]arr = new int[3] 배열을 선언했다면 0 ~ 2까지의 index만 사용할 수 있습니다. 하지만 이 배열의 index가 -1 이나 3을 참조하는 순간 예외가 발생합니다.



		 NumberFormatException 

		 개발을 하다보면 문자열로 되어있는 데이터를 숫자타입으로 변경하는 경우가 자주발생하는데 숫자타입으로 변경할 수 없는 문자를 치환시키려고 하면 발생하는 에러입니다.



		 ClassCastExcetion

		 타입 변환은 상위 클래스와 하위클래스간에 발생하고 구현 클래스와 인터페이스간에도 발생합니다. 이런 관계가 아니면 클래스는 다른 클래스로 타입을 변환할 수 없습니다. 하지만 이 규칙을 무시하고 억지로 타입을 변환시킬경우 발생하는 에러입니다.

*/



//		  예외 처리코드 (Try Catch) 
		 try{
		     //에러가 발생할 수 있는 코드
		     throw new Exception(); //강제 에러 출력 
		 }catch (Exception e){
		     //에러시 수행
		      e.printStackTrace(); //오류 출력(방법은 여러가지)
	//	      throw e; //최상위 클래스가 아니라면 무조건 던져주자
		 }finally{
		     //무조건 수행
		 } 
	}

}
