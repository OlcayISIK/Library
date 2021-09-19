import java.awt.Color;

import javax.swing.JButton;

public interface BackGround {
	void draw(JButton Button);
}

 class Button implements BackGround {
	@Override
	public void draw(JButton Button) {
		Button.setBackground(Color.green);
	}
 }
	
abstract class ButtonDecorator implements BackGround {
		   protected BackGround decoratedButton;

		   public ButtonDecorator(BackGround decoratedButton){
		      this.decoratedButton = decoratedButton;
		   }

		   public void draw(JButton Button){
			   decoratedButton.draw(Button);
		   }	
		}
	
 class RedButtonDecorator extends ButtonDecorator {

		   public RedButtonDecorator(BackGround decoratedButton) {
		      super(decoratedButton);		
		   }

		   @Override
		   public void draw(JButton Button) {	       
		      setRedBorder(Button);
		   }

		   private void setRedBorder(JButton Button){
			   Button.setBackground(Color.red);
		   }
 }
 
	

	
 