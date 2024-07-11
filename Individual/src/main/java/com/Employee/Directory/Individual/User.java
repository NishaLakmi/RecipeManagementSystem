package com.Employee.Directory.Individual;

import jakarta.persistence.*;

@Entity
@Table(name = "UserRegistration")

public class User {
    @Id
    @Column
    @SequenceGenerator(name="User_id_sequence", sequenceName = "User_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_id_sequence")

    private Long id;
    @Column
    private String username;
    @Column
    private String email;
    @Column(name = "user_password")
    private String user_password;



    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.user_password = password;
    }

    public User(String username, String email, String password ) {
        this.username = username;
        this.email = email;
        this.user_password = password;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", user_password='" + user_password +
                '}';
    }
}

