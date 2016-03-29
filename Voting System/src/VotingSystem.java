import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class VotingSystem
{
    private JPanel panel;
    private JPanel buttonPanel;
    private JLabel fnameMsg;
    private JLabel lnameMsg;
    private JLabel thankYouMsg;
    private JButton voteButton;
    private JTextField fname;
    private JTextField lname;
    private ButtonGroup group;
    private JRadioButton candidate1 = new JRadioButton("Hillary Clinton");
    private JRadioButton candidate2 = new JRadioButton("Bernie Sanders");
    private JRadioButton candidate3 = new JRadioButton("Donald Trump");
    private JRadioButton candidate4 = new JRadioButton("Kanye West");
    private String candidateChosen = "";
   
    public VotingSystem()
    {
        panel = new JPanel();
        buttonPanel = new JPanel();
        group = new ButtonGroup();
        voteButton = new JButton("Vote");
        fnameMsg = new JLabel("Please enter you first name :");
        lnameMsg = new JLabel("last name :");
        thankYouMsg = new JLabel();
        fname = new JTextField(5);
        lname = new JTextField(5);
       
        candidate1.addActionListener(radioButtonListener());
        candidate2.addActionListener(radioButtonListener());
        candidate3.addActionListener(radioButtonListener());
        candidate4.addActionListener(radioButtonListener());
        voteButton.addActionListener(voteButtonListener());
       
        group.add(candidate1);
        group.add(candidate2);
        group.add(candidate3);
        group.add(candidate4);

        buttonPanel.add(candidate1);
        buttonPanel.add(candidate2);
        buttonPanel.add(candidate3);
        buttonPanel.add(candidate4);
        buttonPanel.add(voteButton);
        panel.add(fnameMsg);
        panel.add(fname);
        panel.add(lnameMsg);
        panel.add(lname);
        panel.add(buttonPanel);
        panel.add(thankYouMsg);
    }
   
    public Component getContent()
    {
        return (panel);
    }

    private ActionListener radioButtonListener()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                AbstractButton aButton = (AbstractButton) e.getSource();
                candidateChosen = aButton.getText();
                System.out.println("Selected: " + candidateChosen);
            }
        };
       
        return listener;
    }
   
    private ActionListener voteButtonListener()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input1 = fname.getText();
                String input2 = lname.getText();
                WriteFile ballot;
               
                if(input1.isEmpty() || input2.isEmpty())
                {
                    thankYouMsg.setText("Please enter your first and last name.");
                }
                else if(candidateChosen == "")
                {
                    thankYouMsg.setText("Please chose one of the four candidates.");
                }
                else
                {
                    ballot = new WriteFile(input2, input1);
                   
                    if(!ballot.alreadyVoted())
                    {
                        ballot.createFile("Vote for: " + candidateChosen);
                        thankYouMsg.setText("Thank you for voting!");
                    }
                    else
                    {
                        thankYouMsg.setText("You have already voted.");
                    }
                }

            }
        };
       
        return listener;
    } 
}
