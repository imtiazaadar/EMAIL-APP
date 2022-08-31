package EmailByJavaImtiazAdar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailApp1 extends JFrame implements ActionListener{
    static EmailApp1 frame;
    public String stat = "";
    private JLabel statLabel;
    private Container container;
    EmailApp1(String stat){
        this.stat = stat;
        content();
    }
    public void content(){
        container = new Container();
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon(getClass().getResource("icon6.png"));
        setIconImage(icon.getImage());
        Cursor c1 = new Cursor(Cursor.HAND_CURSOR);
        Color textC = Color.RED;
        statLabel = new JLabel(stat);
        if(stat.toLowerCase().equals("email sent successfully...")) {
            statLabel.setBounds(49, 350, 600, 50);
            try {
                Timer timer = new Timer(5000, this);
                timer.setRepeats(false);
                timer.start();
            }
            catch(Exception ee){
                ee.printStackTrace();
            }
        }
        statLabel.setForeground(textC);
        statLabel.setFont(new Font("Ink Free", Font.BOLD, 40));
        container.add(statLabel);
    }

    public static void main(String[] args) {
        frame = new EmailApp1("");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(400,5, 700, 820);
        frame.setTitle("EMAIL APP BY IMTIAZ ADAR");
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
