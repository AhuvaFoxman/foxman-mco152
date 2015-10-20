package foxman.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
	
	public class JFrameDemo extends JFrame{
		
		 private JLabel label; //dont need final
		 private JLabel labelOne;
		 private JLabel labelTwo;
		 private JButton button;
		 private JTextField text;

		//constructor 
		public  JFrameDemo(){
			//need to do these 3 things in every constructor
			setTitle("JFrameDemo"); //sets the title
			setSize(800,600); //set the size in pixels
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits the program when u close ur window
			
			Container container = getContentPane(); //
			setLayout(new BoxLayout(container, BoxLayout.Y_AXIS)); //makes a flowLayout manager
			
			label = new JLabel("All this text gets show all the time");
			add(label);
			labelOne = new JLabel("All this text gets show all the time");
			add(labelOne);
			
		
			button = new JButton("Hello! This is a button");
			add(button); //this makes it display
			
			//do this to make the button do something
			button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Hello! :)");
									}
				
			});	//action listener is an interface
			
			
			add(button);
		
	
	}
	}


