import java.awt.BorderLayout;
import javax.swing.JFrame;

public class SafeConverterDriver
{
    private static void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("Safe Converter");
        SafeConverter converter = new SafeConverter();
       
        frame.getContentPane().add(converter.getContent(), BorderLayout.LINE_START);
        frame.getContentPane().add(converter.getButtons(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
   
    public static void main(String[] args)
    {
        createAndDisplayGUI();
    }
}
