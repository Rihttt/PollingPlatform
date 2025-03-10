package ru.riht.pollingplatform.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Option {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long optionId;
    private String text;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL)
    private List<Vote> votes = new ArrayList<>();

    public Option() {}

    public Option(String text, Poll poll) {}

    public Long getOption_id() {return optionId;}

    public void setOption_id(Long id) {this.optionId = id;}

    public String getText() {return text;}

    public void setText(String text) {this.text = text;}

    public Poll getPoll() {return poll;}

    public void setPoll(Poll poll) {this.poll = poll;}

    public List<Vote> getVotes() {return votes;}

    public void setVotes(List<Vote> votes) {this.votes = votes;}
}
