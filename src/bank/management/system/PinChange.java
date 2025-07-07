
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame  implements ActionListener{

    
    JPasswordField pin,repin;
    JButton change, Back;
    String Pinnumber;
    
   PinChange (String pinnumber){
       this.Pinnumber = pinnumber;
       setLayout(null);
       
       
       ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = il.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel (i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text = new JLabel("CHANGE YOUR PIN");
       text.setForeground (Color.WHITE);
       text.setFont(new Font("System", Font.BOLD,16));
       text.setBounds(250,280,500,35);
       image.add(text);
       
       JLabel pintext = new JLabel("New pin: ");
       pintext.setForeground (Color.WHITE);
       pintext.setFont(new Font("System", Font.BOLD,16));
       pintext.setBounds(165,320,180,25);
       image.add(pintext);
       
       pin = new JPasswordField();
       pin.setFont(new Font ("Raleway", Font.BOLD,25));
       pin.setBounds(330,320,180,25);
       image.add(pin);
       
       JLabel repintext = new JLabel("Re-Enter New PIN: ");
       repintext.setForeground (Color.WHITE);
       repintext.setFont(new Font("System", Font.BOLD,16));
       repintext.setBounds(165,360,180,25);
       image.add(repintext);
       
       repin = new JPasswordField();
       repin.setFont(new Font ("Raleway", Font.BOLD,25));
       repin.setBounds(330,360,180,25);
       image.add(repin);
       
       change = new JButton("CHANGE");
       change.setBounds(355,485,150,30);
       change.addActionListener(this);
       image.add(change);
       
       Back = new JButton("BACK");
       Back.setBounds(355,520,150,30);
       Back.addActionListener(this);
       image.add(Back);
       
       
       
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == change){
          
       try{
           String npin = pin.getText();
           String rpin = repin.getText();
           
           if (!npin.equals(rpin)){
           JOptionPane.showMessageDialog(null, "Entered PIN does not match ");
           return;
           }
       
           if(npin.equals("")){
           JOptionPane.showMessageDialog(null, "Please enter new PIN ");
           return;    
           }
           
           if(rpin.equals("")){
           JOptionPane.showMessageDialog(null, "Please re-enter new PIN ");
           return;    
           }
           
           conn conn =new conn();
           String querry1 = "update bank set pin = '"+rpin+"' where pin ='"+Pinnumber+"'";
           String querry2 = "update Login set pin = '"+rpin+"' where pin ='"+Pinnumber+"'";
           String querry3 = "update SignupThree set pin = '"+rpin+"' where pin ='"+Pinnumber+"'";

        
           conn.s.executeUpdate(querry1);
           conn.s.executeUpdate(querry2);
           conn.s.executeUpdate(querry3);
           
           JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
           
           setVisible(false);
           new Transactions(rpin).setVisible(true);


       }catch (Exception e) {
           System.out.println(e);
       }
       
       }else{
           setVisible(false);
           new Transactions(Pinnumber).setVisible(true);
       }
       
   }
    
    public static void main(String args[]) {
     new PinChange("").setVisible(true);

    }
}
