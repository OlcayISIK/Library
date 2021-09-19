import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface 
{
	
	public void getFrame(boolean Control,String username) throws FileNotFoundException 
	{
		
		JFrame frame=new JFrame("Main Page");    
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		 
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("interface.jpg");
		label.setSize(800,450); 
		label.setLocation(0,0);   
		label.setIcon(icon);    
		 
		JPanel panel=new JPanel();
		panel.setBackground(Color.red);
		panel.setLayout(null);  
		
		    if(Control==true) 
		    {
		    	JButton add=new JButton("Adding Page"); 
				add.setLocation(300, 280);  
				add.setSize(200,50);  
				add.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Adding Adding=new Adding(); 
						Adding.getFrame();
						
							frame.dispose();
							
					}
				});
 

				panel.add(add);
				
				JButton LS=new JButton("Library System");   
				LS.setLocation(300, 330);  
				LS.setSize(200,50);  
				LS.addActionListener(new ActionListener() { 
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						LibraryCapacity LC = new LibraryCapacity();  
						LC.getFrame();
							frame.dispose(); 
							
					}
				});
 

				panel.add(LS);


		    }
		
		  
		JButton lb=new JButton("Library");
		lb.setLocation(300, 80); 
		lb.setSize(200,50);
		lb.addActionListener(new ActionListener() {
			 
			@Override
			public void actionPerformed(ActionEvent e) {
				Library Library=new Library();
				try {
					Library.getFrame(username);
				} catch (FileNotFoundException e1) { 
					// TODO Auto-generated catch block 
					e1.printStackTrace(); 
				} 
				frame.dispose(); 
				
			}
		});
		
		panel.add(lb);
		
		JButton SBS=new JButton("School Book Store");
		SBS.setLocation(300, 130);
		SBS.setSize(200,50);
		SBS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				School_Book_Store School_Book_Store=new School_Book_Store();  
				try { 
					School_Book_Store.getFrame(username);  
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose(); 
				
			}
		});
		panel.add(SBS);
	
		if(Control==true) {
		JButton CN=new JButton("Applying Books"); 
		CN.setLocation(300, 230);
		CN.setSize(200,50); 
		CN.addActionListener(new ActionListener() {
			 
			@Override
			public void actionPerformed(ActionEvent e) {
				Applying app=new Applying();
				app.getFrame(); 
				frame.dispose(); 
				
			}
		});
		
		panel.add(CN);
		}

		JButton UInfo=new JButton("User Information"); 
		UInfo.setLocation(300,180);
		UInfo.setSize(200,50);
		UInfo.addActionListener(new ActionListener() {  
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserInfo UserInfo = new UserInfo();
				UserInfo.getFrame(username);
				frame.dispose();
				
			}
		});
		panel.add(UInfo);
		panel.add(label);
		frame.add(panel);  
		frame.setSize(800,450); 
		frame.setVisible(true);
			
}
}


