package foxman.pi;

import javax.swing.JLabel;

public class PiCalculationThread extends Thread{
	//need threads because calculations take alot of time
	//don't want to wait for a long time
	//usually everything uses the main thread
	
	//WHENVER THERE IS A PROGRAM THAT IS LONG RUNNING
	//IT MUST BE DONE IN ANOTHER THREAD.
	
	
	
	private JLabel label;
	
	public PiCalculationThread(JLabel label){
		
		this.label = label;
		
	}
	
	public void run(){
		//This is the code that will execute on 
		//a different thread than the main thread
		
		PiCalculator calc = new PiCalculator();
		double pi = calc.calculate(1000000000L);
		label.setText(String.valueOf(pi));
	}

}
