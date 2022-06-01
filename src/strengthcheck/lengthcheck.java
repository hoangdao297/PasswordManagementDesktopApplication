package strengthcheck;
/**
 *
 * @author hoangdao
 */
public class lengthcheck {
    private final int lengthofpassword;
    public lengthcheck(String inputpassword){
        this.lengthofpassword=inputpassword.length();
    }
    
    public int lengthcheckresult(){
        int level;
        if (this.lengthofpassword<4) level=1;
        else if (this.lengthofpassword>=4 && this.lengthofpassword<=7) level=2;
        else level=3;
        return level;
    }
}
