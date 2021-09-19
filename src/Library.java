
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;  

public class Library     
{  		      		
	boolean a = true;
	public void getFrame(String username) throws FileNotFoundException  
	{
		  JFrame frame= new JFrame("Library");
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	        
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
	
        JPanel panel=new JPanel();
        panel.setLayout(null); 
        panel.setBounds(0, 0, 1024, 768); 
        DefaultTableModel list1=new DefaultTableModel();
        list1.addColumn("Book Name");
        list1.addColumn("Writer Name"); 
        list1.addColumn("Availability"); 
        list1.addColumn("Barcode");
        list1.addColumn("Stock"); 
        
    	JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("library.jpg");
		label.setSize(1024,640); 
		label.setLocation(0,0);   
		label.setIcon(icon);    
		 
              
        JTable table =new JTable(list1); 
        table.setLayout(new BorderLayout()); 
        JScrollPane spanel=new JScrollPane(table);
        spanel.setSize(750, 200);
        spanel.setLocation(100,100);  
        table.addMouseListener(new MouseListener() {  
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			} 
			
			@Override
			public void mousePressed(MouseEvent arg0) {
		 
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) { 
				String avv=(String)table.getValueAt(table.getSelectedRow(), 2);
				if(avv.equalsIgnoreCase("Avaliable"))
				{
					
						
						JFrame frame=new JFrame("Information");  
						JPanel panel= new JPanel(); 
						panel.setLayout(null);
				        panel.setBounds(0, 0, 650, 650); 
				        
				        JButton btb = new JButton("Booking The Book");
				        btb.setLocation(350, 450); 
				        btb.setSize(200,30);
				        btb.addActionListener(new ActionListener() {
		
							@Override
							public void actionPerformed(ActionEvent e) {
								File file=new File("Appuser.txt");
								ArrayList<String> temp = new ArrayList<String>();
								Scanner read;
								try {
									read = new Scanner(file);
									while(read.hasNextLine())
									{ 
								       String write=read.nextLine(); 
								       temp.add(write);  
									}
								} catch (FileNotFoundException e2) { 
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} 
								temp.add(username);
								temp.add((String) table.getValueAt(table.getSelectedRow(), 0));
								 
								FileWriter fw = null;
								try { 
									fw = new FileWriter(file);     
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						          for(int add=0;add<temp.size();add++) //We create a loop for write all the index to the file.
						          {
						         	 try {
										fw.write(temp.get(add)+"\n");
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
				        								        
						JLabel info=new JLabel();   
						info.setLocation(5,350);  
						info.setSize(200,200); 
						
						String Text="<html>";
						Text+="Book Name: " +table.getValueAt(table.getSelectedRow(), 0)+"<br>";
						Text+="Writer: "+table.getValueAt(table.getSelectedRow(), 1)+"<br>";
						Text+="Avability: "+table.getValueAt(table.getSelectedRow(), 2)+"<br>";
						Text+="Barcode: "+table.getValueAt(table.getSelectedRow(), 3)+"<br>"; 
						Text+="Stock: "+table.getValueAt(table.getSelectedRow(), 4)+"<br>";
						Text+="</html>";
						info.setText(Text);
						
						JLabel picture=new JLabel();
						picture.setLocation(1,1);
						picture.setSize(400,400); 
						 
						 
						JLabel sum=new JLabel();
						sum.setLocation(300,-50);
						sum.setSize(300,500);
						
						
						for(int i=0;i<itemlist.size();i+=7)  
							if(itemlist.get(i).equalsIgnoreCase((String) table.getValueAt(table.getSelectedRow(), 0))) {
								Icon image=new ImageIcon(itemlist.get(i+5));
								picture.setIcon(image); 
								String Text1="<html>"; 
								Text1+=itemlist.get(i+6);  
								 Text1+="</html>";
								sum.setText(Text1);	  
								
		
							       
								break;
							
							}
						panel.add(btb);
						panel.add(picture);
						panel.add(sum);
						panel.add(info);
						frame.add(panel);
						frame.setSize(750,600);  
				        frame.setLayout(null);    
				        frame.setVisible(true); 
			}
				else
					JOptionPane.showMessageDialog(frame," Book is not avaliable.");  
			}
		});
         int i=0;  
         while(i < itemlist.size())   
         { 
        	 list1.addRow(new Object[] {itemlist.get(i),itemlist.get(i+1),itemlist.get(i+2),itemlist.get(i+3),itemlist.get(i+4)});     
             i+=7;  
         }  
         

        
        JLabel a=new JLabel("Please Enter The Name of the Book:"); 
		a.setLocation(180, 300);
		a.setSize(400, 200);
		panel.add(a);
		a.setForeground(Color.white);
		
		JTextField sort=new  JTextField(); 
		sort.setLocation(400, 395);
		sort.setSize(150,30); 
		sort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				while(dm.getRowCount() > 0)
				{
				    dm.removeRow(0);
				}
				ArrayList<String> Newlist=new ArrayList<String>();
				
				for(int i=0;i<itemlist.size();i+=5)
				{	
					if(itemlist.get(i).toUpperCase().equals(sort.getText().toUpperCase()))
					{	 
						Newlist.add(itemlist.get(i));  
						Newlist.add(itemlist.get(i+1));
						Newlist.add(itemlist.get(i+2)); 
						Newlist.add(itemlist.get(i+3)); 
						Newlist.add(itemlist.get(i+4)); 
					}
				} 
				
		         int i=0;
		         while(i < Newlist.size()) 
		         {list1.addRow(new Object[] {Newlist.get(i),Newlist.get(i+1),Newlist.get(i+2),Newlist.get(i+3),Newlist.get(i+4)});
		             i+=5; 
		         }
						   
			}
		});
		
		 JButton tb=new JButton("Turn Back");   
			tb.setLocation(800, 520);
			tb.setSize(150,45);
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
		panel.add(sort); 
		panel.add(label); 
		frame.add(panel); 
		frame.setSize(1024,640);  
        frame.setLayout(null);  
        frame.setVisible(true);  

}
}