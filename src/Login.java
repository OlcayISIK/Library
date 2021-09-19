
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	
	private static Login login = new Login();
	
	private Login() {}
	public static Login getlogin() {
		return login;
	}
	 
	public void showMessage() {
		System.out.println("Login is Completed");  
	}
	boolean k=false;
	public void getFrame() throws IOException
	{
		JFrame frame=new JFrame("Login Page");    
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		File file=new File("user.txt");   
		ArrayList<String> user = new ArrayList<String>();   
		Scanner read = new Scanner(file);  
		    
		    while(read.hasNextLine()) 
			{ 
		       String write=read.nextLine(); 
		       user.add(write);  
			}
		    
		    File file2=new File("admin.txt");  		
			ArrayList<String> admin = new ArrayList<String>();   
			Scanner read2=new Scanner(file2);   
			    
			    while(read2.hasNextLine()) 
				{ 
			       String write=read2.nextLine(); 
			       admin.add(write);  
				}
		    
		
		ImageIcon icon = new ImageIcon("login.jpg");  
		JLabel label = new JLabel(icon);   
		label.setSize(446,600); 
		label.setLocation(0,0); 
		label.setIcon(icon);   
		
		
			JPanel panel=new JPanel();  
			panel.setLayout(null);  
			
			JLabel a=new JLabel("Please Enter the User Name:");
			a.setLocation(50, 80);      
			a.setSize(200, 200);     
			panel.add(a);
			a.setForeground(Color.red); 
			 
			JLabel b=new JLabel("Please Enter the Password:");
			b.setLocation(50, 150);     
			b.setSize(200, 200);     
			panel.add(b);
			b.setForeground(Color.red);
			
			JTextField name=new  JTextField();    
			name.setLocation(250, 170);   
			name.setSize(150,30); 
			panel.add(name);  
			
			JPasswordField password=new  JPasswordField(); 
			password.setLocation(250, 230);   
			password.setSize(150,30); 
			panel.add(password); 
			
			JButton add=new JButton("LOGIN"); 
			add.setLocation(50, 50); 
			add.setSize(150,45); 
			add.addActionListener(new ActionListener() {     
				
				
				@Override
				public void actionPerformed(ActionEvent e) {
					boolean control = false; 
				for (int i=0;i < user.size();i+=2)   
				{
					if(user.get(i).equals(name.getText()) && user.get(i+1).equals(password.getText())) 
					{  
						        control = true;  
 
								Interface face=new Interface(); 
								try {
									face.getFrame(false,name.getText()); 
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();  
								}
								frame.dispose(); 

					} 
					
				}
					
					
					for (int i=0;i < admin.size();i+=2)    
					{
						if(admin.get(i).equals(name.getText()) && admin.get(i+1).equals(password.getText())) 
						{  
							        control = true;   

									Interface face=new Interface();  
									try {
										face.getFrame(true,name.getText()); 
									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();  
									}
									frame.dispose(); 
									break;
						}
									

						
					}
					if(control == false) {  
						JOptionPane.showMessageDialog(frame," Your username or password is wrong.");  
					}
				}}); 
			
			JButton register=new JButton("SIGNUP"); 
			register.setLocation(250, 50);
			register.setSize(150,45);
			register.addActionListener(new ActionListener() { 
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Register a1= new Register();
					a1.getFrame();
					frame.dispose();
					
				}
			}); 
			
			panel.add(register);
			panel.add(add);  
			panel.add(name);
			panel.add(password); 
			panel.add(label);
			frame.add(panel); 
			frame.setSize(460,600); 
			frame.setVisible(true);
	}

	}
