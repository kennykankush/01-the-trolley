//Core Logic & Input

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {

    Map<String, Integer> map = new HashMap<>();
    Scanner scanner_item = new Scanner(System.in);
    Scanner scanner_qty = new Scanner(System.in);


        public void viewList(){
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println("Item : " + entry.getKey() + "\nQuantity : " + entry.getValue());
            }
        }


        public void addItem(){

            System.out.println("Item?");

            String item = scanner_item.nextLine().trim();

            System.out.println("Qty?");
            Integer qty = scanner_qty.nextInt();

            map.put(item,qty);

        }

        public void deleteItem(){

            System.out.println("Which item to delete?");

            String item = scanner_item.nextLine().trim();

            map.remove(item);

        }

        public void saveList(String filePath, Map<String, Integer> map) throws IOException {

            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Map.Entry<String, Integer> entry : map.entrySet()){
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }

            bw.close();
            fw.close();

            
        }

        public void loadList(String filePath) throws IOException{


            System.out.println("Fetching list.");
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null){
                String[] words = line.split(",");
                
                map.put(words[0],Integer.parseInt(words[1]));

            }

            br.close();
            fr.close();


        }


}