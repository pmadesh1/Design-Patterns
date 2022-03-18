package ptbs;

import ptbs.UserData.USER_TYPE;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Exception;
import java.util.List;


public class Login extends JFrame{

    boolean isExit = false;
    boolean loginStatus = true;
    JLabel jLabel1 = new JLabel("UserName ");
    JLabel jLabel2 = new JLabel("Password");;
    JButton loginButton = new JButton("Login");
    JButton exitButton = new JButton("Exit");;
    JTextField UserNameText = new JTextField();
    JPasswordField PasswordText = new JPasswordField();;
    JRadioButton BuyerRadio = new JRadioButton("Buyer");
    JRadioButton SellerRadio = new JRadioButton("Seller");
    ButtonGroup buttonGroup = new ButtonGroup();
    JPanel loginPanel = new JPanel(new GridLayout(4, 1));
    private DataManager dataManager = null;
    private USER_TYPE userType = USER_TYPE.Buyer;
    private Facade facade = new Facade();
    String userName, password;

    private UserData userData;

    public Login(UserData userData){
        this.userData = userData;
        dataManager = new DataManager();
        initializeLoginPanel();
        setSize(600 ,200);
    }

    void initializeLoginPanel(){
        //System.out.println("login panel");
        jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
        jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
        loginButton.setBounds(new Rectangle(31, 212, 85, 28));
        exitButton.setBounds(new Rectangle(180, 211, 97, 28));
        UserNameText.setBounds(new Rectangle(119, 52, 144, 22));
        PasswordText.setBounds(new Rectangle(118, 119, 147, 22));

        BuyerRadio = new JRadioButton("Buyer");
        BuyerRadio.setSelected(true);
        BuyerRadio.setBounds(new Rectangle(37, 164, 103, 26));
        SellerRadio = new JRadioButton("Seller");
        SellerRadio.setBounds(new Rectangle(177, 162, 103, 26));

        loginPanel.add(jLabel1);
        loginPanel.add(UserNameText);
        loginPanel.add(jLabel2);
        loginPanel.add(PasswordText);
        loginPanel.add(loginButton);
        loginPanel.add(exitButton);
        loginPanel.add(BuyerRadio);
        loginPanel.add(SellerRadio);
        buttonGroup.add(BuyerRadio);
        buttonGroup.add(SellerRadio);

        //set border to panel
        add(loginPanel, BorderLayout.CENTER);

        setTitle("PTBS - Login Form");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginButton_actionPerformed(e);
            }
        });

        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("exit click");
                isExit = true;
            }
        });
    }
    void loginButton_actionPerformed(ActionEvent e) {
        System.out.println("Login clicked");
        try{
            String storedPassword ="";
            setUserName(UserNameText.getText());
            setPassword(new String(PasswordText.getPassword()));
            if (BuyerRadio.isSelected()){
                this.userData.setUserType(UserData.USER_TYPE.Buyer);
                storedPassword = dataManager.fetchPassword(userName, "BuyerInfo.txt");

            } else {
                this.userData.setUserType(UserData.USER_TYPE.Seller);
                storedPassword = dataManager.fetchPassword(userName, "SellerInfo.txt");
            }

            if(!(password.equals(storedPassword))){
                isExit = true;
            }
            else {
                loginStatus = true;
                System.out.println(" Login Successful - userType " + userData.userType);
                System.out.println(" Login Successful - userType " + userData.userName);
                facade.CreateUser(userData);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    void setUserName(String name){
        userName = name;
        this.userData.setUserName(name);
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
    USER_TYPE getUserType() {
        return userType;
    }
}
