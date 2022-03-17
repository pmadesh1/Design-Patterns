package ptbs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Exception;
import java.util.List;


public class Login extends JFrame{

    boolean isExit = false;
    JLabel jLabel1 ,jLabel2;
    JButton loginButton ,exitButton ;
    JTextField UserNameText ;
    JPasswordField PasswordText ;
    JRadioButton BuyerRadio ,  SellerRadio;
    ButtonGroup buttonGroup1;
    JPanel loginPanel;
    String userName;
    String password;
    private DataManager dataManager = null;

    public Login(){
        dataManager = new DataManager();
        initializeLoginPanel();
        this.setSize(600 ,200);
        this.setVisible(true);
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

        setTitle("LOGIN FORM");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("login click");
                loginButton_actionPerformed(e);
            }
        });

        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("exit click");
                isExit = true;
            }
        });
        System.out.println("End of Login init");
    }
    void loginButton_actionPerformed(ActionEvent e) {
        System.out.println("On click called");
        try{
            String storedPassword ="";
            setUserName(UserNameText.getText().toString());
            setPassword(new String(PasswordText.getPassword()));
            if (BuyerRadio.isSelected() == true){
                storedPassword = dataManager.fetchPassword(userName, "BuyerInfo.txt");
            } else {
                storedPassword = dataManager.fetchPassword(userName, "SellerInfo.txt");
            }
            if(!(password.equals(storedPassword))){
                isExit = true;
            }
            System.out.println(" Login Successful");
        }
        catch(Exception ex){

        }
    }

    void setUserName(String name){
        userName = name;
    }

    void setPassword(String key){
        password = key;
    }

    String getUserName() {
        return userName;
    }
    String getPassword(){
        return password;
    }
}
