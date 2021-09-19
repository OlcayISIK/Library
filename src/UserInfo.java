import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserInfo { 
	
	public void getFrame(String username) {
		{
			
		   		ArrayList<String> item_list = new ArrayList<String>(); 
		   		
		       File nfile=new File("UserInfos.txt");
				Scanner read; 
				try {
					read = new Scanner(nfile);
					while(read.hasNextLine()) 
					{  
				       String write=read.nextLine();  
				       item_list.add(write);  
					}
				} catch (FileNotFoundException e2) { 
					// TODO Auto-generated catch block 
					e2.printStackTrace();
				}  
				
				  JFrame frame= new JFrame("Listing Page");
			       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
			       
	       JPanel panel=new JPanel();
	        panel.setLayout(new BorderLayout());
	        panel.setBounds(0, 0, 500, 500);  
	        DefaultTableModel list1=new DefaultTableModel();
	        list1.addColumn("Informations");

	        JTable table =new JTable(list1);
	        table.setLayout(new BorderLayout());
	        JScrollPane spanel=new JScrollPane(table);
	        spanel.setSize(400, 400);
	        spanel.setLocation(0,0); 
	        
	        for (int j = 0; j<item_list.size();j+=2) 
	        {
	        	if(item_list.get(j).equalsIgnoreCase(username))  
	        	{
	 		         list1.addRow(new Object[] {item_list.get(j+1)});
	        	}
	        	
	        }
	        
	        JButton tb=new JButton("Turn Back");  
			tb.setLocation(200, 400);
			tb.setSize(100,30);
			tb.addActionListener(new ActionListener() {  
				
				@Override 
				public void actionPerformed(ActionEvent e) 
				{
					frame.dispose();
					Interface a = new Interface();
					try { 
						a.getFrame(false, null); 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(); 
					}
				}
			});
	        panel.add(tb);  
	        panel.add(spanel);
			frame.add(panel);
			frame.setSize(500,500);  
	        frame.setLayout(null);  
	        frame.setVisible(true);  
		
	}
	}

}
	

