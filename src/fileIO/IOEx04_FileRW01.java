package fileIO;
import java.io.*;

// ** 문자 스트림
// => 완성된 화일을 메모장 또는 이클립스에서 열어보면
//    Byte Stream 과는 다르게 운영체제에 맞게 인코딩 되어있음을 알 수 있다.  

// => 실습: OS 상에서 확인할 수 있는 형태로 알파벳 저장 & 출력 하기
class IOEx04_FileRW01 {
	public static void main(String[] args) throws IOException {
		
		Writer out=new FileWriter("alphabet.txt");
		Reader in=new FileReader("alphabet.txt");
		
		try {
			for(int ch = (int)'A'; ch < (int)('Z'+1); ch++)
                out.write(ch); 
			out.flush();
			// 또는 out.close(); 
			// flush() 또는 close() 시 write 됨
			// => write 되어야 아래에서 read 가능함
			
			char[] cbuf=new char[28];
			int readCnt;
			readCnt=in.read(cbuf, 0, cbuf.length);
			for(int i=0; i<readCnt; i++)
				System.out.print(cbuf[i]+" ");
		} finally {
			if (in != null) { in.close(); }
            if (out != null) { out.close(); }
            System.out.println("\n** FileReader & FileWriter Test1 종료 **");
		} // finally
	} //main
} //class