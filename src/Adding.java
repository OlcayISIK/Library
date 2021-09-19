import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

  
public class Adding {
	String z;
	
	static class BuilderFactory{ 
		public static Factory getItem(String ItemType){
		      if(ItemType == null){ 
		         return null;
		      }		
		      if(ItemType.equalsIgnoreCase("KITAP")){ 
		         return new Kitap();
		         
		      } else if(ItemType.equalsIgnoreCase("NOTLAR")){
		         return new Notlar();
		   }
			return null;
		}
	}

	
	public void getFrame() 
	{
		    NoteBuilder notebuild = new NoteBuilder();
			JFrame frame=new JFrame("Adding Page");   
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      
			JLabel label = new JLabel();
			ImageIcon icon = new ImageIcon("adding.png"); 
			label.setSize(690,690);  
			label.setLocation(0,0);   
		    label.setIcon(icon);   
		     
				 
			JPanel panel=new JPanel();
			panel.setBackground(Color.yellow);   
			panel.setLayout(null);
			panel.setVisible(true);
			
			JLabel select =new JLabel("Please Select The Area Where You Want to Add Items:");
			select.setLocation(0, 0);     
			select.setSize(400, 130);   
		    panel.add(select);
			 
			JComboBox infos=new  JComboBox();
			infos.setLocation(320,50);
			infos.setSize(150, 30); 
			infos.addItem("Book");
			infos.addItem("Book Store Note");
			
			File file=new File("Books.txt"); 
			
			ArrayList<String> book_list = new ArrayList<String>();
			Scanner read;
			try {
				read = new Scanner(file);
				while(read.hasNextLine())
				{ 
			       String write=read.nextLine(); 
			       book_list.add(write);  
				}
			} catch (FileNotFoundException e2) { 
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} 
			    
			
				JLabel book =new JLabel("Please Enter The Name of The Book:");
			    book.setLocation(10, 10);      
			    book.setSize(500, 200);   
			    panel.add(book);
			    book.setVisible(false);
			    
				JTextField bookname=new  JTextField();
				bookname.setLocation(250 ,100); 
				bookname.setSize(200,30);
				panel.add(bookname);
				bookname.setVisible(false);
				
				JLabel Topic =new JLabel("Please Enter The Writer Name:");
				Topic.setLocation(10, 70);     
				Topic.setSize(200, 200);  
				panel.add(Topic);
				Topic.setVisible(false);
			    
				JTextField topic=new  JTextField();
				topic.setLocation(250, 160);  
				topic.setSize(200,30); 
				panel.add(topic);
				topic.setVisible(false);
			    		
				
				JLabel br =new JLabel("Please Enter The Barcode:");
				br.setLocation(10, 110);     
				br.setSize(200, 200);  
				panel.add(br);
				br.setVisible(false);
			    
				JTextField brc=new  JTextField();
				brc.setLocation(250, 200); 
				brc.setSize(200,30);
				panel.add(brc);
				brc.setVisible(false);
				
				JLabel st =new JLabel("Please Enter The Stock:");
				st.setLocation(10, 155);     
				st.setSize(200, 200);  
				panel.add(st);
				st.setVisible(false);
				
				JTextField stock=new  JTextField();
				stock.setLocation(250, 240); 
				stock.setSize(200,30);
				panel.add(stock);
				stock.setVisible(false);
				
				JLabel png =new JLabel("Please Enter The Png of The Book:");
				png.setLocation(10, 190);     
				png.setSize(200, 200);  
				panel.add(png);
				png.setVisible(false);
				
				JTextField jpeg=new  JTextField(); 
				jpeg.setLocation(250, 280); 
				jpeg.setSize(200,30);
				panel.add(jpeg);
				jpeg.setVisible(false);
				
				JLabel sm =new JLabel("Please Enter Summary:");
				sm.setLocation(10, 280);     
				sm.setSize(200, 100);  
				panel.add(sm);
				sm.setVisible(false);
				
				JTextArea summary=new  JTextArea();
				summary.setLocation(250, 320); 
				summary.setSize(250,250);
				panel.add(summary);
				summary.setVisible(false);
				
				JComboBox<String> avb=new  JComboBox<String>();
				avb.addItem("Avaliable");
				avb.addItem("Not Avaliable");
			    avb.setLocation(20, 390);
			    avb.setSize(100,30); 
			    panel.add(avb);		
			    avb.setVisible(false);
			    
			    JLabel cr =new JLabel("Please Choose the Avaliablitiy:");
				cr.setLocation(10, 265);     
				cr.setSize(200, 200);  
				panel.add(cr);
				cr.setVisible(false); 


					JButton add=new JButton("Adding"); 
					add.setLocation(530,500); 
					add.setSize(120,45);  
					add.setVisible(false);
					panel.add(add);
					add.addActionListener(new ActionListener() { 
						
						@Override
						public void actionPerformed(ActionEvent e) 
						{
							boolean b = false;
							for(int a1=3; a1 < book_list.size();a1+=6) 
							{
								if(book_list.get(a1).equals(brc.getText())) 
								{ 
									b = true;
									break;
								}
							}    
							if(b == true) {  
								JOptionPane.showMessageDialog(frame," You can't add same barcode.");  
							}
							else 
							{
								book_list.add(bookname.getText()); 
								book_list.add(topic.getText());
								book_list.add((String) avb.getSelectedItem());
								book_list.add(brc.getText());
								book_list.add(stock.getText());
								book_list.add(jpeg.getText());
								book_list.add(summary.getText());
								
								  BuilderFactory builderFactory = new BuilderFactory();
							      Factory factory = BuilderFactory.getItem("KITAP");
							      factory.build_Book(bookname.getText(), topic.getText(), brc.getText(), stock.getText());		
								  JOptionPane.showMessageDialog(frame," Addition Complete.");  
								
						   
						FileWriter fw = null;
						try { 
							fw = new FileWriter(file);   
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				       for(int add=0;add<book_list.size();add++) //We create a loop for write all the index to the file.
				       {
				      	 try {
								fw.write(book_list.get(add)+"\n");
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
		}}); 
					File file2=new File("C:\\Users\\ABRA\\Desktop\\StoreInfo.txt"); 
					
					ArrayList<String> note_list = new ArrayList<String>();
					Scanner read2;
					try {
						read2 = new Scanner(file2); 
						while(read2.hasNextLine())
						{ 
					       String write=read2.nextLine(); 
					       note_list.add(write);  
						}
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} 

					    JLabel dep =new JLabel("Please Enter Department:");
					    dep.setLocation(10, 10);     
					    dep.setSize(500, 200);   
					    panel.add(dep);
					    dep.setVisible(false);
					    
						JTextField depart=new  JTextField();
						depart.setLocation(250 ,100); 
						depart.setSize(200,30);
						panel.add(depart);
						depart.setVisible(false);
						
						 JLabel tp =new JLabel("Please Enter Topic:");
						 tp.setLocation(10, 50);     
						 tp.setSize(500, 200);   
						 panel.add(tp);
						 tp.setVisible(false);
						    
						 JTextField tp2=new  JTextField();
						 tp2.setLocation(250 ,140); 
						 tp2.setSize(200,30);
					     panel.add(tp2);
						 tp2.setVisible(false);
						
						JLabel pages =new JLabel("Please Enter Number Of Pages:");
						pages.setLocation(10, 90);     
						pages.setSize(200, 200);  
						panel.add(pages);
						pages.setVisible(false);
					    
						JTextField pages2=new  JTextField();
						pages2.setLocation(250, 180);  
						pages2.setSize(200,30);
						panel.add(pages2);
						pages2.setVisible(false);
						
						JLabel money =new JLabel("Please Enter The Money:");
						money.setLocation(10, 130);     
						money.setSize(200, 200);  
						panel.add(money);
						money.setVisible(false);
					    
						JTextField mn=new  JTextField();
						mn.setLocation(250, 220); 
						mn.setSize(200,30);
						panel.add(mn);
						mn.setVisible(false);
						
						JLabel st2 =new JLabel("Please Enter The Stock:");
						st2.setLocation(10, 170);     
						st2.setSize(200, 200);  
						panel.add(st2);
						st2.setVisible(false);
						
						
						JTextField stock2 =new  JTextField();
						stock2.setLocation(250, 260); 
						stock2.setSize(200,30);
						panel.add(stock2);	
						stock2.setVisible(false);
						
						JLabel barcode =new JLabel("Please Enter 2 Digit Barcode:");
						barcode.setLocation(10, 210);     
						barcode.setSize(500, 200);   
					    panel.add(barcode);
					    barcode.setVisible(false);
					    
						JTextField barcode2=new  JTextField();
						barcode2.setLocation(250 ,300); 
						barcode2.setSize(200,30);
						panel.add(barcode2);
						barcode2.setVisible(false);
						
						
						JButton add2=new JButton("Adding"); 
						add2.setLocation(540,500); 
						add2.setSize(120,45);  
						add2.setVisible(false);
						panel.add(add2);
						add2.addActionListener(new ActionListener() {   
							
							@Override
							public void actionPerformed(ActionEvent e) 
							{
						
						note_list.add(mn.getText()); 
						note_list.add(tp2.getText());
						note_list.add(depart.getText()); 
						note_list.add(pages2.getText()); 
						note_list.add(stock2.getText()); 
						
						
						  BuilderFactory builderFactory = new BuilderFactory(); 
					      Factory factory = BuilderFactory.getItem("NOTLAR");
					      factory.build_Note(mn.getText(), tp2.getText(), depart.getText(), pages2.getText(),stock2.getText()); 
					      notebuild.create(Integer.valueOf(barcode2.getText()), mn.getText(), tp2.getText(), depart.getText(),pages2.getText(), stock2.getText()); 
					      
					      
						JOptionPane.showMessageDialog(frame," Addition Complete.");  
						
						FileWriter fw = null;
						try { 
							fw = new FileWriter(file2);   
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				          for(int adding=0;adding<note_list.size();adding++) //We create a loop for write all the index to the file.
				          {
				         	 try {
								fw.write(note_list.get(adding)+"\n");
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
							
							}});
						
		
					
			
			
			infos.addActionListener(new ActionListener() 
			{   
				
				
				@Override 
				public void actionPerformed(ActionEvent e) 
				{
					if(((String) infos.getSelectedItem()).equals("Book"))
					{   

						
					    dep.setVisible(false);
					    add2.setVisible(false);
					    stock2.setVisible(false);
						st2.setVisible(false);
						tp.setVisible(false);
						tp2.setVisible(false);
						mn.setVisible(false);
						money.setVisible(false);
						pages2.setVisible(false);
						pages.setVisible(false);
						depart.setVisible(false);
						barcode.setVisible(false);
						barcode2.setVisible(false);

						bookname.setText("");
						topic.setText("");
						brc.setText("");
						stock.setText("");
						summary.setText("");
						avb.setSelectedIndex(0);
					    book.setVisible(true);
					    bookname.setVisible(true);
						Topic.setVisible(true);
						topic.setVisible(true);
						png.setVisible(true);
						jpeg.setVisible(true);
						br.setVisible(true);
						brc.setVisible(true);
						add.setVisible(true);
						st.setVisible(true);
						stock.setVisible(true);
						sm.setVisible(true);
						summary.setVisible(true);
					    avb.setVisible(true);
						cr.setVisible(true);
						
					}
					else 
					{
							book.setVisible(false);
							bookname.setVisible(false);
							Topic.setVisible(false);
							topic.setVisible(false);
							br.setVisible(false);
							brc.setVisible(false);
							st.setVisible(false);
							add.setVisible(false);
							stock.setVisible(false);
							sm.setVisible(false);
							summary.setVisible(false);
						    avb.setVisible(false);
							cr.setVisible(false);
							png.setVisible(false);
							jpeg.setVisible(false);
							

							stock2.setText("");
							mn.setText("");
							pages2.setText("");
							depart.setText("");
						    dep.setVisible(true);
						    stock2.setVisible(true);
						    add2.setVisible(true);
							st2.setVisible(true);
							tp.setVisible(true);
							tp2.setVisible(true);
							mn.setVisible(true);
							money.setVisible(true);
							pages2.setVisible(true);
							pages.setVisible(true);
							depart.setVisible(true);
							barcode.setVisible(true);
							barcode2.setVisible(true);

					}
				}
			});
			
			JButton tb=new JButton("Turn Back");  
			tb.setLocation(550, 550);
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
			panel.add(infos);
			frame.add(panel);
			frame.setSize(690,690);  
	        frame.setVisible(true);  
	        panel.add(label);
	       
	       
			
			
			
}

}
