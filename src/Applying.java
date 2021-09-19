import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.List;
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

public class Applying {
    BackGround Button = new Button();
    BackGround redButton = new RedButtonDecorator(new Button());
    
	public void apuserDelete(String USERNO, String BOOKINFO) 
	{ 
		ArrayList<String> apuser=new ArrayList<String>(); 
		File nfile=new File("Appuser.txt");
		
		Scanner read; 
		try {
			read = new Scanner(nfile);
			while(read.hasNextLine())
			{ 
		       String write=read.nextLine(); 
		       apuser.add(write);  
			}
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		
		for(int i=0;i<apuser.size();i+=2)
		if(USERNO.equalsIgnoreCase(apuser.get(i)))  
		{      
			if(apuser.get(i).equalsIgnoreCase(USERNO)&&apuser.get(i+1).equalsIgnoreCase(BOOKINFO)) 
			apuser.remove(i);
			apuser.remove(i);
		
		}
		FileWriter fw = null;
		try { 
			fw = new FileWriter(nfile);    
		} catch (IOException e1) {
			// TODO Auto-generated catch block 
			e1.printStackTrace();
		}
          for(int add=0;add<apuser.size();add++) //We create a loop for write all the index to the file.
          {
         	 try {
				fw.write(apuser.get(add)+"\n"); 
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
		 
		
	
	public void appuserApprove(String USERNO, String BOOKINFO) {
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
		user.add(BOOKINFO);
		
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

              
              ArrayList<String> apuser = new ArrayList<String>(); 
      		File file=new File("Appuser.txt");
      		Scanner read2; 
      		try {
      			read2 = new Scanner(file);
      			while(read2.hasNextLine())
      			{ 
      		       String write=read2.nextLine(); 
      		       apuser.add(write);  
      			}
      		} catch (FileNotFoundException e2) {
      			// TODO Auto-generated catch block
      			e2.printStackTrace();
      		} 
      		for(int i = 0;i<apuser.size();i+=2)
      		{	if(apuser.get(i).equalsIgnoreCase(USERNO)&&apuser.get(i+1).equalsIgnoreCase(BOOKINFO)) 
      					{	
      						apuser.remove(i);
      						apuser.remove(i);
      					}
      		}
      		FileWriter fw1 = null;
      		try { 
      			fw1 = new FileWriter(file);     
      		} catch (IOException e1) {
      			// TODO Auto-generated catch block
      			e1.printStackTrace();
      		}
                for(int add=0;add<apuser.size();add++) //We create a loop for write all the index to the file.
                {
               	 try {
      				fw1.write(apuser.get(add)+"\n");
      			} catch (IOException e1) {
      				// TODO Auto-generated catch block
      				e1.printStackTrace();  
      			}
                }                 
                    try { 
      				fw1.close();
      			} catch (IOException e1) {
      				// TODO Auto-generated catch block
      				e1.printStackTrace(); 
      			} // Close the file.

	}
		
		

	public void getFrame()
	{
			JFrame frame=new JFrame("Apply Page");  
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
			JLabel label = new JLabel();
			ImageIcon icon = new ImageIcon("applying.jpg"); 
			label.setSize(640,640);  
			label.setLocation(0,0);   
		    label.setIcon(icon);  
		     
				
			JPanel panel=new JPanel();
			panel.setBackground(Color.white);   
			panel.setLayout(null); 

					
					DefaultTableModel Column=new DefaultTableModel();
					Column.addColumn("User Name");
					Column.addColumn("Book Name");
			       
			        JTable table =new JTable(Column);
			        table.setLocation(50, 50);
			        table.setSize(500, 100);
			        table.setLayout(new BorderLayout());
			        JScrollPane spanel=new JScrollPane(table);
			        spanel.setSize(650, 200);
			        ArrayList<String> apply= new ArrayList<String>();
			        File file=new File("Appuser.txt");
					
			        Scanner read;
					try {
						read = new Scanner(file);
						while(read.hasNextLine())
						{ 
					       String write=read.nextLine(); 
					       apply.add(write);   
						}
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} 
			        int i=0;
			        while(i < apply.size()) 
			        { Column.addRow(new Object[] {apply.get(i),apply.get(i+1)});  
			        	i+=2;
			        }
			        
			        
			        JButton decline=new JButton("Decline");
			        decline.setLocation(430, 450);   
			        decline.setSize(100, 45);
			        redButton.draw(decline); 
			        decline.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) 
						{		
 
							String usernumber=(String)table.getValueAt(table.getSelectedRow(), 0);
							String bookinfo=(String)table.getValueAt(table.getSelectedRow(), 1);
							apuserDelete(usernumber,bookinfo);
							DefaultTableModel dm = (DefaultTableModel)table.getModel();
							while(dm.getRowCount() > 0)
							{
							    dm.removeRow(0); 
							}
							File nfile=new File("Appuser.txt");
							ArrayList<String> apuser=new ArrayList<String>();
							Scanner read2; 
							try {
								read2 = new Scanner(nfile);
								while(read2.hasNextLine())
								{ 
							       String write=read2.nextLine(); 
							       apuser.add(write);  
								}
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} 
							  int i=0;
							  while(i < apuser.size())
						        { Column.addRow(new Object[] {apuser.get(i),apuser.get(i+1)});
						        	i+=2;
						        } 
							  
							  
						       
							
							
						}
					});
			        
			        JButton approve=new JButton("Approve"); 
			        approve.setLocation(100, 450); 
			        approve.setSize(100, 45);
			        Button.draw(approve);
			        approve.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) 
						{		
							String usernumber=(String)table.getValueAt(table.getSelectedRow(), 0);
							String bookinfo=(String)table.getValueAt(table.getSelectedRow(), 1);
							appuserApprove(usernumber,bookinfo);
							DefaultTableModel dm = (DefaultTableModel)table.getModel();
							while(dm.getRowCount() > 0)
							{ 
							    dm.removeRow(0); 
							}
							ArrayList<String> apuser=new ArrayList<String>();
							
							File nfile=new File("Appuser.txt");
							Scanner read2; 
							try {
								read2 = new Scanner(nfile);
								while(read2.hasNextLine())
								{ 
							       String write=read2.nextLine(); 
							       apuser.add(write);  
								}
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} 
							System.out.println(apuser);
							  int i=0;

							  while(i < apuser.size())
						        { Column.addRow(new Object[] {apuser.get(i),apuser.get(i+1)});
						        	i+=2;
						        }	
	  
								File file=new File("Books.txt");
								ArrayList<String> itemlist = new ArrayList<String>();
								Scanner read;
								try {
									read = new Scanner(file);
									while(read.hasNextLine()) 
									{ 
								       String write=read.nextLine(); 
								       itemlist.add(write);  
									}
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								 
								for(int z=0;z<itemlist.size();z+=7) {
									if (itemlist.get(z).equalsIgnoreCase(bookinfo)) {
										int c = Integer.valueOf(itemlist.get(z+4));
										if(c == 0) { 
											JOptionPane.showMessageDialog(frame," You Can't Approve Because There is No Stock For Book in Library"); 
											break;
										} 
										c--;
										itemlist.set(z+4, String.valueOf(c)); 
										
									}
								}
								FileWriter fw = null;
								try { 
									fw = new FileWriter(file);    
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						          for(int add=0;add<itemlist.size();add++) //We create a loop for write all the index to the file.
						          {
						         	 try {
										fw.write(itemlist.get(add)+"\n");
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
								a.getFrame(true, null); 
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}); 
					panel.add(tb);
			        panel.add(approve);
			        panel.add(decline);
			        panel.add(table);
			        panel.add(label);
			        frame.add(panel);
					frame.setSize(640, 640);
					frame.setLocation(0,0);		
					frame.setVisible(true);
				}
			


}
