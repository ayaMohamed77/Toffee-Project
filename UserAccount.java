import java.util.regex.Pattern;

/** This class represents User Account Info
 * @author Aya Mohamed Abdelrahman
 *  Karin Khier Abdallah
 *  Alaa Elbasyonee Abdelaal
 * @version 1.0
 * @since 8/5/2023
 */

public class UserAccount {
    private String username;
    private String password;
    private String email;
    private boolean isLoggedIn;

    /**
     * setup User info
     * @param username username
     * @param password userpass
     * @param email  usermail
     */

    public UserAccount(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isLoggedIn = false;
    }

    /**
     * set default info
     */
    public UserAccount() {
        this.username = "";
        this.password = "";
        this.email = "55@gmail.com";
        this.isLoggedIn = false;
    }

    /**
     * login function take info from user to save it
     * @param username username
     * @param password userpass
     */
    public void login(String username, String password) {
        this.username = username;
        this.password = password;
        this.email=username+"55@gmail.com";
        System.out.print("Welcome " + username + " And Your password is ");
        for (int i =0 ; i<password.length();i++){
            System.out.print("*");}
        System.out.println("");
    }

    /**
     * Register function take info from user to save it
     * @param username username
     * @param Password userpass
     * @param Email usermail
     */
    public void register(String username, String Password, String Email) {

            this.username = username;
            this.password = Password;
            this.email = Email;
            System.out.println("Your registration is done successfully");
    }

    /**
     * regex function check Mail validation
     * @param Email mail to check regex
     * @return true if mail Matches the criteria and
     * false otherwise
     */
    public boolean RegexMail (String Email){
        String StandardMail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        boolean M = Pattern.matches(StandardMail,Email);
        return M;
    }

    /**
     * regex function check Password validation
     * @param Password pass to check regex
     * @return true if Password Matches the criteria and
     * false otherwise
     */
    public boolean RegexPass (String Password){
        String StandardPass ="[A-z]+[0-9]+";
        boolean P = Pattern.matches(StandardPass,Password);
        return P;
    }

    /**
     * print function to show user info
     */
    public void PrintInfo(){
        System.out.println("UserName :- "+username +" Email : "+email);

    }
}

