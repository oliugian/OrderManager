package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class pathManage {
public static String[] getPath(){
	String []path=new String [3];
	for (int i = 0; i < path.length; i++) {
		path[i]="";
	}
	try {
		BufferedReader reader=new BufferedReader(new FileReader(new File("defaultFolder.txt")));
		String temp=null;
		int line=0;
		while((temp=reader.readLine())!=null){
			 if(line>2){
            	 break;
             }
			path[line]=temp;
             line++;
            
		}
		reader.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return path;
}
   public static void setPath(String []paths){
	   try {
		FileOutputStream outputStream=new FileOutputStream(new File("defaultFolder.txt"));
	    for (int i = 0; i < paths.length; i++) {
			outputStream.write((paths[i]+"\r\n").getBytes());
		}
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
