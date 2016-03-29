import javax.swing.JFrame;

public class VotingSystemDriver {
    private static void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("United States Presidential Election, 2020");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VotingSystem vote = new VotingSystem();
       
        frame.getContentPane().add(vote.getContent());
        frame.setSize(600,500);
        frame.setVisible(true);
    }
   
    public static void main(String[] args)
    {
        createAndDisplayGUI();
    }
}

