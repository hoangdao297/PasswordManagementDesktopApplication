package accountobject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author hoangdao
 */
class Node{
    public Node right;
    public Node left;
    public accountobject data;
    public Node(){
        this.right=null;this.left=null;
    }
    public Node(accountobject data){
        this.data=data;
        this.right=null;this.left=null;
    }
    public void display(){
        this.data.display();
    }
}
public class linkedlistaccobj {
    private Node head;
    public linkedlistaccobj(){
        this.head=null;
    }
    public void list(){
        Node iter=this.head;
        while(iter!=null){
            iter.display();
            iter=iter.right;
        }
        iter=null;
    }
    public void insert(accountobject element){
        Node newel=new Node(element);
        if (head==null){
            this.head.right=newel; newel.left=this.head;
        }
        else{
            Node temp=this.head;
            while (temp.right!=null) temp=temp.right;
            temp.right=newel; newel.left=temp;
            temp=null;
        }
        System.out.println("Your information has been added");
    }
    public Node search(String appwebtitle){
        Node temp=this.head;
        while (!temp.data.appwebsitetitle.equals(appwebtitle) && temp!=null) temp=temp.right;
        return temp;
    }
    public void modify(String appwebtitle, String modifiedpass){
        Node modinfo=this.search(appwebtitle);
        modinfo.data.password=modifiedpass;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        modinfo.data.lastupdate=dtf.format(now);
        System.out.println("Information has been modified");
    }
    public void delete(String appwebtitle){
        Node delnode=this.search(appwebtitle);
        delnode.right.left=delnode.left;
        delnode.left.right=delnode.right;
        delnode.left=null;delnode.right=null;
        delnode=null;
        System.out.println("Information has been deleted");
    }
}
