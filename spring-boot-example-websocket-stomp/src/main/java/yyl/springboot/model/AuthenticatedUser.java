package yyl.springboot.model;

import java.security.Principal;

public class AuthenticatedUser implements Principal {

    private String name;

    public AuthenticatedUser(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Authenticationed [name=" + name + "]";
    }
}
