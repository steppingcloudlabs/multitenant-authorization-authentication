package com.sclabs.multitenantauthorization.Model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {
    @Id
    Object id;
    private String email;
    private String password;
    private String companyname;
    private String userid;
    private String passwordupdatedAt;
    private String userType;

    public Users(Object id, String email, String password, String companyname, String userid,
            String passwordupdatedAt, String userType) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.companyname = companyname;
        this.userid = userid;
        this.passwordupdatedAt = passwordupdatedAt;
        this.userType = userType;
    }

    public Users() {
    }

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasswordupdatedAt() {
        return passwordupdatedAt;
    }

    public void setPasswordupdatedAt(String passwordupdatedAt) {
        this.passwordupdatedAt = passwordupdatedAt;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        try {
            return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter()
                    .writeValueAsString(this);
        } catch (final com.fasterxml.jackson.core.JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}