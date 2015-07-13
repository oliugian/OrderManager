package Model;

import jxl.Cell;
import jxl.Sheet;

public class GetSerialNumber {
	public static int [] getSerialNumber(String path,String[]Message){
		 Sheet sheet  = sheetReadAccess.getSheet(path);		
		 int coluNum=sheet.getColumns();
		 int []serialNumber=new int[Message.length];
		 for (int i = 0; i < coluNum; i++) {
			 Cell c=sheet.getCell(i,0);
			  String r=c.getContents();
			  for (int j = 0; j < Message.length; j++) {
				if(Message[j].equals(r)){
				serialNumber[j]=i;
				}
			}
		}
		return serialNumber;
		
	}
}
