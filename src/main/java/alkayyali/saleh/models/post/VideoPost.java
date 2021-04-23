package alkayyali.saleh.models.post;

import alkayyali.saleh.models.User;

public class VideoPost extends Post {

    final private String video;

    public VideoPost(String text, User creator, String feeling, String date, String time, String video) {
        super(text, creator, feeling, date, time);
        this.video = video;
    }

    public String getvideo() {
        return video;
    }

    @Override
    public String toString() {
        return "VideoPost: \n" + super.toString() + 
        "video: " + video +  "\n" +
        "}";
    }

}
