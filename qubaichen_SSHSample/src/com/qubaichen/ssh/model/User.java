package com.qubaichen.ssh.model;

public class User extends
org.springframework.orm.hibernate3.support.HibernateDaoSupport
implements java.io.Serializable {

// Fields
private Integer id;
private String username;
private String password;

// Constructors
/** default constructor */
public User() {
}

/** minimal constructor */
public User(String username) {
this.username = username;
}

/** full constructor */
public User(String username, String password) {
this.username = username;
this.password = password;
}

// Property accessors
public Integer getId() {
return this.id;
}

public void setId(Integer id) {
this.id = id;
}

public String getUsername() {
return this.username;
}

public void setUsername(String user) {
this.username = user;
}

public String getPassword() {
return this.password;
}

public void setPassword(String password) {
this.password = password;
}

}

