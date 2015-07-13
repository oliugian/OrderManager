package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import Model.Order;

public class outputOrder {
public int printManagedOrder(String filePath,String dataPath,String savePath) throws RowsExceededException, WriteException, IOException{
	ArrayList<Order>outputResult=ManageOrder.analystOder(filePath, dataPath);
	String[] temp=filePath.split("\\\\");
	String outputName="(已处理)"+temp[temp.length-1];
	String outputPath=savePath+"\\"+outputName;
	System.out.println(outputPath);
	
	 WritableWorkbook book = null;
	try {
		book = Workbook.createWorkbook( new  File(outputPath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
		return 4;
	}
     //  生成名为“第一页”的工作表，参数0表示这是第一页 
     WritableSheet sheet  =  book.createSheet( " 第一页 " ,  0 );
	for (int i = 0; i < outputResult.size(); i++) {
    Order order=outputResult.get(i);
    String tempResult[]=handleOrdersSequence(order);
    for (int j = 0; j < tempResult.length; j++) {
		Label label=new Label(j, i, tempResult[j]);
				sheet.addCell(label);
					
	}
	}
		book.write();
		book.close();
return 0;

	
}
private  String [] handleOrdersSequence(Order order){
	String handledOrders[]=new String [27];
	handledOrders[0]=order.getSeller();
	handledOrders[1]=order.getSalesRecordNumber();
	handledOrders[2]=order.getUserId();
	handledOrders[3]=order.getBuyerFullname();
	handledOrders[4]=order.getBuyerCountry();
	handledOrders[5]=order.getBuyerAddress1();
	handledOrders[6]=order.getBuyerCity();
	handledOrders[7]=order.getBuyerState();
	handledOrders[8]=order.getBuyerZip();
	handledOrders[9]=order.getBuyerPhoneNumber();
	handledOrders[10]=order.getBuyerAddress2();
	handledOrders[11]=order.getBuyerEmail();
	handledOrders[12]=order.getItemNumber();
	handledOrders[13]=order.getItemTitle();
	handledOrders[14]=order.getCustomLabel();
	handledOrders[15]=order.getRemarks();
	handledOrders[16]=order.getQuantity();
	handledOrders[17]=order.getSalePrice();
	handledOrders[18]=order.getShippingAndHandling();
	handledOrders[19]=order.getUSTax();
	handledOrders[20]=order.getInsurance();
	handledOrders[21]=order.getCashOnDeliveryFee();
	handledOrders[22]=order.getTotalPrice();
	handledOrders[23]=order.getPaymentMethod();
	handledOrders[24]=order.getSaleDate();
	handledOrders[25]=order.getCheckoutDate();
	handledOrders[26]=order.getPaidonDate();
	return handledOrders;
	
}
}
