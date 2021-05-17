package fileClass;
import java.io.File;

class FileEx02_02Move {
	public static void main(String[] args) 	{
/*		
		File myFile=new File("D:\\MTest\\MyWork\\Java02\\src\\jdbc02\\MyStudent.java");
		if(myFile.exists()==false) 	{
			System.out.println("원본 파일이 준비되어 있지 않습니다.");
			return;
		}
	
		File reDir=new File("D:\\MTest\\MyWork\\Java02\\src\\jdbc01");
		if(!reDir.exists()) { // reDir 디렉터리가 존재하는지 검사
			reDir.mkdir();    // 존재하지 않으면 디렉토리 생성
		}
		
		File reFile=new File(reDir, "StudentVO.java");
		myFile.renameTo(reFile);
		// 화일명의 변경사항에 디렉토리도 포함되므로 위치가 변경됨
		if(reFile.exists()==true)
			System.out.println("파일 이동에 성공하였습니다.");
		else
			System.out.println("파일 이동에 실패하였습니다.");
*/			
		// 만약 삭제 안되면 (다른곳에서 잡고 있어서)  System.gc(); 추가
		// 그래도 안되면  뒤에 System.runFinalization() ;
		File delFile=new File("D:\\MTest\\MyWork\\Java02\\src\\jdbc01\\DeleteTest.java");
		delFile.delete();  
		if(delFile.exists()==true)
			System.out.println("파일 삭제에 실패하였습니다.");
		else
			System.out.println("파일 삭제에 성공하였습니다.");
	} //main
} // class