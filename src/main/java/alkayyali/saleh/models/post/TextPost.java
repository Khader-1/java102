package alkayyali.saleh.models.post;


import alkayyali.saleh.models.User;

public class TextPost extends Post {

    public TextPost(String text, User creator, String feeling, String date, String time) {
        super(text, creator, feeling, date, time);
    }

    @Override
    public String toString() {
        return "TextPost: \n" + super.toString() + "}";
    }
}
