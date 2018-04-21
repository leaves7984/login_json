package com.example.easynotes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @Transient
    private String password;

    @Column(name = "username")
    private String username;


//    @ManyToMany
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private Set<Role> roles = new HashSet<>();
//
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_calendar", joinColumns = @JoinColumn(name = "calendar_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Calendar> calendar = new HashSet<>();
//    @OneToOne
//    private Calendar calendar = new Calendar();

    public User() {
    }

    public User(String email, @Length(min = 5, message = "*Your password must have at least 5 characters") String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
    public User(long id) {

        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Calendar> getCalendar() {
        return calendar;
    }

    public void setCalendar(Set<Calendar> calendar) {
        this.calendar = calendar;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", calendar=" + calendar +
                '}';
    }
}