/**
 * A class as the base class representing the credential of the user
 * @author Jiaxing Rong
 */

public class User {
    /**
     * The username of the user
     */
    protected String userName;
    /**
     * The password of the user
     */
    protected String password;

    /**
     * Constructor initializing user's username and password with corresponding parameters
     * @param userName username of the user
     * @param password password of the user
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * setter function to set the username to its parameter
     * @param userName username of the user
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * setter function to set the password to its parameter
     * @param password password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter function to get the username of the user
     * @return A String representing the username of the user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * getter function to get the password of the user
     * @return A String representing the password of the user
     */
    public String getPassword() {
        return password;
    }
}
