package bouncer;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class MainFrame extends JFrame {
  
  public MainFrame () {
    Border lineBorder = new LineBorder(Color.BLACK, 1);
    
    setTitle("Bouncer");
    setSize(1000, 500);
    setLayout(new BorderLayout(0,0));
    
    BouncingPanel bouncingPanel = new BouncingPanel();
    InputPanel inputPanel = new InputPanel(bouncingPanel);
    
    bouncingPanel.setBorder(lineBorder);
    inputPanel.setBackground(Color.GRAY);
    
    add(BorderLayout.CENTER, bouncingPanel);
    add(BorderLayout.EAST, inputPanel);    
  }
  
  public static void main(String[] args) {
    
    MainFrame frame = new MainFrame();
    
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
  
}
