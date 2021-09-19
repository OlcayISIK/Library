import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class LibraryCapacity {

	 int z=1;
	
	public void getFrame() 
	{
		ArrayList<String> itemlist = new ArrayList<String>(); 
		ArrayList<String> notelist = new ArrayList<String>();
		 List list = new Books();
		itemlist = list.Execute();
		 list = new Notes(); 
		 notelist = list.Execute(); 
	
		 
		 
		  JFrame frame= new JFrame("Library");
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	       
	    	JLabel label = new JLabel();
			ImageIcon icon = new ImageIcon("capacity.jpg");
			label.setSize(600,600); 
			label.setLocation(0,0);   
			label.setIcon(icon);    
			
	       JPanel panel=new JPanel();
	        panel.setLayout(null); 
	        panel.setBounds(0, 0, 1024, 1024); 
	        
	        
	        DefaultTableModel list1=new DefaultTableModel();
	        list1.addColumn("Books");
	        JTable table =new JTable(list1); 
	        table.setLayout(new BorderLayout()); 
	        JScrollPane spanel=new JScrollPane(table);
	        spanel.setSize(200, 200);
	        spanel.setLocation(0,0);
	         
	        int i=0;
	         while(i < itemlist.size())   
	         { 
	        	 
	        	 list1.addRow(new Object[] {itemlist.get(i)});    
	             i++; 
	         }
	          
		        DefaultTableModel list2=new DefaultTableModel();
		        list2.addColumn("Notes"); 
		         
		        JTable table2 =new JTable(list2);  
		        table2.setLayout(new BorderLayout());  
		        JScrollPane spanel2=new JScrollPane(table2);
		        spanel2.setSize(200, 200);
		        spanel2.setLocation(0,200);
		        
		        int j=0;
		         while(j < notelist.size())    
		         { 
		        	 
		        	 list2.addRow(new Object[] {notelist.get(j)});      
		             j ++; 
		         }
		         
		         File file=new File("Books.txt");
		 		ArrayList<String> bookNumb = new ArrayList<String>();
		 		Scanner read;
		 		try {
		 			read = new Scanner(file); 
		 			while(read.hasNextLine())
		 			{ 
		 		       String write=read.nextLine();  
		 		       bookNumb.add(write);  
		 			}
		 		} catch (FileNotFoundException e2) {
		 			// TODO Auto-generated catch block
		 			e2.printStackTrace();
		 		}  
		 		 Context context = new Context(new FindStock());
		 		 int a=0;
		 		 
		 		for (int k=4;k<bookNumb.size();k+=7) {
		 			
		 			a += context.executeStrategy(Integer.valueOf(bookNumb.get(k)),0);
		 		}
		 		
		 		JLabel totalstock=new JLabel("Total Book Stock:");  
		 		totalstock.setForeground(Color.white);
		 		totalstock.setLocation(250, 85); 
		 		totalstock.setSize(400, 200);
				panel.add(totalstock); 
		 		 
		 		JTextField number_stock=new  JTextField();
		 		number_stock.setLocation(430, 180); 
		 		number_stock.setEnabled(false); 
		 		number_stock.setSize(100,30);
		 		number_stock.setBackground(Color.black);
		 		number_stock.setForeground(Color.white);
		 		number_stock.setText(String.valueOf(a));
		 		panel.add(number_stock);
		 		
		 		JLabel numb_student=new JLabel("Number of Books Per Person:");  
		 		numb_student.setForeground(Color.white);
		 		numb_student.setLocation(250, 0); 
		 		numb_student.setSize(400, 200);
				panel.add(numb_student); 
				
				context = new Context(new FindAverage());	
				
				JTextField average=new  JTextField();
				average.setLocation(430, 90); 
				average.setEnabled(false); 
				average.setSize(100,30);
				average.setBackground(Color.black);
				average.setForeground(Color.white);
				average.setText(String.valueOf(context.executeStrategy(a, 2)));
		 		panel.add(average);
		 		
		 		JButton tb=new JButton("Turn Back");  
				tb.setLocation(20, 430);
				tb.setSize(100,30);
				tb.addActionListener(new ActionListener() {  
					
					@Override 
					public void actionPerformed(ActionEvent e) 
					{
						frame.dispose();
						Interface a = new Interface();
						try { 
							a.getFrame(true, null); 
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}); 
				
		     panel.add(tb); 
	         frame.add(panel);
	         panel.add(spanel);
	         panel.add(spanel2);
	         panel.add(label);
	         frame.setSize(600,550);  
	         frame.setLayout(null);  
	         frame.setVisible(true);  
	         
	         
	}
	
	

}
