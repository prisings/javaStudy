package fileClass;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

//현재 폴더에 속한 파일과 폴더의 이름과 크기 등 정보 출력. 
class FileEx01_04infoList {
	public static void main(String[] args){
		String currDir = System.getProperty("user.dir");
		System.out.println("**  "+currDir+"  Information **");
		
		File dir = new File(currDir);

		File[] files = dir.listFiles();

		for(int i=0; i < files.length; i++) {
			File f = files[i];
			String name = f.getName();
			SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mma");
			String attribute = "";
			String size = "";

			if(files[i].isDirectory()) {
				attribute = "DIR";
			} else {
				size = f.length() + "";
				attribute  = f.canRead()  ? "R" : " ";	
				attribute += f.canWrite() ? "W" : " ";
				attribute += f.isHidden() ? "H" : " ";	
			}

			System.out.printf("%s %3s %6s %s%n", df.format(new Date(f.lastModified())), attribute, size, name );
		}
	}
} // end of class
