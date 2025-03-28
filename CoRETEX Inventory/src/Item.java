import java.util.ArrayList;
import java.util.HashMap;
public class Item {
    private static ArrayList<String> tagList = new ArrayList<>();
    private String tag;
    private String name;

    public Item(String name, String tag){
        this.name = name;
        this.tag = tag;
        if(!tagList.contains(tag)){
            tagList.add(tag);
        }
    }

    /**
     * checks if the calling Item matches tag
     * @param tag - the tag to be checked for
     * @return - true if the tags match, false otherwise
     */
    public boolean hasKey(String tag){
        return (tag.equals(this.tag));
    }

    /**
     * accesses the name of the calling Item
     * @return - name of the calling Item
     */
    public String getName(){
        return name;
    }

    /**
     * returns a list of existing tags
     * @return - list of unique tags
     */
    public static ArrayList<String> getTags(){
        return tagList;
    }


}
