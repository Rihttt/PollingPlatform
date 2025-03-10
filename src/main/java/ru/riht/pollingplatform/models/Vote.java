package ru.riht.pollingplatform.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;

    private LocalDateTime votedAt = LocalDateTime.now();

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long id) {
        this.voteId = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {this.user = user;}

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public LocalDateTime getVotedAt() {
        return votedAt;
    }

    public void setVotedAt(LocalDateTime votedAt) {
        this.votedAt = votedAt;
    }
}
