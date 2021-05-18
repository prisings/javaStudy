package fileIO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// ** ObjectIOStream
// => 객체직렬화 Object Serialization  
//    객체가 가진 데이터들을 순차적인 데이터로 변환하는 것
// => ppt 23p

class SBox implements Serializable {	
// => 객체 직렬화를 적용하려면 Serializable 을 implements 해야함.
//   java.io.NotSerializableException: fileIO.SBox...
	private static final long serialVersionUID = 1L;
	// Serializable 을 implements 하고 위의 상수를 정의 하지 않으면 경고
	// => 객체직렬화 및 역직렬화 과정에서 클래스의 버전을 확인하는 중요한 용도
	String name;
	int age;
    public SBox(String n, int a) { 
    	this.name = n; 
    	this.age = a;
    	}
    public void printS() { 
    	System.out.println("name:"+this.name+" , age:"+age);
    	}
} //SBox 

class IOEx03_ObjectIOStream02 {
	public static void main(String[] args) throws IOException {
	
		SBox box1 = new SBox("홍길동", 100);
	    SBox box2 = new SBox("John", 25);
		
	    ObjectOutputStream out = 
	            new ObjectOutputStream(new FileOutputStream("object.bin"));
		ObjectInputStream in = 
                new ObjectInputStream(new FileInputStream("object.bin"));
		try {
			out.writeObject(box1);
            out.writeObject(box2);
			
            SBox nbox1 = (SBox) in.readObject();
            nbox1.printS();

            SBox nbox2 = (SBox) in.readObject();
            nbox2.printS();            
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();       
        } finally {
        	// 스트림 소멸
            if (in != null) { in.close(); }
            if (out != null) { out.close(); }
            System.out.println("** Object I/O Stream Test2 종료 **");
        } // finally
    } //main
} //class