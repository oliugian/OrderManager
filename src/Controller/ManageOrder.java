package Controller;

import java.util.ArrayList;

import Model.GetAllData;
import Model.GetOrders;
import Model.Order;
import Model.Product;

public class ManageOrder {
public static ArrayList<Order> analystOder(String filePath,String dataPath){
	ArrayList<Order>orders=new GetOrders().getExcelDate(filePath);
	ArrayList<Product>products=new GetAllData().getExcelDate(dataPath);

	for (int i = 1; i < orders.size(); i++) {
		//跳过第一行
		for (int j = 0; j < products.size(); j++) {
		
			if(orders.get(i).getItemTitle().equals(products.get(j).getItemTitle())){
				orders.get(i).setBuyerAddress2(products.get(j).getProductName());
			    orders.get(i).setUSTax(products.get(j).getProductPrice());
			}
		}
	}
	return orders;
	
}
}
