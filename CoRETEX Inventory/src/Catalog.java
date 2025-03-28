import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Catalog {
    private ArrayList<Item> items;
    private HashMap<String, Integer> quantities;

    public Catalog(){
        items = new ArrayList<>();
        quantities = new HashMap<>();
    }

    /**
     * gets the number of items in the catalog
     * @return - list of the items in the catalog
     */
    public int numItems(){
        return items.size();
    }

    public int getQuantity(String key){
        return quantities.get(key);
    }

    /**
     * adds an item to the catalog
     * @param i - item to be added
     */
    public void addItem(Item i, int quant){
        if(!items.contains(i)){
            items.add(i);
            quantities.put(i.getName(), quant);
        }
    }

    /**
     * fills the catalog using the textfile "Inventory.txt"
     * @param fileName - "Inventory.txt"
     */
    public void fill(String fileName){
        String name = "";
        try {
            File file = new File(fileName);
            System.out.println(file.getAbsolutePath());
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                name = line.substring(0, line.indexOf(":"));
                line = line.substring(line.indexOf(":") + 1);
                items.add(new Item(name.toLowerCase(), line.substring(0, line.indexOf(":"))));
                quantities.put(name.toLowerCase(), Integer.parseInt(line.substring(line.indexOf(":")+1)));
            }
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Finds the number of items that match key
     * @param key - tag to be searched for
     * @return - list of all items that match key
     */
    public ArrayList<Item> matchesTag(String key){
        key = key.toLowerCase();
        ArrayList<Item> match = new ArrayList<>();
        for (Item item : items) {
            if (item.hasKey(key)) {
                match.add(item);
            }
        }
        return match;
    }

    /**
     * checks if the catalog contains an Item with name
     * @param name - name of the item to be searched for
     * @return
     */
    public boolean has(String name){
        for(int i = 0; i < numItems(); i++){
            if(items.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }

}
