package generatingpassword;

/**
 *
 * @author hoangdao
 */
import java.util.HashMap;

//class to modify password (replacing letters with special characters)
public class PasswordModifytoLeetcode {
    private String newpass;
    public PasswordModifytoLeetcode(String pass){
        this.newpass=modifypass(pass);
    }
    private String modifypass(String pass){
        HashMapLeetCode leetcodeobj=new HashMapLeetCode();
        HashMap<Character,String> leetcode=leetcodeobj.returnleetcodemap();
        for (Character i: leetcode.keySet()){
            String temp=pass.replaceAll(""+i, leetcode.get(i));
            pass=temp;
        }
        return pass;
    }
    public String returnnewpass(){
        return this.newpass;
    }
}
