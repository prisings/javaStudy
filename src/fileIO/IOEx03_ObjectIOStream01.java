package fileIO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

// ** ObjectIOStream
// => 객체직렬화 Object Serialization  
//    객체가 가진 데이터들을 순차적인 데이터로 변환하는 것
// => ppt 23p

class IOEx03_ObjectIOStream01 {
	public static void main(String[] args) throws IOException {
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.dat"));
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.dat"));
        
        try {
               out.writeObject(new Date()); // 객체를 직렬화 해서 사용 
               out.flush();
               Date d = (Date) in.readObject();
               System.out.println(d);

		} catch(ClassNotFoundException e) {
				e.printStackTrace();       
        } finally {
        	// 스트림 소멸
            if (in != null) { in.close(); }
            if (out != null) { out.close(); }
            System.out.println("** Object I/O Stream Test 종료 **");
        } // finally
    } //main
} //class