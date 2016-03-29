import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class DiceProgram {
	
	private JPanel content;
	private JTextField text;
	private JButton button;
	private JLabel label;
	private JLabel instruction;
	
	public DiceProgram()
	{
		content = new JPanel(); //Create with a grid layout of a single column
		text = new JTextField(3);
		button = new JButton("roll"); //make the button
		label = new JLabel("You roll:  "); //make the label for writing text to
		instruction = new JLabel("Pick number of sides: ");
		
		//Set up the Action Listener
		button.addActionListener(buttonListener());//this instance will handle the actions
		
		content.add(instruction);
		content.add(text);
		content.add(button);
		content.add(label);	
	}
	
	public Component getContent()
	{
		return(content);
	}
	
	private String rollMessage(int num)
	{
		//Create a message based on current counter number
		return (new String("You roll:  " + num + " "));
	}
	
	private ActionListener buttonListener() {
		
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
		        //When the button is pressed...
				String input = text.getText();
				Dice dice;
				
				if(input.isEmpty() || !isInteger(input))
				{
					instruction.setText("Please give a number that is greater than 0");
					label.setText("You roll:  ");
				}
				else
				{
					int numSide = Integer.parseInt(input);
					
					if(numSide <= 0)
					{
						instruction.setText("Please give a number that is greater than 0");
						label.setText("You roll:  ");
					}
					else
					{
						instruction.setText("");
						dice = new Dice(numSide);
						String msg  = rollMessage(dice.roll());
						label.setText(msg);	//update label
						System.out.println(msg); //update 
					}
				}
				
			}	
		};
		return listener;	
	}
	
	public static boolean isInteger(String s) {
		try
		{
			Integer.parseInt(s);
			// s is a valid integer
			return true;
		}
		catch (NumberFormatException ex)
		{
			return false;
		}
	}
}