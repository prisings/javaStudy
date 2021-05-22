package stringTest ;

// ** StringBuilder
// => StringBuffer 와 동일하나 동기화 키워드를 지원하지 않으므로 
//    "thread-safe" 하지않으나 단일쓰레드에서의 성능은 StringBuffer 보다 뛰어남.

class StringBuilderEx {
	
	public static void main(String[] args) 	{
		StringBuilder strBuf=new StringBuilder("AB");
		strBuf.append(25);
		strBuf.append('Y').append(true);
		System.out.println(strBuf);		
		
		strBuf.insert(2, false);
		strBuf.insert(strBuf.length(), 'Z');
		System.out.println(strBuf);
	}
}