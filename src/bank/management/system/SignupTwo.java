package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {

    JTextField  pan,aadhar;
    JButton next;
    JRadioButton syes, sno,eyes, eno;
    JComboBox religion, Category,Occupation,Education, Income;
    String formno;
    
    SignupTwo(String formno) {
        this.formno=formno;

        setLayout(null);

        setTitle("NEW APPLICATION FORM - PAGE 2");
       

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh","Christian", "Other"};
         religion = new JComboBox (valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
       
        JLabel fname = new JLabel("Category : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        Category = new JComboBox(valCategory);
        Category.setBounds(300, 190, 400, 30);
        Category.setBackground(Color.WHITE);
        add(Category);

        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        String Incomecategory[] = {"Null", "<1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
         Income = new JComboBox(Incomecategory);
        Income.setBounds(300, 240, 400, 30);
        Income.setBackground(Color.WHITE);
        add(Income);


        JLabel Gender = new JLabel("Educational ");
        Gender.setFont(new Font("Raleway", Font.BOLD, 20));
        Gender.setBounds(100, 290, 200, 30);
        add(Gender);

        JLabel Email = new JLabel("Qualification : ");
        Email.setFont(new Font("Raleway", Font.BOLD, 20));
        Email.setBounds(100, 315, 200, 30);
        add(Email);
        
        
        String EducationValues[] = {"Non Graduation", "Graduation", "Post Graduation", "Doctrate", "Others"};
        Education = new JComboBox(EducationValues);
        Education.setBounds(300, 315, 400, 30);
        Education.setBackground(Color.WHITE);
        add(Education);

       

        JLabel marital = new JLabel("Occupation : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        String OccupationValues[] = {"Salaries", "Self-Employed", "Business", "Student", "Others"};
        Occupation = new JComboBox(OccupationValues);
        Occupation.setBounds(300, 390, 400, 30);
        Occupation.setBackground(Color.WHITE);
        add(Occupation);

     

        JLabel address = new JLabel("Pan Number : ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

       JLabel city= new JLabel("Aadhar Number : ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen : ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        eyes = new JRadioButton("Yes");
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(300,540,100,30);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBackground(Color.WHITE);
        eno.setBounds(450,540,200,30);
        add(eno);
        
        ButtonGroup emaritialgroup = new ButtonGroup();
        emaritialgroup.add(eyes);
        emaritialgroup.add(eno);

        JLabel pincode = new JLabel("Existing Account : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        syes = new JRadioButton("Yes");
        syes.setBackground(Color.WHITE);
        syes.setBounds(300,590,100,30);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBackground(Color.WHITE);
        sno.setBounds(450,590,100,30);
        add(sno);
        
        ButtonGroup smaritialgroup = new ButtonGroup();
        smaritialgroup.add(syes);
        smaritialgroup.add(sno);
        

        next = new JButton("Next");
        next.setForeground(Color.yellow);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
       
        String sreligion = (String) religion.getSelectedItem();
        String sCategory = (String) Category.getSelectedItem();
        String sincome = (String) Income.getSelectedItem();
        String seducation = (String)Education.getSelectedItem();
        String soccupation = (String) Occupation.getSelectedItem();

        String seniorcitizen = null;
        if (eyes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (eno.isSelected()) {
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if (syes.isSelected()) {
            existingaccount = "Yes";
        } else if (sno.isSelected()) {
            existingaccount = "No";
        } 
        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
                conn c = new conn();
                String query = "insert into signuptwo values('" + formno + "', '" + sreligion + "', '" + sCategory + "', '" + sincome + "', '" + seducation+ "', '" + soccupation + "','" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existingaccount +  "')";
                c.s.executeUpdate(query);
                
                // Signup 3 Object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String args[]) {
        new SignupTwo("");
    }
    
}

