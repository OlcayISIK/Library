import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextField;

public abstract class List {
	public abstract ArrayList<String> ListAllItem();
	public abstract int CountItems();
	
	public final ArrayList<String> Execute() {
		ArrayList<String> itemlist =new ArrayList<String>();
		itemlist=ListAllItem();
		itemlist.add(String.valueOf(CountItems()));
		
	return itemlist;
} 
}

class Books extends List {
	int a=0;
	 
	public  ArrayList<String> ListAllItem() {
		File file=new File("Books.txt"); 
		ArrayList<String> itemlist = new ArrayList<String>();
		ArrayList<String> newList = new ArrayList<String>();
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
		
		for(int i=0;i<itemlist.size();i+=7) 
			newList.add(itemlist.get(i));
		return newList;
	}

	@Override
	public int CountItems() {
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
		for(int i=0;i<itemlist.size();i+=7) {
		a++;
		
	}
	
		return a;
	}
	
}

class Notes extends List{
int a=0;
		public  ArrayList<String> ListAllItem() {
			File file=new File("StoreInfo.txt"); 
			ArrayList<String> itemlist = new ArrayList<String>();
			ArrayList<String> newList = new ArrayList<String>();
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
			
			for(int i=1;i<itemlist.size();i+=5) 
				newList.add(itemlist.get(i));
			return newList;
		}
		
		@Override
		public int CountItems() {
			File file=new File("StoreInfo.txt");
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
			for(int i=1;i<itemlist.size();i+=5) {
			a++;
			
		}
		
			return a;
		}
			
	}
	











