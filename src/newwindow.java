import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class newwindow extends JFrame implements KeyListener {


    ImageIcon icon = new ImageIcon("SER.jpg");
    ImageIcon icon1 = new ImageIcon("jet.png");
    ImageIcon icon2 = new ImageIcon("til.png");
    ImageIcon iconenemy = new ImageIcon("a.png");
    ImageIcon iconenemy1 = new ImageIcon("b.png");
    ImageIcon shotenemy=new ImageIcon("bomb.png");
    ImageIcon shotenemy1=new ImageIcon("bomb.png");


    JLabel label = new JLabel(icon);
    JLabel label1 = new JLabel(icon1);
    JLabel label2 = new JLabel(icon2);
    JLabel labelenemy = new JLabel(iconenemy);
    JLabel labelenemy1 = new JLabel(iconenemy1);
    JLabel sccorlabel=new JLabel();
    JLabel shotenemylabel=new JLabel(shotenemy);
    JLabel shotenemylabel1=new JLabel(shotenemy1);


    Rectangle enemy1;
    Rectangle enemy2;
    Rectangle myplant;
    Rectangle myshot;
    Rectangle thiershot;
    Timer timer;

    boolean pose = true;
    boolean shotenemyship=true;
    boolean startShoot = true;

    Random rand = new Random();
    int r;
    int Xmove =10;
    int ymove =1;
    int Xmove2 =10;
    int ymove2 =1;

   int h=0;

    newwindow() {

        label1.setBounds(500, 500, 500, 500);
        label2.setBounds(icon1.getIconWidth(), icon1.getIconHeight(), 320, 200);
        labelenemy.setBounds(450, 50, 500, 500);
        labelenemy1.setBounds(550, 50, 500, 500);
        shotenemylabel1.setBounds(iconenemy1.getIconWidth(), iconenemy1.getIconHeight(), 500, 500);
        sccorlabel.setText("scorr:"+h);
        sccorlabel.setBounds(50,0,500,50);
        sccorlabel.setFont(new Font("mv bvoli",Font.PLAIN,50));
        sccorlabel.setForeground(Color.black);

        label2.setVisible(false);
        add(sccorlabel);
        add(labelenemy);
        add(labelenemy1);
        add(label1);
        add(label2);
        add(shotenemylabel);
        add(shotenemylabel1);
        add(label);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setResizable(false);
        setSize(icon.getIconWidth(), icon.getIconHeight());
        setVisible(true);

        enemy1=new Rectangle(labelenemy.getX(),labelenemy.getY(),65,65);
        enemy2=new Rectangle(labelenemy1.getX(),labelenemy1.getY(),65,65);
        myshot=new Rectangle(label2.getX(),label2.getY(),10,30);
       // myplant=new Rectangle(labelenemy.getX(),labelenemy.getY(),labelenemy.getWidth(),labelenemy.getHeight());
      // thiershot=new Rectangle(labelenemy.getX(),labelenemy.getY(),labelenemy.getWidth(),labelenemy.getHeight());

        mainGameLoop();
    }

    private void mainGameLoop() {
        new Thread(() ->
        {
            while (true) {
                try {
                      if (labelenemy.getX() < -203 || labelenemy.getX() > 1225)
                          Xmove *= -1;
                      labelenemy.setLocation(labelenemy.getX() - Xmove,labelenemy.getY()+ymove);
                      enemy1.setLocation(labelenemy.getX() ,labelenemy.getY());

                      if(labelenemy.getY()>200||labelenemy.getY()<-200)
                          ymove*=-1;
                    if (labelenemy1.getX() < -200 || labelenemy1.getX() > 1225)
                        Xmove2 *= -1;
                    labelenemy1.setLocation(labelenemy1.getX() +Xmove2,labelenemy1.getY()+ymove2);
                    enemy2.setLocation(labelenemy1.getX() ,labelenemy1.getY());
                    if(labelenemy1.getY()>200||labelenemy1.getY()<-200)
                        ymove2*=-1;

                    if (startShoot==true) {
                        label2.setLocation(label2.getX(), label2.getY() - 15);
                        myshot.setLocation(label2.getX(), label2.getY());
                    }

                    if (shotenemyship==true) {
                        shotenemylabel.setLocation(labelenemy.getX(), labelenemy.getY());

                    }
                    if (shotenemyship==true) {
                        shotenemylabel1.setLocation(labelenemy1.getX(), labelenemy1.getY());
                    }

                    if (label2.getY() <= -150) {
                        label2.setLocation(label1.getX(), label1.getY());
                        myshot.setLocation(label2.getX(), label2.getY());
                        startShoot = false;
                        pose = true;
                        label2.setVisible(false);

                    }
                    if(myshot.intersects(enemy1)){
                      //  labelenemy.setVisible(false);
                        labelenemy.setLocation(50,-200);
                        label2.setLocation(label1.getX(), label1.getY());
                        myshot.setLocation(label2.getX(), label2.getY());
                        startShoot = false;
                        pose = true;
                        shotenemylabel.setVisible(false);
                        label2.setVisible(false);
                        h+=50;
                       sccorlabel.setText("scoor:"+h);

                    }
                    if(myshot.intersects(enemy2)){
                        //labelenemy.setVisible(false);
                        labelenemy1.setLocation(50,-200);
                        label2.setLocation(label1.getX(), label1.getY());
                        myshot.setLocation(label2.getX(), label2.getY());
                        startShoot = false;
                        pose = true;
                        shotenemylabel1.setVisible(false);
                        label2.setVisible(false);

                        h+=50;
                        sccorlabel.setText("scoor:"+h);
                    }

//                    this.repaint();
                    Thread.sleep(25);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
       switch (e.getKeyChar()) {

            case 'a':
                if (label1.getX() <= -195) {
                    label1.setLocation(-195, label1.getY());


                }
                label1.setLocation(label1.getX() - 10, label1.getY());

                break;
            case 's':
                if (label1.getY() >= 520) {
                    label1.setLocation(label1.getX(), 520);

                }

                label1.setLocation(label1.getX(), label1.getY() + 10);
                break;
            case 'd':
                if (label1.getX() >= 1200) {
                    label1.setLocation(1200, label1.getY());

                }

                label1.setLocation(label1.getX() + 10, label1.getY());
                break;
            case 'w':

                if (label1.getY() <= -165) {
                    label1.setLocation(label1.getX(), -165);

                }
                label1.setLocation(label1.getX(), label1.getY() - 10);
                break;
            case ' ':
                label2.setVisible(true);
                if(pose==true) {
                    label2.setLocation(label1.getX() + 94, label1.getY() + 35);
                    myshot.setLocation(label1.getX() , label1.getY());
                }

                startShoot = true;
                pose = false;

                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case 37:
                if (label1.getX() <= -195) {
                    label1.setLocation(-195, label1.getY());

                }
                label1.setLocation(label1.getX() - 10, label1.getY());
                break;
            case 40:
                if (label1.getY() >= 520) {
                    label1.setLocation(label1.getX(), 520);

                }
                label1.setLocation(label1.getX(), label1.getY() + 10);
                break;
            case 39:

                if (label1.getX() >= 1200) {
                    label1.setLocation(1200, label1.getY());

                }
                label1.setLocation(label1.getX() + 10, label1.getY());
                break;
            case 38:
                if (label1.getY() <= -165) {
                    label1.setLocation(label1.getX(), -165);

                }
                label1.setLocation(label1.getX(), label1.getY() - 10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        System.out.println("you released:" + e.getKeyChar());
        System.out.println("you released:" + e.getKeyCode());
    }
    //todo Yechiel was here
}
