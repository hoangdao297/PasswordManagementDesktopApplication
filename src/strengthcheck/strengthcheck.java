package strengthcheck;


public class strengthcheck {

    /**
     *
     * @param pass
     * @return 
     */
    public static int main(String pass){
        varietycheck vcheck=new varietycheck(pass);
        commonphrasescheck cmpcheck=new commonphrasescheck(pass);
        lengthcheck lcheck=new lengthcheck(pass);
        int rs=InformingUsers(vcheck.varietycheckresult(),lcheck.lengthcheckresult(),cmpcheck.commonphrasescheckresult());
        return rs;
    }
    public static int InformingUsers(int vcheck, int lcheck, boolean cmpcheck){
        if (!cmpcheck){
            if (vcheck>=3 && lcheck==3){
                //System.out.println("Strong password");
                return 3;
            }
            else if (lcheck<=2){
                //System.out.println("Weak password, please change for your account's safety");
                return 1;
            }
            else{
                //System.out.println("Medium password");
                return 2;
            }
        }
        else{
            //System.out.println("Weak password, please change for your account's safety");
            return 1;
        }
    }
}
