package ptbs;

import ptbs.Facade;
import java.util.Scanner;

public class PtbsMain {
    static Scanner sc= new Scanner(System.in); //System.in is a standard input stream
    static Facade facade = new Facade();

    public static void main(String[] args) throws Exception {
        UserData userData = new UserData();
        System.out.println(" login main");
        boolean loginStatus = facade.login(userData);
        System.out.print(userData.getUserName());
        //facade.createUser(userData);
        if(loginStatus)
            System.out.println(" exit");
    }
}
