package Controller;

import java.io.IOException;

import jxl.write.WriteException;

public class OrderController {

	public int startToWork(String filePath,String dataPath,String savePath){
		int state=checkData.dataCheck(dataPath, filePath);
		if(state==0){
			try {
				state=new outputOrder().printManagedOrder(filePath, dataPath, savePath);
				return state;
			} catch (WriteException | IOException e) {
				// TODO Auto-generated catch block				
				e.printStackTrace();
				return 3;
			}
		}
		return state;
	}
}
