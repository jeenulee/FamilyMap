package Result;

public class LoginResult {


    private String username;
    private String personID;
    private boolean success;

    public LoginResult(String username, String personID, boolean success) {
        this.username = username;
        this.personID = personID;
        this.success = success;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
