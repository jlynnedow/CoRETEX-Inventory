import java.util.ArrayList;
import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        Catalog c = new Catalog();
        Scanner sc = new Scanner(System.in);
        String input = "";
        c.fill("Inventory.txt");
        do{
            try {
                System.out.print("Would you like to search by item or tag? ");
                input = sc.nextLine();
                if(!input.equalsIgnoreCase("item") && !input.equalsIgnoreCase("tag")){
                    throw new IllegalArgumentException();
                }
            }catch (IllegalArgumentException e){
                System.out.println("Please enter the word \"item\" or the word \"tag\"");
            }
        }while(!input.equalsIgnoreCase("item") && !input.equalsIgnoreCase("tag"));
        if(input.equalsIgnoreCase("item")){
            System.out.print("Enter the name of the item: ");
            input = sc.nextLine();
            if(c.has(input.toLowerCase())) {
                System.out.print("Currently in the CoRETEX!");
            }else{
                System.out.print("Not currently in the CoRETEX");
            }
        }else{
            System.out.println("Already existing tags:");
            for(String tag : Item.getTags()){
                System.out.println(tag);
            }
            System.out.print("Enter the tag you want to search for: ");
            input = sc.next();
            ArrayList<Item> matches = c.matchesTag(input.toLowerCase());
            System.out.println("Matches found: ");
            for (Item match : matches) {
                System.out.println(match.getName() + " | " + c.getQuantity(match.getName()));
            }
        }
    }
}
