package stringTest;

//** StringBuffer클래스  메서드  (정석 480 ~ 481 p) 
// => String 클래스와 유사한 메서드를 많이 가지고 있으며,
//    저장된 내용을 변경 할 수있는 insert, replace, delete 등을 추가로 제공한다. 

// => append : 문자열로 이어줌
// => deleteCharAt(10) : 지정된 위치의 문자 제거  
// => delete(3,6) : 3~6 사이의 문자 제거
// => insert(int pos, "abc") : pos 위치에 문자열 "abc" 삽입
//           단, pos 는 0 부터 시작.               
// => replace(int s, int e, "END")
//    s <= ~ < e 구간의 문자열을 "END" 로 변경함.
// => capacity() : StringBuffer 인스턴스의 buffer 크기
// => length() : buffer에 담긴 문자열의 길이

class  StringBufferEx03 {
	public static void main(String[] args) {
		StringBuffer sb  = new StringBuffer("01");
		StringBuffer sb2 = sb.append(23);
		sb.append('4').append(56);
		
		StringBuffer sb3 = sb.append(78);			
		sb3.append(9.0);

		System.out.println("sb ="+sb);
		System.out.println("sb2="+sb2);
		System.out.println("sb3="+sb3);

		System.out.println("sb ="+sb.deleteCharAt(10));
		System.out.println("sb ="+sb.delete(3,6));
		System.out.println("sb ="+sb.insert(3,"abc"));
		System.out.println("sb ="+sb.replace(6, sb.length(), "END"));

		System.out.println("capacity="+sb.capacity());
		System.out.println("length="+sb.length());
	} // main
} // class
