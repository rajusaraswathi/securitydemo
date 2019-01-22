package com.security.demosecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fan.jin on 2016-10-15.
 */


public class User implements UserDetails {


    //private EmployeeId employeeId;

    private String username;

     private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private boolean enabled=true;

    private String role;

    private Timestamp lastPasswordResetDate;
    private String employeeProfile;

    private List<Authority> subRolesList=new ArrayList<>();

   /* public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeId employeeId) {
        this.employeeId = employeeId;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        Authority authority=new Authority();
        authority.setSubRole(role);
        this.subRolesList.add(authority);
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSubRolesList(List<Authority> subRolesList) {
        this.subRolesList.addAll(subRolesList);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.subRolesList;
    }

    public List<String> loadAllRoles(){
       return this.getAuthorities().stream().map(x->((GrantedAuthority) x).
               getAuthority()).collect(Collectors.toList());
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getEmployeeProfile() {
        return employeeProfile;
    }

    public void setEmployeeProfile(String employeeProfile) {
        this.employeeProfile = employeeProfile;
    }
}
