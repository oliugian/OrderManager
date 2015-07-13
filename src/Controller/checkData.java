package Controller;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableWorkbook;
import Model.sheetReadAccess;

public class checkData {
	static String [] productMessage={"Item Title","产品","价格","拿货大楼","准确地址"};
    static String [] OrderMessage={"Seller","Sales Record Number","User Id","Buyer Fullname","Buyer Phone Number","Buyer Email","Buyer Address 1","Buyer Address 2","Buyer City","Buyer State","Buyer Zip","Buyer Country","Item Number","Item Title","Custom Label","Remarks","Quantity","Sale Price","Shipping and Handling","US Tax","Insurance","Cash on delivery fee","Total Price","Payment Method","Sale Date","Checkout Date","Paid on Date"};
    
public static int dataCheck(String dataPath,String OrderPath){
	int state=0;
	  Sheet sheet  = sheetReadAccess.getSheet(dataPath);
	  int DatacoluNum=sheet.getColumns();
	  int dataCount=0,orderCount=0;
		  for (int j = 0; j < DatacoluNum; j++) {
			  Cell c=sheet.getCell(j,0);
			  String r=c.getContents();
			  for (int i = 0; i < productMessage.length; i++) {
				if(r.equals(productMessage[i])){
					dataCount++;
				}
			}
		}
		  sheetReadAccess.setBookClose();
		  
    Sheet sheet_1  = sheetReadAccess.getSheet(OrderPath);
	  int OrdercoluNum=sheet_1.getColumns();
		  for (int j = 0; j < OrdercoluNum; j++) {
			  Cell c=sheet_1.getCell(j,0);
			
			
			  String r1=c.getContents();
			  for (int i = 0; i < OrderMessage.length; i++) {
					if(r1.equals(OrderMessage[i])){
						orderCount++;
					}
				}
		}
		  sheetReadAccess.setBookClose();
		  if(dataCount!=productMessage.length){
			  state=1;
			  return state;
		  }else if(orderCount!=OrderMessage.length){
			  state=2;
			  return state;
		  }	
		  
		
      
	  return state;	
}
}
