import javax.swing.JFrame; 

public class DiceProgramDriver {
    /**
     * Create the GUI and show it. 
     */
	private static void createAndDisplayGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Dice Program"); //Window title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit when closed
		
		DiceProgram dice = new DiceProgram();
		frame.getContentPane().add(dice.getContent());
		
		frame.setSize(500,300);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		createAndDisplayGUI();
	}

}
