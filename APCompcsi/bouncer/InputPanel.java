package bouncer;

import java.awt.Color;
//import java.awt.Font; annoying porblme
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InputPanel extends JPanel {
  JTextField txtFieldRadius = new JTextField(3);
  JTextField txtFieldWidth = new JTextField(3);
  JTextField txtFieldHeight = new JTextField(3);
  
  JTextField txtFieldDx = new JTextField(3);
  JTextField txtFieldDy = new JTextField(3);
  
  JTextField txtFieldRotation = new JTextField(3);
  
  String[] colorStrings = { "Red", "Blue", "Green", "Magenta", "Yellow",
    "Orange" };
  
  Color[] colorObs = { Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA,
    Color.YELLOW, Color.ORANGE };
  JComboBox<String> cbxColor = new JComboBox<>(colorStrings);
  
  String[] shapeStrings = { "Circle", "Wheel", "Rectangle", "Beach Ball" };
  JComboBox<String> cbxShape = new JComboBox<>(shapeStrings);
  
  JButton jbtAdd = new JButton("Add");
  BouncingPanel bouncingPanel;
  
  public InputPanel(BouncingPanel bouncingPanel) {
    this.bouncingPanel = bouncingPanel;
    
    setLayout(new GridLayout(10, 2, 10, 10));
    setBorder(new EmptyBorder(10, 10, 10, 10));
    
    add(new JLabel("Radius:"));
    add(txtFieldRadius);
    txtFieldRadius.setText("20");
    
    add(new JLabel("Width:"));
    add(txtFieldWidth);
    txtFieldWidth.setText("30");
    
    add(new JLabel("Height:"));
    add(txtFieldHeight);
    txtFieldHeight.setText("45");
    
    add(new JLabel("dX:"));
    add(txtFieldDx);
    txtFieldDx.setText("10");
    
    add(new JLabel("dY:"));
    add(txtFieldDy);
    txtFieldDy.setText("3");
    
    add(new JLabel("Rotation:"));
    add(txtFieldRotation);
    txtFieldRotation.setText("10");
    
    add(new JLabel("Color:"));
    add(cbxColor);
    
    add(new JLabel("Shape:"));
    add(cbxShape);
    
    add(jbtAdd);
    jbtAdd.addActionListener(new AddListener());
  }
  
  public class AddListener implements ActionListener {
    
    public void actionPerformed(ActionEvent e) {
      try {
        int radius = Integer.parseInt(txtFieldRadius.getText());
        int dx = 0;
        int dy = 0;
        //int dTheta = 0; problemo
        int width = 0;
        int height = 0;
        
        if (txtFieldDx.getText().isEmpty() == false)
          dx = Integer.parseInt(txtFieldDx.getText());
        
        if (txtFieldDy.getText().isEmpty() == false)
          dy = Integer.parseInt(txtFieldDy.getText());
        
        if (txtFieldRotation.getText().isEmpty() == false)
          //dTheta = Integer.parseInt(txtFieldRotation.getText()); problemo
        
        if (txtFieldWidth.getText().isEmpty() == false)
          width = Integer.parseInt(txtFieldWidth.getText());
        
        if (txtFieldHeight.getText().isEmpty() == false)
          height = Integer.parseInt(txtFieldHeight.getText());
        
        Color color = colorObs[cbxColor.getSelectedIndex()];
        
        String shape = (String) cbxShape.getSelectedItem();
        
        Sprite sprite = null;
        switch (shape) {
          case "Circle":
          sprite = new CircleSprite(bouncingPanel, dx, dy, radius, color);
            break;
          case "Wheel":
            sprite = new WheelSprite(bouncingPanel, dx, dy, radius, color);
            break;
          case "Rectangle":
            sprite = new RectangleSprite(bouncingPanel, dx, dy, width, height, color);
            break;
          case "Beach Ball":
//            sprite = new BeachBallSprite(bouncingPanel, dx, dy, dTheta, radius);
            break;
          default:
            System.out.println("Unknown shape type: " + shape);
        }
        
        bouncingPanel.add(sprite);
      } catch (Exception ex) {
        System.out.println("Error");
      }
    }
    
  }
}
