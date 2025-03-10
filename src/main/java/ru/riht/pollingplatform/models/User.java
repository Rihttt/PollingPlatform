package ru.riht.pollingplatform.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String role = "ROLE_USER";

    @OneToMany(mappedBy = "creator",cascade = CascadeType.ALL)
    private List<Poll> polls = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Vote> votes = new ArrayList<>();

    public User() {}

    public void setUserId(Long id) {
        this.userId = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
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
        this.role = role;
    }

    public List<Poll> getPolls() {return polls;}

    public void setPolls(List<Poll> polls) {this.polls = polls;}

    public List<Vote> getVotes() {return votes;}

    public void setVotes(List<Vote> votes) {this.votes = votes;}
}
