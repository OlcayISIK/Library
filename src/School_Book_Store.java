import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class School_Book_Store {
	
	
	boolean b;
	static int a;
	public void BuyItem (String USERNO, String Topic) {
		ArrayList<String> user = new ArrayList<String>();   
		File nfile=new File("UserInfos.txt");  
		Scanner read;  
		try {
			read = new Scanner(nfile);
			while(read.hasNextLine()) 
			{ 
		       String write=read.nextLine(); 
		       user.add(write);  
			}
		} catch (FileNotFoundException e2) { 
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		user.add(USERNO); 
		user.add(Topic);  
		
		FileWriter fw = null;
		try { 
			fw = new FileWriter(nfile);    
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
          for(int add=0;add<user.size();add++) //We create a loop for write all the index to the file.
          {
         	 try {
				fw.write(user.get(add)+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();  
			}
          }                 
              try { 
				fw.close();
			} catch (IOException e1) { 
				// TODO Auto-generated catch block
				e1.printStackTrace(); 
			} // Close the file.

	}
		
	
	public void getFrame(String username) throws FileNotFoundException 
	{
			
			JFrame frame=new JFrame("School Book Store");  
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			
			File file=new File("StoreInfo.txt");
			 
			ArrayList<String> store_list = new ArrayList<String>(); 
			Scanner read = new Scanner(file); 
			     
			    while(read.hasNextLine()) 
				{ 
			       String write=read.nextLine(); 
			       store_list.add(write);  
				}
			     
		    	JLabel label = new JLabel();
				ImageIcon icon = new ImageIcon("bookstore.jpg");
				label.setSize(640,640); 
				label.setLocation(0,0);   
				label.setIcon(icon); 
			    
			    JPanel panel=new JPanel();
		        panel.setLayout(null);
		        panel.setBounds(0, 0, 1024, 768); 
		        
  
		        DefaultTableModel list1=new DefaultTableModel();
		        list1.addColumn("Money"); 
		        list1.addColumn("Topic");
		        list1.addColumn("Department");
		        list1.addColumn("Numb_pages");
		        list1.addColumn("Stock"); 
		        JTable table =new JTable(list1); 
		        table.setLayout(new BorderLayout());
		        JScrollPane spanel=new JScrollPane(table);
		        spanel.setSize(600, 300);
		        spanel.setLocation(10,200);  
		        
		         int j=0;
		         do {list1.addRow(new Object[] {store_list.get(j),store_list.get(j+1),store_list.get(j+2),store_list.get(j+3),store_list.get(j+4)});
		             j+=5; 
		         } 
		         while(j < store_list.size()); 
		          
		         JButton buy=new JButton("Buy"); 
		         buy.setLocation(270, 520); 
		         buy.setSize(100, 60);
		         buy.addActionListener(new ActionListener() { 
						
						@Override
						public void actionPerformed(ActionEvent e) 
						{		
  
							String topic=(String)table.getValueAt(table.getSelectedRow(), 1);  
							BuyItem(username,topic); 
							a =Integer.valueOf((String) table.getValueAt(table.getSelectedRow(), 4));    
							if(a == 0) 
							{
								JOptionPane.showMessageDialog(frame," You can't but anymore.");   
							}
							else 
							{
							a--;
							DefaultTableModel dm = (DefaultTableModel)table.getModel(); 
							while(dm.getRowCount() > 0)
							{ 
							    dm.removeRow(0); 
							}
							store_list.clear();
							Scanner read = null;
							try {
								read = new Scanner(file);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block 
								e1.printStackTrace();
							} 
						     
						    while(read.hasNextLine()) 
							{ 
						       String write=read.nextLine();  
						       store_list.add(write);  
							}
						    store_list.set(4,String.valueOf(a));
						    
						    FileWriter fw = null;
							try { 
								fw = new FileWriter(file);    
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					          for(int add=0;add<store_list.size();add++) //We create a loop for write all the index to the file.
					          {
					         	 try {
									fw.write(store_list.get(add)+"\n");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();  
								}
					          }                 
					              try { 
									fw.close();
								} catch (IOException e1) { 
									// TODO Auto-generated catch block
									e1.printStackTrace(); 
								} // Close the file.
						    
							  int i=0;
							  do {list1.addRow(new Object[] {store_list.get(i),store_list.get(i+1),store_list.get(i+2),store_list.get(i+3),store_list.get(i+4)});
					             i+=5; 
					         }
					         while(i < store_list.size()); 
						       
							
							
						}
						}
					});
		         
		         JButton tb=new JButton("Turn Back"); 
					tb.setLocation(500, 520);
					tb.setSize(100,30);
					tb.addActionListener(new ActionListener() {  
						
						@Override 
						public void actionPerformed(ActionEvent e) 
						{
							frame.dispose();
							Interface a = new Interface();
							try { 
								a.getFrame(b, username);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
			    panel.add(tb);
			    panel.add(spanel);
			    panel.add(buy);
			    panel.add(label);
				frame.add(panel);
				frame.setSize(640,640); 
		        frame.setLayout(null);  
		        frame.setVisible(true);  
		}
		}
