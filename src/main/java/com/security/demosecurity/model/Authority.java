package com.security.demosecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by fan.jin on 2016-11-03.
 */


public class Authority implements GrantedAuthority {


    Long id;


    String subRole;

    @Override
    public String getAuthority() {
        return subRole;
    }

    public void setSubRole(String name) {

        this.subRole = "ROLE_"+name;
    }

    @JsonIgnore
    public String getName() {
        return subRole;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
