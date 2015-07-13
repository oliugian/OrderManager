package Model;

import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;

public class GetOrders {
      String [] OrderMessage={"Seller","Sales Record Number","User Id","Buyer Fullname","Buyer Phone Number","Buyer Email","Buyer Address 1","Buyer Address 2","Buyer City","Buyer State","Buyer Zip","Buyer Country","Item Number","Item Title","Custom Label","Remarks","Quantity","Sale Price","Shipping and Handling","US Tax","Insurance","Cash on delivery fee","Total Price","Payment Method","Sale Date","Checkout Date","Paid on Date"};
  	public  String[] getOrderMessage(){
  		return OrderMessage;
  	}
     public ArrayList<Order> getExcelDate(String path) {
		// TODO Auto-generated method stub
		  ArrayList<Order> Orders=new ArrayList<Order>();
		      Sheet sheet  = sheetReadAccess.getSheet(path);
		      int []serialNumber=GetSerialNumber.getSerialNumber(path,OrderMessage);
			  int coluNum=sheet.getColumns();
			  int rowsNum=sheet.getRows();
			  for(int i=0;i<rowsNum;i++){
				  String temp[]=new String [coluNum];
				  for (int j = 0; j < coluNum; j++) {
					  Cell c=sheet.getCell(j,i);
					  String r=c.getContents();
					  temp[j]=r;
				}
			   sheetReadAccess.setBookClose();
               Order order=new Order();
               order.setSeller(temp[serialNumber[0]]);
               order.setSalesRecordNumber(temp[serialNumber[1]]);
               order.setUserId(temp[serialNumber[2]]);
               order.setBuyerFullname(temp[serialNumber[3]]);
               order.setBuyerPhoneNumber(temp[serialNumber[4]]);
               order.setBuyerEmail(temp[serialNumber[5]]);
               if(!(temp[serialNumber[7]].equals(""))){
            	   if(temp[serialNumber[7]].equals("Buyer Address 2")){
            		   order.setBuyerAddress1(temp[serialNumber[6]]);  
            	   }else{
            		   order.setBuyerAddress1(temp[serialNumber[6]]+","+temp[serialNumber[7]]);       
            	   }
            	         
                   order.setBuyerAddress2("");
               }else {
            	   order.setBuyerAddress1(temp[serialNumber[6]]);               
                   order.setBuyerAddress2(temp[serialNumber[7]]);
			}
               
               
               order.setBuyerCity(temp[serialNumber[8]]);
               order.setBuyerState(temp[serialNumber[9]]);
               order.setBuyerZip(temp[serialNumber[10]]);
               order.setBuyerCountry(temp[serialNumber[11]]);
               order.setItemNumber(temp[serialNumber[12]]);
               order.setItemTitle(temp[serialNumber[13]]);
               order.setCustomLabel(temp[serialNumber[14]]);
               order.setRemarks(temp[serialNumber[15]]);
               order.setQuantity(temp[serialNumber[16]]);
               order.setSalePrice(temp[serialNumber[17]]);
               order.setShippingAndHandling(temp[serialNumber[18]]);
               order.setUSTax(temp[serialNumber[19]]);
               order.setInsurance(temp[serialNumber[20]]);
               order.setCashOnDeliveryFee(temp[serialNumber[21]]);
               order.setTotalPrice(temp[serialNumber[22]]);
               order.setPaymentMethod(temp[serialNumber[23]]);
               order.setSaleDate(temp[serialNumber[24]]);
               order.setCheckoutDate(temp[serialNumber[25]]);
               order.setPaidonDate(temp[serialNumber[26]]);
               Orders.add(order);
			  }	
					        
		return Orders;
	}
}
