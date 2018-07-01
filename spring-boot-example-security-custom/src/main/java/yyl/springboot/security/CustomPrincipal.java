package yyl.springboot.security;

/**
 * 用户身份(用戶信息)
 */
public class CustomPrincipal {

    private String username;

    public CustomPrincipal(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
