package generatingpassword;
import java.util.Random;

//class to generate password
public class Generator {
    private String generatedstring;
    private int lengthofstring;
    public Generator(String pass, int len){ //constructor generate with user's phrase
        this.lengthofstring=len;
        this.generatedstring=this.generate(pass);
    }
    public Generator(int len){//constructor generate randomly
        this.lengthofstring=len;
        this.generatedstring=this.generate();
    }
    private String generate(String pass){
        if (pass.length()>this.lengthofstring) return null;
        String results;
        Random rand=new Random();
        StringBuilder togenerate=new StringBuilder();
        PasswordModifytoLeetcode hashpass=new PasswordModifytoLeetcode(pass);
        togenerate.append(hashpass.returnnewpass());
        for (int k=0;k<this.lengthofstring-pass.length();k++){
            int posfixrand=rand.nextInt(127-33)+33;
            togenerate.append((char)posfixrand);
        }
        results=togenerate.toString();
        return results;
    }
    private String generate(){
        String results;
        Random rand=new Random();
        StringBuilder togenerate=new StringBuilder();
        for (int j=0;j<this.lengthofstring;j++){
            int prefixrand=rand.nextInt(127-33)+33;
            togenerate.append((char)prefixrand);
        }
        results=togenerate.toString();
        return results;
    }
    public String returnPass(){
        return this.generatedstring;
    }
    public static void main(String[] args){
        Generator gen=new Generator(12);
        System.out.println(gen.returnPass());
    }
}


