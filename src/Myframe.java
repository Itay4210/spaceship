import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Myframe extends JFrame implements ActionListener {

     ImageIcon icon=new ImageIcon("SER.jpg");
     JLabel label =new JLabel(icon);
    ImageIcon iconenemy = new ImageIcon("a.png");
    ImageIcon iconenemy1 = new ImageIcon("b.png");
    ImageIcon iconenemy2 = new ImageIcon("a.png");
    ImageIcon iconenemy3 = new ImageIcon("b.png");

    JButton botton=new JButton("start");
    JButton botton1=new JButton("exit");
    JButton botton2=new JButton("ounder");
    JLabel labelenemy = new JLabel(iconenemy);
    JLabel labelenemy1 = new JLabel(iconenemy1);
    JLabel labelenemy2 = new JLabel(iconenemy);
    JLabel labelenemy3 = new JLabel(iconenemy1);
    Myframe(){
        labelenemy.setBounds(450, 20, 500, 500);
        labelenemy1.setBounds(550, 40, 500, 500);
        labelenemy2.setBounds(350, 60, 500, 500);
        labelenemy3.setBounds(550, 50, 500, 500);

        botton.setBounds(600,300,300,80);
        botton.setFont(new Font("mv boli",Font.PLAIN,40));
        botton.setForeground(Color.black);
        botton.setFocusable(false);
        botton.addActionListener(this);
        botton.setOpaque(false);
        botton.setContentAreaFilled(false);
        botton.setBorderPainted(false);


        botton1.setBounds(600,600,300,80);
        botton1.setFont(new Font("mv boli",Font.PLAIN,40));
        botton1.setForeground(Color.BLACK);
        botton1.setFocusable(false);
        botton1.addActionListener(this);

        botton1.setOpaque(false);
        botton1.setContentAreaFilled(false);
        botton1.setBorderPainted(false);


        botton2.setBounds(600,450,300,80);
        botton2.setFont(new Font("mv boli",Font.PLAIN,40));
        botton2.setForeground(Color.black);
        botton2.setFocusable(false);
        botton2.addActionListener(this);
        botton2.setOpaque(false);
        botton2.setContentAreaFilled(false);
        botton2.setBorderPainted(false);


        this.add(labelenemy);
        this.add(labelenemy1);
        this.add(labelenemy2);
        this.add(labelenemy3);
        this.add(botton);
        this.add(botton1);
        this.add(botton2);
        this.add(label);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(icon.getIconWidth(),icon.getIconHeight());
        this.setVisible(true);


        mainGameLoop();

    }

    int Xmove =8;
    int ymove =5;
    int Xmove1 =10;
    int ymove1 =12;
    int zmove =10;
    int tmove =3;
    int zmove1 =7;
    int tmove1 =4;
    private void mainGameLoop() {
        new Thread(() ->
        {
            while (true) {
                try {


                    if (labelenemy.getX() < -203 || labelenemy.getX() > 1225)
                        Xmove *= -1;
                    labelenemy.setLocation(labelenemy.getX() - Xmove,labelenemy.getY()+ymove);
                    if(labelenemy.getY()>540||labelenemy.getY()<-200)
                        ymove*=-1;
                    if (labelenemy1.getX() < -203 || labelenemy1.getX() > 1225)
                        Xmove1 *= -1;
                    labelenemy1.setLocation(labelenemy1.getX() +Xmove,labelenemy1.getY()+ymove1);
                    if(labelenemy1.getY()>540||labelenemy1.getY()<-200)
                        ymove1*=-1;
                    if (labelenemy2.getX() < -203 || labelenemy2.getX() > 1225)
                        zmove *= -1;
                    labelenemy2.setLocation(labelenemy2.getX() - zmove,labelenemy2.getY()+tmove);
                    if(labelenemy2.getY()>540||labelenemy2.getY()<-200)
                        tmove*=-1;
                    if (labelenemy3.getX() < -203 || labelenemy3.getX() > 1225)
                        zmove1 *= -1;
                    labelenemy3.setLocation(labelenemy3.getX() - zmove1,labelenemy3.getY()+tmove1);
                    if(labelenemy3.getY()>540||labelenemy3.getY()<-200)
                        tmove1*=-1;


                    this.repaint();
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

                    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botton) {
            //גורם שהחלון יפתח רק פעם אחת
            this.dispose();
            newwindow newwindow = new newwindow();
        }
        if (e.getSource() == botton1) {
            System.exit(0);
        }
                        if (e.getSource() == botton2) {
                            //גורם שהחלון יפתח רק פעם אחת
                            this.dispose();
                            ounder ounder=new ounder();
                        }
    }

}
