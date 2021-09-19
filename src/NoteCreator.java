
public interface NoteCreator {
	public void create(int barcode,String Money, String Topic, String Department, String Page, String Stock);
}
interface AdvancedNoteCreator {

	public void StoreNoteCreate(String Money,String Topic,String Department,String Page,String Stock);
}



class StoreNote implements AdvancedNoteCreator{


	@Override
	public void StoreNoteCreate(String Money, String Topic, String Department, String Page, String Stock) {
		System.out.println("Store Note is created");	
		
	}
	
}

class NoteAdapter implements NoteCreator {

	AdvancedNoteCreator advancednotecreator;
	
	public NoteAdapter(int barcode) {
		
		if(barcode == 00) {
			advancednotecreator = new StoreNote();
		} 
	}

	@Override
	public void create(int barcode,String Money, String Topic, String Department, String Page, String Stock) {
		if(barcode == 00) {
			advancednotecreator.StoreNoteCreate("Money", "Topic", "Department", "Page", "Stock"); 
		}
		
	}

}

class NoteBuilder implements NoteCreator {
	NoteAdapter noteadapter;

	@Override
	public void create(int barcode,String Money, String Topic, String Department, String Page, String Stock) {
		if (barcode != 00) {
			System.out.println("Lesson Note is created");
		}
			else {
				noteadapter = new NoteAdapter(barcode);
				noteadapter.create(barcode, Money, Topic, Department, Page, Stock);	
			}
		}
		
	}
	

	



















