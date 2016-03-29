import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;

public class SafeConverter
{   
    private JPanel panel;
    private JPanel buttonPanel;
    private JButton f_cButton;
    private JButton f_kButton;
    private JButton c_kButton;
    private JButton c_fButton;
    private JButton k_fButton;
    private JButton k_cButton;
    private JTextField text;
    private JLabel label;
   
    public SafeConverter()
    {
        panel = new JPanel();
        buttonPanel = new JPanel();
        f_cButton = new JButton("Convert from F to C");
        f_kButton = new JButton("Convert from F to K");
        c_kButton = new JButton("Convert from C to K");
        c_fButton = new JButton("Convert from C to F");
        k_fButton = new JButton("Convert from K to F");
        k_cButton = new JButton("Convert from K to C");
        text = new JTextField(3);//3 cols
        label = new JLabel("Enter a temperature: ");
       
        //Load the listener
        f_cButton.addActionListener(f_cButtonListener());   
        f_kButton.addActionListener(f_kButtonListener());
        c_kButton.addActionListener(c_kButtonListener());
        c_fButton.addActionListener(c_fButtonListener());
        k_fButton.addActionListener(k_fButtonListener());
        k_cButton.addActionListener(k_cButtonListener());
       
       
        //load the panel
        panel.add(label);
        panel.add(text);
        buttonPanel.add(f_cButton);
        buttonPanel.add(f_kButton);
        buttonPanel.add(c_kButton);
        buttonPanel.add(c_fButton);
        buttonPanel.add(k_fButton);
        buttonPanel.add(k_cButton);
    }
   
    public Component getContent()
    {
        return (panel);
    }
    
    public Component getButtons()
    {
        return (buttonPanel);
    }
    
    public static boolean isDouble(String s)
    {
        try
        {
            Double.parseDouble(s);
            // s is a valid integer
            return true;
        }
        catch (NumberFormatException ex)
        {
            return false;
        }
    }
   
    private ActionListener f_cButtonListener()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = text.getText();
                String newText;
               
                if(input.isEmpty() || !isDouble(input))
                {
                    newText = "Please give a valid value";
                }
                else
                {
                    double tempInF = Double.parseDouble(input);//convert String to double
                    double tempInC = (tempInF-32)*(5.0/9.0); //convert F to C
                    newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
                    //only display 2 places past decimal
                }
               
                label.setText(newText);
                System.out.println(newText);
            }
        };
       
        return listener;
    }

    private ActionListener f_kButtonListener()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = text.getText();
                String newText;
               
                if(input.isEmpty() || !isDouble(input))
                {
                    newText = "Please give a valid value";
                }
                else
                {
                    double tempInF = Double.parseDouble(input);//convert String to double
                    double tempInK = (tempInF+459.67)*(5.0/9.0); //convert F to K
                    newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
                    //only display 2 places past decimal
                }
               
                label.setText(newText);
                System.out.println(newText);
            }
        };
       
        return listener;
    }
   
    private ActionListener c_kButtonListener()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = text.getText();
                String newText;
               
                if(input.isEmpty() || !isDouble(input))
                {
                    newText = "Please give a valid value";
                }
                else
                {
                    double tempInC = Double.parseDouble(input);//convert String to double
                    double tempInK = (tempInC+273.15); //convert C to K
                    newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
                    //only display 2 places past decimal
                }
               
                label.setText(newText);
                System.out.println(newText);
            }
        };
       
        return listener;
    }
   
    private ActionListener k_fButtonListener()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = text.getText();
                String newText;
               
                if(input.isEmpty() || !isDouble(input))
                {
                    newText = "Please give a valid value";
                }
                else
                {
                    double tempInK = Double.parseDouble(input);//convert String to double
                    double tempInF = (tempInK)*(9.0/5.0)-459.67; //convert K to F
                    newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
                    //only display 2 places past decimal
                }
               
                label.setText(newText);
                System.out.println(newText);
            }
        };
       
        return listener;
    }

    private ActionListener c_fButtonListener()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = text.getText();
                String newText;
               
                if(input.isEmpty() || !isDouble(input))
                {
                    newText = "Please give a valid value";
                }
                else
                {
                    double tempInC = Double.parseDouble(input);//convert String to double
                    double tempInF = (tempInC)*(9.0/5.0)+32; //convert C to F
                    newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
                    //only display 2 places past decimal
                }
               
                label.setText(newText);
                System.out.println(newText);
            }
        };
       
        return listener;
    }

    private ActionListener k_cButtonListener()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = text.getText();
                String newText;
               
                if(input.isEmpty() || !isDouble(input))
                {
                    newText = "Please give a valid value";
                }
                else
                {
                    double tempInK = Double.parseDouble(input);//convert String to double
                    double tempInC = (tempInK)-273.15; //convert K to C
                    newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
                    //only display 2 places past decimal
                }
               
                label.setText(newText);
                System.out.println(newText);
            }
        };
       
        return listener;
    }
}