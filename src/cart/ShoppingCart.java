package cart;
//Core Logic & Input

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;

    public class ShoppingCart {

        List<String> cart = new ArrayList<>();                
        Scanner scanner = new Scanner(System.in);

        public static String getPcName(){
            String pcName = "user";
            try {
                pcName = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            return pcName;

        }

        public void menu(){         
            System.out.println("\n \n");                         
            System.out.println("Dear " + getPcName() + ",\nWelcome to The Trolley\n=============\n");
            System.out.println("View the List : type list");
            System.out.println("Add an entry : type add (items)");
            System.out.println("Remove an Entry : type delete (items)");
            System.out.println(" ");

        } 

        public String user_input(){     

            String input = scanner.nextLine();
            return input.toLowerCase();
            
        }

        public void processor(){

            String input = "";

            while (!input.equals("quit")) {
                input = user_input();

                if (!input.equals("list") || !input.equals("add") || !input.equals("delete")){
                    System.out.println("\nI have no idea what you're saying, its either \nadd, delete or list");
                }
                
                if (input.equals("list")){
                    System.out.println("\nIniatiating...\nThe Cart\n======\n");
                    
                    if (cart.size() > 0 ) {
                        for (String items: cart){
                            System.out.println(items);
                        }
    
                    } else {
                        System.out.println("\nNo cart brotha");
                    }
                    

                }

                if (input.startsWith("add")){
                    System.out.println("\nAdding in progress");
                    String[] inputProcessing = input.split(" ");

                    if (inputProcessing.length >= 3) {
                        System.out.println("\nSuccessfully Added");
                        for (int i = 1; i < inputProcessing.length; i++){
                            cart.add(inputProcessing[i]);
                        }

                    } else if (inputProcessing.length == 2 ){
                        System.out.println("\nSuccessfully Added");
                        String itemToAdd = inputProcessing[1];
                        cart.add(itemToAdd);
                    } else if (inputProcessing.length == 1){
                        System.out.println("You forgotten your fruits.");
                    }

                }

                if (input.startsWith("delete")){
                    System.out.println("\nDeleting in progress");
                    String[] itemsToDeleteArray = input.split(" ");
                    String itemsToDelete = itemsToDeleteArray[1];
                    System.out.println(itemsToDelete);


                    for (int i = 0; i < cart.size(); i++){
                        if (cart.get(i).equals(itemsToDelete)){
                            cart.remove(i);
                            break;
                        }
                    }  
                    
                } 
                

            } System.out.println("\nExit"); 


        
        }
}