package strengthcheck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author hoangdao
 */
public class commonphrasescheck {
        private final String password;
    private final boolean presence;
    public commonphrasescheck(String inputpassword){
        this.password=inputpassword;
        this.presence=this.importlisttocheck();
    }
    
    private boolean importlisttocheck(){
        try {
            try (Scanner reader = new Scanner(new File("rockyou.txt"))) {
                while (reader.hasNextLine()) {
                    if (this.password.equals(reader.nextLine())){
                        reader.close(); return true;
                    }
                }
                reader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is a missing file in application folder (rockyou.txt)");
            System.exit(0);
        }
        return false;
    }
    
    public boolean commonphrasescheckresult(){
        return this.presence;
    }
}
