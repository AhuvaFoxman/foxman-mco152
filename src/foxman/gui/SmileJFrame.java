package foxman.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SmileJFrame extends JFrame {

	public SmileJFrame() {

		setTitle("Smile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		
		//put the smileComponent in the center because it expands
		//need to specify a zone
		container.add(new SmileComponent(), BorderLayout.CENTER);
		
		
		
	}





	public static void main (String args[]){
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
              //  try {
                    try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
               // } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                   // ((Throwable) ex).printStackTrace();
             //   }
		
		new SmileJFrame().setVisible(true);

;}
		});
	}
}
	
	