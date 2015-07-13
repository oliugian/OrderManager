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
		
		JLabel label = new JLabel("��������");
		panel.add(label);
		label.setFont(new Font("����", Font.PLAIN, 33));
		label.setForeground(Color.RED);
		label.setBounds(223, 10, 132, 62);
		
		
		JLabel lblNewLabel = new JLabel("��ǰ�ļ����λ�ã�");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 85, 144, 19);
		
		
		JLabel label_1 = new JLabel("��ǰ�����ݵ�λ�ã�");
		panel.add(label_1);
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_1.setBounds(10, 137, 144, 19);
		
		
		JLabel label_2 = new JLabel("ѡ���ļ���");
		panel.add(label_2);
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
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
	
		
		
		
		
		JButton btnNewButton = new JButton("�������λ��");
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
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
	
		
		JButton button = new JButton("����");
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
		button.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		button.setBounds(434, 133, 140, 27);
		
		
		JButton button_1 = new JButton("ѡ���ļ�");
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
		button_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		button_1.setBounds(434, 182, 140, 27);
		
		
		JButton button_2 = new JButton("������");
		panel.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean canWork=false;
			if(savePath.equals("")){
				JOptionPane.showConfirmDialog(null, "������һ�����·��","Attention",JOptionPane.OK_OPTION);
			}else if(dataPath.equals("")){
				JOptionPane.showConfirmDialog(null, "��ѡ��һ����ȷ��������·��","Attention",JOptionPane.OK_OPTION);
			}else if(filePath.equals("")){
				JOptionPane.showConfirmDialog(null, "��ѡ��һ��Ҫ������ļ�","Attention",JOptionPane.OK_OPTION);
			}
			if(!(savePath.equals(""))&&(!(dataPath.equals("")))&&(!(filePath.equals("")))){
				canWork=true;
			}
			
			if(canWork){
				int state=new OrderController().startToWork(filePath, dataPath, savePath);
				if (state==0) {
					JOptionPane.showConfirmDialog(null, "����ɹ�","Attention",JOptionPane.OK_OPTION);
					String paths[]={savePath,dataPath,fileFolderPath};
					pathManage.setPath(paths);
				}else if(state==1){
					JOptionPane.showConfirmDialog(null, "�Աȵ������ݸ�ʽ����","Attention",JOptionPane.OK_OPTION);
				}else if(state==2){
					JOptionPane.showConfirmDialog(null, "����Ķ�����ʽ����","Attention",JOptionPane.OK_OPTION);
				}else if(state==3){
					JOptionPane.showConfirmDialog(null, "����ʧ�ܣ�û��ȥ����ܣ�","Attention",JOptionPane.OK_OPTION);
				}else if(state==4){
					JOptionPane.showConfirmDialog(null, "���Ҫ������ļ��رգ�","Attention",JOptionPane.OK_OPTION);
				}
			}
			
		
			}
		});
		button_2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		button_2.setBounds(434, 227, 140, 27);
		
		

		
	
	}
}
