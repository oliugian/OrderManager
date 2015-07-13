package Model;


import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;


public class GetAllData{
 String [] productMessage={"Item Title","产品","价格","拿货大楼","准确地址"};

	public ArrayList<Product> getExcelDate(String path) {
		// TODO Auto-generated method stub
		  ArrayList<Product> Products=new ArrayList<Product>();
		      Sheet sheet  = sheetReadAccess.getSheet(path);
		      int []serialNumber=GetSerialNumber.getSerialNumber(path,productMessage);
			  int coluNum=sheet.getColumns();
			  int rowsNum=sheet.getRows();
			  for(int i=0;i<rowsNum;i++){
				  //i=1忽略表第一行
				  String temp[]=new String [coluNum];
				  for (int j = 0; j < coluNum; j++) {
					  Cell c=sheet.getCell(j,i);
					  String r=c.getContents();
					  temp[j]=r;
				}
				sheetReadAccess.setBookClose();
				Product product=new Product();
				product.setItemTitle(temp[serialNumber[0]]);
				product.setProductName(temp[serialNumber[1]]);
				product.setProductPrice(temp[serialNumber[2]]);
				product.setProductPlace(temp[serialNumber[3]]);
				product.setDetailPlace(temp[serialNumber[4]]);
				Products.add(product);                   
			  }	
					
					
          //  获得第一个工作表对象 
		return Products;
	}


}
