package stringTest;

// ** String, StringBuffer, StringBuilder 차이 및 장단점
// => https://ifuwanna.tistory.com/221

// * String
// => 불변(immutable) 속성을 가짐. 
//    그러므로 문자열의 연산(입력,수정,삭제등) 이 빈번한 경우 힙(Heap)메모리에 
//    많은 가비지(Garbage)가 생성되므로 비효율적.
// => equals 메서드를 오버라이딩 해서 문자열의 내용을 비교할수 있도록 했음.
// => 동기화 키워드를 지원하여 멀티쓰레드 환경에서 안전 (thread-safe)

// * StringBuffer / StringBuilder 
//   (정석 ch9, 477~ )
// => 내부적으로 buffer를 가지고 있으므로 가변성(mutable) 을 가짐.
//    인스턴스 생성시 크기 지정가능 (편집할 문자를 고려하여 충분히 잡는것이 좋음)
// => .append() .delete() 등을 이용하여 동일 객체내에서 문자열 변경가능
//    그러므로 문자열의 연산(입력,수정,삭제등)이 빈번한 경우 String 보다적합.

// => StringBuffer vs StringBuilder 차이점은 동기화의 유무
// => 동기화 유무 
//    - StringBuffer : 동기화 키워드를 지원하여 멀티쓰레드 환경에서 안전 (thread-safe)
//    - StringBuilder: 동기화를 지원하지 않으므로 멀티쓰레드 환경에서 적합하지 않지만
//                     단일쓰레드에서의 성능은 StringBuffer 보다 뛰어남.

// => equals 메서드 오버라이딩 하지 않았기 때문에 내용을 비교하지 않으므로 '==' 과 동일결과 .
// => toString 은 오버라이딩 되어 있어서 담고있는 문자열을 String으로 반환 한다.  

class StringBufferEx01 {
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");

		System.out.println("sb1 == sb2 ? " + (sb1 == sb2));
		System.out.println("sb1.equals(sb2) ? " + sb1.equals(sb2));
		
		// StringBuffer의 내용을 String으로 변환한다.
		String s1  = sb1.toString();	// String s = new String(sb);와 같다.
		String s2 = sb2.toString();

		System.out.println("s1.equals(s2) ? " + s1.equals(s2));
	} // main
} // class
