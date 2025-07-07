
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login, signup ,clear;
    JTextField cardTextField ;
    JPasswordField pinTextField;
    Login(){
     
        setTitle("Automated Tellar Machine");
        
        setLayout (null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = il.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel (i3);
        label.setBounds(70,10,100,100);
        add (label);
        
        JLabel text = new JLabel ("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add (text);
        
         JLabel cardNo = new JLabel ("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD,28));
        cardNo.setBounds(120,150,1500,30);
        add (cardNo);
        
         cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD,14));
        add (cardTextField);
        
         JLabel pin = new JLabel ("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add (pin);
        
         pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD,14));
        add (pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300, 100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.yellow);
        login.addActionListener(this);
        add (login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300, 100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.YELLOW);
        clear.addActionListener(this);

        add (clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.YELLOW);
        signup.addActionListener(this);

        add (signup);
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource()== login){
           conn conn =  new conn();
           String cardnumber = cardTextField.getText();
           String pinnumber = pinTextField.getText();
           String querry = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
             try {
               ResultSet rs =   conn.s.executeQuery(querry);
               if (rs.next()){
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               } else{
                   JOptionPane.showMessageDialog(null, "Incorrect card Number or Pin ");
                   
               }
             }catch (Exception e){
                 System.out.println(e);
             }
        }else if (ae.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]) {
      new Login();
    }
}
