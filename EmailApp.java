package EmailByJavaImtiazAdar;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Properties;
/*
 * Author : Imtiaz Adar
 * Email : imtiaz-adar@hotmail.com
 * Phone : +8801778-767775, +8801886-187555
 * Program : Email App
 * Language : Java
 * Date : 31 / 08 / 2022
 */
public class EmailApp extends JFrame implements ActionListener {
    private static Container container;
    private static JLabel welcome;
    private static JLabel email;
    private static JLabel password;
    private static JLabel subject;
    private static JLabel message;
    private static JLabel attachment;
    private static JLabel recipient;
    private static JLabel status;
    private static JButton sendMail;
    private static JButton panel;
    private static JTextField emailF;
    private static JPasswordField passF;
    private static JTextField subjectF;
    private static JTextField messageF;
    private static JTextField recipientF;
    private static Border border;
    private static Color textC;
    private static String path = "";
    static EmailApp frame;
    EmailApp(){
        content();
    }
    public void content(){
        container = new Container();
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon(getClass().getResource("icon6.png"));
        setIconImage(icon.getImage());
        border = BorderFactory.createLineBorder(Color.GRAY, 5);
        Cursor c1 = new Cursor(Cursor.HAND_CURSOR);
        textC = new Color(32, 32, 32);
        welcome = new JLabel("EMAIL APP BY IMTIAZ ADAR");
        welcome.setBounds(50, 20, 600, 50);
        welcome.setForeground(textC);
        welcome.setFont(new Font("Ink Free", Font.BOLD, 40));
        container.add(welcome);
        email = new JLabel("EMAIL");
        email.setBounds(40, 100, 600, 40);
        email.setForeground(textC);
        email.setFont(new Font("Ink Free", Font.BOLD, 30));
        status = new JLabel("");
        status.setBounds(550, 713, 200, 30);
        status.setForeground(Color.RED);
        status.setFont(new Font("Ink Free", Font.BOLD, 30));
        container.add(status);
        emailF = new JTextField("");
        emailF.setBounds(40, 140, 605, 40);
        emailF.setMargin(new Insets(5,5,5,5));
        emailF.setForeground(Color.BLACK);
        emailF.setFont(new Font("Arial", Font.PLAIN, 20));
        Border b1 = emailF.getBorder();
        Border b2 = BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(102, 0, 51));
        Border n1 = BorderFactory.createCompoundBorder(b2, b1);
        emailF.setBorder(n1);
        container.add(emailF);
        container.add(email);
        password = new JLabel("PASSWORD");
        password.setBounds(40, 200, 600, 30);
        password.setForeground(textC);
        password.setFont(new Font("Ink Free", Font.BOLD, 30));
        container.add(password);
        passF = new JPasswordField("");
        passF.setBounds(40, 240, 605, 40);
        passF.setMargin(new Insets(5,5,5,5));
        passF.setForeground(Color.BLACK);
        passF.setFont(new Font("Arial", Font.PLAIN, 20));
        passF.setEchoChar('*');
        Border b3 = passF.getBorder();
        Border b4 = BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(102, 0, 51));
        Border n2 = BorderFactory.createCompoundBorder(b4, b3);
        passF.setBorder(n2);
        container.add(passF);
        recipient = new JLabel("RECIPIENT");
        recipient.setBounds(40, 300, 600, 30);
        recipient.setForeground(textC);
        recipient.setFont(new Font("Ink Free", Font.BOLD, 30));
        container.add(recipient);
        recipientF = new JTextField("");
        recipientF.setBounds(40, 340, 605, 40);
        recipientF.setMargin(new Insets(5,5,5,5));
        recipientF.setForeground(Color.BLACK);
        recipientF.setFont(new Font("Arial", Font.PLAIN, 20));
        Border b12 = recipientF.getBorder();
        Border b13 = BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(102, 0, 51));
        Border n6 = BorderFactory.createCompoundBorder(b13, b12);
        recipientF.setBorder(n6);
        container.add(recipientF);
        subject = new JLabel("SUBJECT");
        subject.setBounds(40, 400, 600, 30);
        subject.setForeground(textC);
        subject.setFont(new Font("Ink Free", Font.BOLD, 30));
        container.add(subject);
        subjectF = new JTextField("");
        subjectF.setBounds(40, 440, 605, 40);
        subjectF.setMargin(new Insets(5,5,5,5));
        subjectF.setForeground(Color.BLACK);
        subjectF.setFont(new Font("Arial", Font.PLAIN, 20));
        Border b5 = subjectF.getBorder();
        Border b6 = BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(102, 0, 51));
        Border n3 = BorderFactory.createCompoundBorder(b6, b5);
        subjectF.setBorder(n3);
        container.add(subjectF);
        message = new JLabel("MESSAGE");
        message.setBounds(40, 500, 600, 30);
        message.setForeground(textC);
        message.setFont(new Font("Ink Free", Font.BOLD, 30));
        container.add(message);
        messageF = new JTextField("");
        messageF.setBounds(40, 540, 605, 40);
        messageF.setMargin(new Insets(5,5,5,5));
        messageF.setForeground(Color.BLACK);
        messageF.setFont(new Font("Arial", Font.PLAIN, 20));
        Border b7 = messageF.getBorder();
        Border b8 = BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(102, 0, 51));
        Border n4 = BorderFactory.createCompoundBorder(b8, b7);
        messageF.setBorder(n4);
        container.add(messageF);
        attachment = new JLabel("ATTACHMENT");
        attachment.setBounds(40, 600, 600, 30);
        attachment.setForeground(textC);
        attachment.setFont(new Font("Ink Free", Font.BOLD, 30));
        container.add(attachment);
        panel = new JButton("CHOOSE");
        panel.setBounds(40, 640, 605, 40);
        panel.setForeground(textC);
        panel.setCursor(c1);
        panel.setFocusPainted(false);
        panel.setFont(new Font("Arial", Font.PLAIN, 30));
        Border b10 = panel.getBorder();
        Border b11 = BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(102, 0, 51));
        Border n5 = BorderFactory.createCompoundBorder(b11, b10);
        panel.setBorder(n5);
        container.add(panel);
        panel.addActionListener(this);
        sendMail = new JButton("SEND EMAIL");
        sendMail.setBounds(140, 710, 405, 40);
        sendMail.setBackground(new Color(102, 0, 51));
        sendMail.setForeground(Color.WHITE);
        sendMail.setFont(new Font("Arial", Font.BOLD, 30));
        sendMail.setCursor(c1);
        sendMail.setFocusPainted(false);
        container.add(sendMail);
        sendMail.addActionListener(this);
        sendMail.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                sendMail.setForeground(new Color(102, 0, 51));
                sendMail.setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sendMail.setForeground(Color.WHITE);
                sendMail.setBackground(new Color(102, 0, 51));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                sendMail.setForeground(new Color(102, 0, 51));
                sendMail.setBackground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                sendMail.setForeground(new Color(102, 0, 51));
                sendMail.setBackground(Color.WHITE);
            }
        });

    }
    public static void main(String[] args) {
        frame = new EmailApp();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(400,5, 700, 820);
        frame.setTitle("EMAIL APP BY IMTIAZ ADAR");
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panel){
            if(panel.getText() != "") {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    path = file.getAbsolutePath();
                    System.out.println(path);
                }
            }
            else {
                path = "";
            }
        }
        if(e.getSource() == sendMail){
            getConnection(recipientF.getText(), subjectF.getText(), messageF.getText(), emailF.getText(), passF.getText(), path);
        }
    }
    public static void getConnection(String recipient, String subject, String message, String u_email, String u_password, String f_path){
        final String host = "smtp.gmail.com";
        final int port = 587;
        final String protocol = "TLSv1.2";
        try{
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", true);
            properties.put("mail.smtp.starttls.enable", true);
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.ssl.protocols", protocol);
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(u_email, u_password);
                }
            });
            Message message1 = sendMessage(session, u_email, recipient, subject, message, f_path);
            Transport.send(message1);
            System.out.println("Email Sent Successfully...");
            EmailApp1 em1 = new EmailApp1("EMAIL SENT SUCCESSFULLY...");
            em1.setVisible(true);
            em1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            em1.setVisible(true);
            em1.setBounds(400,5, 700, 820);
            em1.setTitle("EMAIL APP BY IMTIAZ ADAR");
            em1.setResizable(false);
            frame.setVisible(false);
            //status.setText("SENT !");
//            System.exit(0);

        }
        catch (Exception e){
            System.out.println("Sending Failed...");
            status.setText("FAILED!");
        }
    }

    public static Message sendMessage(Session session, String u_email, String recipient, String subject, String message, String f_path) throws Exception{
        System.out.println("Sending Email !...");
        Message textMessage = new MimeMessage(session);
        textMessage.setFrom(new InternetAddress(u_email));
        textMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        textMessage.setSubject(subject);
        textMessage.setText(message);
        if(!f_path.equals("")) {
            MimeMultipart content = new MimeMultipart();
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(message + "\nMulti Message BY Imtiaz Adar, File Attached Below !");
            MimeBodyPart filePart = new MimeBodyPart();
            filePart.attachFile(new File(f_path));
            content.addBodyPart(textPart);
            content.addBodyPart(filePart);
            textMessage.setContent(content);
        }
        return textMessage;
    }
}
