
package beans;

public class AppUser implements java.io.Serializable{

    private short  userId;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String department; // Accounting, Sales
    private short  status;

    /** Creates new AppUser */
    public AppUser() {
    }

    public short getUserId() {
        return userId;
    }
    public void setUserId(short userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public short getStatus() {
        return status;
    }
    public void setStatus(short status) {
        this.status = status;
    }

}