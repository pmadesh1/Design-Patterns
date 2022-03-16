package ptbs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class Login extends JFrame{

    boolean isExit = false;
    JLabel jLabel1 ,jLabel2;
    JButton loginButton ,exitButton ;
    JTextField UserNameText ;
    JPasswordField PasswordText ;
    JRadioButton BuyerRadio ,  SellerRadio;
    ButtonGroup buttonGroup1;
    JPanel loginPanel;

    public Login(){
        initializeLoginPanel();
        this.setSize(600 ,200);  //set size of the frame
        this.setVisible(true);  //make form visible to the user
    }

    void initializeLoginPanel(){
        System.out.println("login panel");
        jLabel1 = new JLabel("UserName ");
        jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
        jLabel2 = new JLabel("Password");
        jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
        loginButton = new JButton("Login");
        loginButton.setBounds(new Rectangle(31, 212, 85, 28));

        exitButton = new JButton("Exit");
        exitButton.setBounds(new Rectangle(180, 211, 97, 28));
        UserNameText = new JTextField();
        PasswordText = new JPasswordField();
        UserNameText.setBounds(new Rectangle(119, 52, 144, 22));
        PasswordText.setBounds(new Rectangle(118, 119, 147, 22));

        BuyerRadio = new JRadioButton("Buyer");
        SellerRadio = new JRadioButton("Seller");
        BuyerRadio.setBounds(new Rectangle(37, 164, 103, 26));
        SellerRadio.setBounds(new Rectangle(177, 162, 103, 26));
        buttonGroup1 = new ButtonGroup();

        loginPanel = new JPanel(new GridLayout(4, 1));
        loginPanel.add(jLabel1);
        loginPanel.add(UserNameText);
        loginPanel.add(jLabel2);
        loginPanel.add(PasswordText);
        loginPanel.add(loginButton);
        loginPanel.add(exitButton);
        loginPanel.add(BuyerRadio);
        loginPanel.add(SellerRadio);

        buttonGroup1.add(BuyerRadio);
        buttonGroup1.add(SellerRadio);


        //set border to panel
        add(loginPanel, BorderLayout.CENTER);

        //perform action on button click
        //loginButton.addActionListener(this);
        setTitle("LOGIN FORM");
    }


    public static void main(String[] args) throws Exception {
        Login login = new Login();
        System.out.println("login panel -end main");

    }

}