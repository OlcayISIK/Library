import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

 interface Strategy {
	
	 public double doOperation(int num1, int num2);
}

 class FindStock implements Strategy{ 

	@Override
	public  double doOperation(int num1, int num2) {
		return num1 + num2;
	}

}


class FindAverage implements Strategy{    
	
	@Override
	public  double doOperation(int num1, int num2) {
		 return (num1 / num2); 
		 
		
		
	}

}

class Context {
	
	   private Strategy strategy;

	   public Context(Strategy strategy){
	      this.strategy = strategy;
	   }

	   public double executeStrategy(int num1, int num2){
	      return strategy.doOperation(num1, num2);
	   }
	}


		

	


