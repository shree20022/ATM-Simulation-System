
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, miniStatment,Exit, fastcash, pinChange , BalanceEnquiry;
    String pinnumber;
    
    Transactions( String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transactions");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         miniStatment = new JButton("Mini Statment");
        miniStatment.setBounds(355, 450, 150, 30);
        miniStatment.addActionListener(this);
        image.add(miniStatment);
        
         pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        BalanceEnquiry = new JButton("Balance Enquiry");
        BalanceEnquiry.setBounds(355, 485, 150, 30);
        BalanceEnquiry.addActionListener(this);
        image.add(BalanceEnquiry);
        
         Exit = new JButton("Exit");
        Exit.setBounds(355, 520, 150, 30);
        Exit.addActionListener(this);
        image.add(Exit);
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == Exit){
            System.exit(0);
        } else if (ae.getSource () == deposit){
         setVisible(false);
         new Deposit(pinnumber).setVisible(true);
    }else if (ae.getSource() == withdrawl){
       setVisible(false);
       new Withdrawl(pinnumber).setVisible(true);
    }else if(ae.getSource()== fastcash){
        setVisible(false);
        new FastCash(pinnumber).setVisible(true);
    }else if (ae.getSource() == pinChange){
        setVisible(false);
        new PinChange(pinnumber).setVisible(true);
    }else if (ae.getSource() == BalanceEnquiry ){
        setVisible(false);
        new BalanceEnquiry(pinnumber).setVisible(true);
   }else if (ae.getSource()== miniStatment) {
       new MiniStatment(pinnumber).setVisible(true);
     }
    }
    public static void main(String args[]) {
       new  Transactions("");
    }
}
