package fileIO;
import java.io.*;

class IOEx05_BufferedRW {
	public static void main(String[] args) throws IOException {
		
		BufferedWriter out = 
                new BufferedWriter(new FileWriter("String.txt"));
		BufferedReader in = 
				new BufferedReader(new FileReader("String.txt"));
		
		String ks = "공부에 있어서 돈이 꼭 필요한 것은 아니다.";
        String es = "Life is long if you know how to use it.";
        String str;
		try {
			out.write(ks, 0, ks.length());
			// 문자열 ks를, 인덱스 0 부터, length 개 까지 저장 
			out.newLine(); // OS 에 정의된 줄바꿈 문자를 추가함
			out.write(es, 0, es.length()); 
            out.flush();
            
			while(true) {
                str = in.readLine(); // 한문장 읽어들이기
                if(str == null) // 더이상 반환할 문자열이 없으면 null 을  return
                    break;
                System.out.println(str);
            }
		} finally {
			if (in != null) { in.close(); }
            if (out != null) { out.close(); }
            System.out.println("** BufferedReader & BufferedWriter Test 종료 **");
		} // finally
	} //main
} //class