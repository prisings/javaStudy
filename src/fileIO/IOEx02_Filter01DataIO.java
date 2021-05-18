package fileIO;
import java.io.*;

// ** Filter I/O Stream 1.
// => Data I/O Stream
// => 기본 자료형 단위의 데이터 입출력을  가능하게 하는 필터 스트림
// => ppt 20-21p

class IOEx02_Filter01DataIO {
	public static void main(String[] args) throws IOException {
		
		// ** 생성순서 주의 : RunTime 오류 발생 
		// 1) 기본자료형 단위의 출력을 위한 DataOutputStream 생성
		// => 출력 스트림을 생성하여 DataOutput 필터스트림과 연결한다. 
//		FileOutputStream fout = new FileOutputStream("data.bin");
//		DataOutputStream out = new DataOutputStream(fout);
		DataOutputStream out = new DataOutputStream(new FileOutputStream("data.bin"));
		// => 인자로 전달된 출력 스트림과 연결된 DataOutputStream 객체를 생성   
		 
        // 2) 기본 자료형 단위의 데이터 입력을 위한 DataInputStream 생성
		// => read 스트림이므로 "data.bin" 파일이 존재해야 생성됨
		//    java.io.FileNotFoundException: data.bin (지정된 파일을 찾을 수 없습니다)
		DataInputStream in = new DataInputStream(new FileInputStream("data.bin"));
       
        try {
               out.writeDouble(3.14);
               out.writeInt(100);
               out.writeUTF("자신의 생각을 바꾸지 못하는 사람은 결코 현실을 바꿀 수 없다.");
               // read 시는 저장된 순서에 따라 처리함
               // => 그러므로 순서와 타입을 지켜야함.
               double d = in.readDouble() ;
               int i = in.readInt();
               String s = in.readUTF(); 
               System.out.println("** double d = "+d);
               System.out.println("** int i = "+i);
               System.out.println("** String s = "+s);
        } finally {
        	// 스트림 소멸
            if (in != null) { in.close(); }
            if (out != null) { out.close(); }
            System.out.println("** Data I/O 종료 **");
        } // finally
    } //main
} //class