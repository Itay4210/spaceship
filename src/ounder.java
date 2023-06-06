import javax.swing.*;

public class ounder extends JFrame {


    ImageIcon icon = new ImageIcon("SER.jpg");
    JLabel label = new JLabel(icon);

    ounder(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(icon.getIconWidth(), icon.getIconHeight());
        setVisible(true);
       add(label);
    }
}
