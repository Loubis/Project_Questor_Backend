package de.questor.model;

import javax.persistence.*;

@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String setting;
    private String story;
    private Integer rating;
    private float duration;
    private String author;
    @OneToOne(cascade = CascadeType.ALL)
    private QuestMarker startPosition;

    public void setId(int id) {
        this.id = id;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStartPosition(QuestMarker startPosition) {
        this.startPosition = startPosition;
    }

    public Integer getId() {
        return id;
    }

    public String getSetting() {
        return setting;
    }

    public String getStory() {
        return story;
    }

    public Integer getRating() {
        return rating;
    }

    public float getDuration() {
        return duration;
    }

    public String getAuthor() {
        return author;
    }

    public QuestMarker getStartPosition() {
        return startPosition;
    }
}
