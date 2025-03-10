package ru.riht.pollingplatform.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "polls")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pollId;

    private String title;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    private List<Option> options = new ArrayList<>();

    public Long getPoll_id() {
        return pollId;
    }

    public void setPoll_id(Long id) {
        this.pollId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreator() {return creator;}

    public void setCreator(User creator) {this.creator = creator;}

    public List<Option> getOptions() {return options;}

    public void setOptions(List<Option> options) {this.options = options;}
}
