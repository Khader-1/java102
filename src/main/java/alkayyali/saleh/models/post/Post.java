package alkayyali.saleh.models.post;

import java.io.Serializable;

import alkayyali.saleh.models.User;

public abstract class Post implements Serializable{
    final private String text;
    final private User creator;
    final private String feeling;
    final private String date;
    final private String time;

    public Post(String text, User creator, String feeling, String date, String time) {
        this.text = text;
        this.creator = creator;
        this.feeling = feeling;
        this.date = date;
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public User getCreator() {
        return creator;
    }

    public String getFeeling() {
        return feeling;
    }

    public String getDate() {
        return date;
    }

    public String getString() {
        return time;
    }

    @Override
    public String toString() {
        return "{\n" + 
        "text: " + text +  "\n" + 
        "creator: " + creator.getEmail() +  "\n" + 
        "feeling: " + feeling +  "\n" + 
        "date: " + date +  "\n" + 
        "time: " + time +  "\n";
    }
}
