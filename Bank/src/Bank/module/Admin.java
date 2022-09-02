package Bank.module;

public class Admin {
    private static String username;
    private static String password;

    public  static String getUsername(){
        return username;
    }
    public static void setUsername(String user){
        username = user;
    }

    public static String getPassword(){
        return password;
    }
    public static void setPassword(String pw){
        password= pw;
    }



}
