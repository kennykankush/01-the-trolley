

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class accountSetup {

    List<userDb> fetcher = new ArrayList<>();
    
    boolean isLogin = false;
    String currentUser = null;
    Scanner scanner = new Scanner(System.in);

    public void accountRegister() {                              
        
        System.out.println("What will be your username");
        String userName = scanner.nextLine();

        System.out.println("What will be your password");
        String Password = scanner.nextLine();

        userDb newUser = new userDb(userName, Password);

        fetcher.add(newUser);

    }

    public void accountLogin() {
        System.out.println("Key in your username: ");
        String userName = scanner.nextLine();

        System.out.println("Key in your password: ");
        String Password = scanner.nextLine();

        for (userDb x : fetcher){
            if (x.getUserName().equals(userName)){
                if (x.getPassWord().equals(Password)){
                    isLogin = true;
                    this.currentUser = x.getUserName();
                    System.out.println("Login successful");
                    break;
                } else {
                    System.out.println("Incorrect password");
                    break;
                }
            } 


        } 
        
        if (!isLogin) {
            System.out.println("No account found");
        }

    }                                  

    public void getList() {
        for (userDb user : fetcher) {
            System.out.println("Username: " + user.getUserName());
            System.out.println("Password: " + user.getPassWord());
        }
    }

    public void logOut() {
        System.out.println("Goodbye " + currentUser + "!");
        isLogin = false;
        currentUser = null;

    }

    public String getCurrentUser(){
        return currentUser;
    }

    

}
