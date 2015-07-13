package Views;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import Controller.OrderController;
import Controller.outputOrder;
import Model.pathManage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;


import javax.swing.JPanel;

public class MainFrame extends JFrame{
	File file;
	File file_1;
	File file_2;
	String fileFolderPath;
	String dataPath;
	String savePath;
	String filePath="";
	public MainFrame() {
	
		this.setVisible(true);
		this.setSize(600, 325);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		setLocationRelativeTo(getOwner());
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 574, 276);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		String tempPath[]=pathManage.getPath();
        savePath=tempPath[0];
        dataPath=tempPath[1];
        fileFolderPath=tempPath[2];
		
		JLabel label = new JLabel("订单处理");
		panel.add(label);
		label.setFont(new Font("宋体", Font.PLAIN, 33));
		label.setForeground(Color.RED);
		label.setBounds(223, 10, 132, 62);
		
		
		JLabel lblNewLabel = new JLabel("当前文件输出位置：");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 85, 144, 19);
		
		
		JLabel label_1 = new JLabel("当前总数据的位置：");
		panel.add(label_1);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_1.setBounds(10, 137, 144, 19);
		
		
		JLabel label_2 = new JLabel("选择文件：");
		panel.add(label_2);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_2.setBounds(10, 170, 80, 42);
	
		

		final JTextField textField;
		final JTextField textField_1;
		final JTextField textField_2;
		
		textField = new JTextField();
		panel.add(textField);
		textField.setBounds(160, 82, 264, 27);
		textField.setEditable(false);
		textField.setText(savePath);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setBounds(160, 134, 264, 27);
		textField_1.setEditable(false);
		textField_1.setText(dataPath);
	
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		textField_2.setBounds(100, 179, 324, 27);
	
		
		
		
		
		JButton btnNewButton = new JButton("设置输出位置");
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc=new JFileChooser();  
		        
		      
			    jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY ); 
		        jfc.setCurrentDirectory(new File(savePath));
		        jfc.showOpenDialog(null);
	     
		        file=jfc.getSelectedFile(); 
		        if(file!=null){
		        	 savePath=file.getAbsolutePath();
				     textField.setText(file.getAbsolutePath());
		        }
		       
		        
			}
		});
		btnNewButton.setBounds(434, 81, 140, 27);
	
		
		JButton button = new JButton("设置");
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				      
				JFileChooser jfc=new JFileChooser();  
				ExcelFileFilter excelFileFilter=new ExcelFileFilter();
				jfc.addChoosableFileFilter(excelFileFilter);
				jfc.setFileFilter(excelFileFilter);
		        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY );  
		        jfc.setCurrentDirectory(new File(dataPath));
		        jfc.showOpenDialog(null);	       
		        file_1=jfc.getSelectedFile(); 
		        if(file_1!=null){
		        	 dataPath=file_1.getAbsolutePath();
				     textField_1.setText(file_1.getAbsolutePath());
		        }
		       
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		button.setBounds(434, 133, 140, 27);
		
		
		JButton button_1 = new JButton("选择文件");
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();  
				ExcelFileFilter excelFileFilter=new ExcelFileFilter();
				jfc.addChoosableFileFilter(excelFileFilter);
				jfc.setFileFilter(excelFileFilter);
		        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY );  
		        jfc.setCurrentDirectory(new File(fileFolderPath));
		        jfc.showOpenDialog(null);
		       
		     
		        file_2=jfc.getSelectedFile(); 
		        if(file_2!=null){
		        	 filePath=file_2.getAbsolutePath();
				     textField_2.setText(file_2.getAbsolutePath());
				     fileFolderPath=jfc.getCurrentDirectory().getAbsolutePath();
				     System.out.println(fileFolderPath);
		        	
		        }	
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		button_1.setBounds(434, 182, 140, 27);
		
		
		JButton button_2 = new JButton("处理订单");
		panel.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean canWork=false;
			if(savePath.equals("")){
				JOptionPane.showConfirmDialog(null, "请设置一个输出路径","Attention",JOptionPane.OK_OPTION);
			}else if(dataPath.equals("")){
				JOptionPane.showConfirmDialog(null, "请选择一个正确的总数据路径","Attention",JOptionPane.OK_OPTION);
			}else if(filePath.equals("")){
				JOptionPane.showConfirmDialog(null, "请选择一个要处理的文件","Attention",JOptionPane.OK_OPTION);
			}
			if(!(savePath.equals(""))&&(!(dataPath.equals("")))&&(!(filePath.equals("")))){
				canWork=true;
			}
			
			if(canWork){
				int state=new OrderController().startToWork(filePath, dataPath, savePath);
				if (state==0) {
					JOptionPane.showConfirmDialog(null, "处理成功","Attention",JOptionPane.OK_OPTION);
					String paths[]={savePath,dataPath,fileFolderPath};
					pathManage.setPath(paths);
				}else if(state==1){
					JOptionPane.showConfirmDialog(null, "对比的总数据格式有误","Attention",JOptionPane.OK_OPTION);
				}else if(state==2){
					JOptionPane.showConfirmDialog(null, "输入的订单格式有误","Attention",JOptionPane.OK_OPTION);
				}else if(state==3){
					JOptionPane.showConfirmDialog(null, "处理失败，没错，去找你弟！","Attention",JOptionPane.OK_OPTION);
				}else if(state==4){
					JOptionPane.showConfirmDialog(null, "请把要输出的文件关闭！","Attention",JOptionPane.OK_OPTION);
				}
			}
			
		
			}
		});
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		button_2.setBounds(434, 227, 140, 27);
		
		

		
	
	}
}
