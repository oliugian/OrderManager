package Model;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class sheetCreateAccess {
	public static WritableSheet getSheet(String path){
		 WritableWorkbook book;
		 WritableSheet sheet = null;
		try {
			book  =  Workbook.createWorkbook( new File(path));
			 sheet  =  book.createSheet( " µÚÒ»Ò³ " ,  0 );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sheet;
		
	}
}
