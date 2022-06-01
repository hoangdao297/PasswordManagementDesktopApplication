package user;

/**
 *
 * @author hoangdao
 */
//import accountobject.*;
//user's object to store in database
public class user {
    public String username;
    public String password;
    public String userhashcode;
    //public linkedlistaccobj listofwebsitepass;
    public user(String username, String password){
        this.username=username;
        this.password=password;
        this.userhashcode=username+password;
    }
    /*public user(String username, String password, accountobject Info){
        this.username=username;
        this.password=password;
        this.listofwebsitepass.insert(Info);
    }*/
}
