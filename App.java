
import javax.swing.SwingUtilities;

import ui.MainFrame;

public class App {
	
	public static void main (String[] args) {

				
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Make connection DB here
				
				
				new MainFrame();
			}
		}); 
		

	}

}
