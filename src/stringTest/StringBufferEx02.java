package stringTest;

//** StringBuffer클래스  특징
// => 문자열처리 속도높고, 중간에 변경가능함

public class StringBufferEx02 {

	public static void main(String[] args) {
		System.out.println("******* String Buffer Test02 ****** ");
		String msg1="우리나라 ";
		String msg2="대한민국 ";
		String msg3="금수강산 ";
		String data  = msg1 + msg2 + msg3 ; //문자열연결
		System.out.println("String  연결  => " + data) ;

		StringBuffer  sb = new StringBuffer( );
		//sb=instance 변수
		sb.append(msg1);
		sb.append(msg2);  
		sb.append(msg3);
		System.out.println("StringBuffer02 sb => " +sb ) ;
		// sb 가 가진 값이  msg1 + msg2 + msg3 으로 변경됨.
		System.out.println("toString     => "+sb.toString() ) ; 
		//toString( )메소드는 문자열로 출력
	
		System.out.println("******* String Buffer Test02 ****** ");
		StringBuffer  sb1 = new StringBuffer("Java");
		StringBuffer  sb2 = sb1.append(" & Spring");
		System.out.println("StringBuffer02 sb1 => " +sb1 ) ;
		System.out.println("StringBuffer02 sb2 => " +sb2 ) ;
		System.out.println("sb1 == sb2 => " + (sb1==sb2)) ; // 대입문 처리 후 비교 결과는 ??? 
	
	}//main end	
} // class
