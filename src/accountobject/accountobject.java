package accountobject;

/**
 *
 * @author hoangdao
 */
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

//Account object to store information
public class accountobject {
    public String appwebsitetitle;
    public String password;
    public String userhashcode;
    public String urloptional;
    public String lastupdate;
    public accountobject(String title, String pass, String usercode){
        this.appwebsitetitle=title;
        this.password=pass;
        this.userhashcode=usercode;
        this.urloptional=null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        this.lastupdate=dtf.format(now);
    }
    public accountobject(String title, String pass, String usercode,String url){
        this.appwebsitetitle=title;
        this.password=pass;
        this.userhashcode=usercode;
        this.urloptional=url;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        this.lastupdate=dtf.format(now);
    }
    public void display(){
        System.out.println(this.appwebsitetitle);
        System.out.println(this.password);
        if (this.urloptional!=null) System.out.println(this.urloptional);
        System.out.println(this.lastupdate);
    }
}
