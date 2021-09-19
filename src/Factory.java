
public interface Factory {
	public void build_Book(String Name,String Writter,String barcode,String stock);
	public void build_Note(String Money,String Topic,String Department,String pages,String Stock);
	
}
class Kitap implements Factory{

	@Override
	public void build_Book(String Name, String Writter, String barcode, String stock) { 
	System.out.println("Book is created");				
	}

	@Override
	public void build_Note(String Money, String Topic, String Department, String pages, String Stock) {
	}
}
class Notlar implements Factory{

	@Override
	public void build_Book(String Name, String Writter, String barcode, String stock) {
	}

	@Override
	public void build_Note(String Money, String Topic, String Department, String pages, String Stock) {
		System.out.println("Note is created"); 
	}
}






	   










