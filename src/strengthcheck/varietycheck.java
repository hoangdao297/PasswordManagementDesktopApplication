package strengthcheck;
import java.util.ArrayList;
/**
 *
 * @author hoangdao
 */
public class varietycheck {
    private final String password;
    public varietycheck(String inputpassword){
        this.password=inputpassword;
    }
    
    public int varietycheckresult(){
        int level=0;
        ArrayList<Integer> standard=new ArrayList<>(4);
        //boolean[] standard= new boolean[4];
        for (int j=0;j<4;j++) standard.add(0);
        for (int i=0;i<this.password.length();i++){
            if (this.password.charAt(i)>=65 && this.password.charAt(i)<=90) standard.set(0,1);
            else if (this.password.charAt(i)>=97 && this.password.charAt(i)<=122) standard.set(1,1);
            else if (this.password.charAt(i)>=48 && this.password.charAt(i)<=57) standard.set(2,1);
            else standard.set(3,1);
        }
        for (int h=0;h<4;h++){
            if (standard.get(h)==1) level++;
        }
        return level;
    }
    /*public static void main(String[] args){
        varietycheck pass=new varietycheck("@Jack2972001");
        System.out.println(pass.varietycheckresult());
    }*/
}
