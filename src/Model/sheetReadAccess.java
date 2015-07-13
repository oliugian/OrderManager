package Model;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class sheetReadAccess {
	static Workbook book;
public static Sheet getSheet(String path){
	 Sheet sheet = null;
	 WorkbookSettings workbookSettings = new WorkbookSettings();
     workbookSettings.setEncoding("ISO-8859-1");
	try {
		book = Workbook.getWorkbook( new  File(path),workbookSettings);
		sheet  =  book.getSheet(0);
	} catch (BiffException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return sheet;	
}
public static void setBookClose(){
	book.close();
}
}
