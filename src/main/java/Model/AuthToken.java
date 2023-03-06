package Model;

import java.util.Objects;

public class AuthToken {

    private String authtoken;
    private String username;

    /**
     * This is a constructor for the AuthToken Model class
     * @param authtoken
     * @param username
     */

    public AuthToken(String authtoken, String username){

        this.authtoken = authtoken;
        this.username = username;

    }

    public String getAuthToken(){return authtoken;}

    public void setAuthToken(String authtoken){this.authtoken = authtoken; }

    public String getUserName(){return username;}

    public void setUserName(String username){this.username = username;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthToken authToken = (AuthToken) o;
        return Objects.equals(authToken, authToken.authtoken) && Objects.equals(username, authToken.username);
    }
}
