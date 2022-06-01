package generatingpassword;

/**
 *
 * @author hoangdao
 */
import java.util.HashMap;
//class to map some letter with special characters
public class HashMapLeetCode {
    private HashMap<Character,String> leetcode=new HashMap<Character,String>();
    public HashMapLeetCode(){
        this.makingleetcodemap();
    }
    private void makingleetcodemap(){
        this.leetcode.put('a',"@");
        this.leetcode.put('e',"3");
        this.leetcode.put('s',"$");
        this.leetcode.put('o',"0");
        this.leetcode.put('i',"!");
    }
    public HashMap<Character,String> returnleetcodemap(){
        return this.leetcode;
    }
}
