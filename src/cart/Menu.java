import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    

    public void welcomePage(){

        System.out.println("Sign in or register?");
    }

    public void initiateMenu() throws IOException{

        accountSetup account = new accountSetup();
        ShoppingCart cart_101 = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        String input = "";
        boolean looper = true;

        // Eternal Selection

        // Login Phase
        while (looper){
            while (account.isLogin == false) {

                welcomePage();
                input = scanner.nextLine();
                
                if (input.equals("register")){
                    account.accountRegister();
                } else if (input.equals("login")) {
                    account.accountLogin();
                } else if (input.equals("quit")) {
                    System.out.println("Bye bye!");
                    return;

                } else {
                    System.out.println("No choice available");
                }

            }

            System.out.println("Welcome " + account.currentUser + "!");

            while (account.isLogin == true) {

                System.out.println("What would be your action next?");

                input = scanner.nextLine();

                switch(input){

                    case ("view"):
                        cart_101.viewList();
                        System.out.println("Current User:" + account.currentUser);
                        break;

                    case ("add"):
                        cart_101.addItem();
                        break; 
                    
                    case ("delete"):
                        cart_101.deleteItem();
                        break;
                    
                    case ("save"):

                    System.out.println("Print your save name");
                    String filePath = "listSave\\";

                    File directory = new File(filePath);
                    System.out.println("Current working directory: " + directory.getAbsolutePath());
                    System.out.println("Current working directory: " + directory.getCanonicalPath());
    
                    // Check if the directory exists; if not, create it
                    if (!directory.exists()) {
                        directory.mkdirs(); // Creates the "listSave" directory if it doesn't exist
                    }
                    String fileName = account.currentUser;
                    String fileFinal = filePath + fileName + ".csv";



                    cart_101.saveList(fileFinal, cart_101.map);
                    break;

                    case ("load"):
                        System.out.println("Extracting your file");
                        String filePath_extraction = "listSave\\";
                        String filePath_name = account.currentUser + ".csv";

                        String total_File = filePath_extraction + filePath_name;

                        cart_101.loadList(total_File);
                        
                        break;

                    case ("logout"):
                        account.isLogin = false;
                        cart_101.map.clear();
                        break;
                    
                    default:
                        System.out.println("Please just pick the right choices");
                        break;

                }

            }
        }




    }
    
}
