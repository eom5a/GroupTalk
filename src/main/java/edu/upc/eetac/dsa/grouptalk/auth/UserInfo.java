package edu.upc.eetac.dsa.grouptalk.auth;

import edu.upc.eetac.dsa.grouptalk.entity.Role;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enric on 28/03/2016.
 */
public class UserInfo implements Principal {
    private String name;
    private List<Role> roles = new ArrayList();

    public UserInfo() {
    }

    public UserInfo(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
