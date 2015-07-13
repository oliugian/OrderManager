package Views;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ExcelFileFilter extends FileFilter{

	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		 String name = file.getName();    
	        return file.isDirectory() || name.toLowerCase().endsWith(".xls") || name.toLowerCase().endsWith(".xlsx");  // ½ö
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "*.xls;*.xlsx";  
	}

}
