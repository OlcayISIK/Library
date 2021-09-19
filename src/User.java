import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
		
	   private String name;
	   private String password;
	   private List<User> Users;
	   
		   
	   public User(String name, String password) {
		   this.name = name;
		   this.password = password;
		   Users = new ArrayList<User>();
	   }
		   
		   public void add(User a) {
			      Users.add(a); 
			   }

			   public void remove(User a) {
			      Users.remove(a);
			   }

			   public List<User> getUsers(){
			     return Users;
			   }
			   
			   public static void main(String[] args) throws FileNotFoundException {
				   File file=new File("user.txt");   
				   ArrayList<String> kullanici = new ArrayList<String>();   
				   Scanner read = new Scanner(file);  
				    
				    while(read.hasNextLine()) 
					{ 
				       String write=read.nextLine(); 
				       kullanici.add(write);  
					}
				    
				    File file2=new File("admin.txt");  		
					ArrayList<String> admin = new ArrayList<String>();   
					Scanner read2=new Scanner(file2);   
					    
					    while(read2.hasNextLine()) 
						{ 
					       String write=read2.nextLine(); 
					       admin.add(write);  
						}
				    
				    
				    
				   User Admin = new User(kullanici.get(2),kullanici.get(3));
				   User SimpleUser = new User(kullanici.get(0),kullanici.get(1));
				   User ProfessionalUser = new User(admin.get(0),admin.get(1));
				   
				   Admin.add(SimpleUser);
				   Admin.add(ProfessionalUser);
				   
				   for(User user : Admin.getUsers()) {
					   System.out.println(user);
				   }
			   }
			}
	   

