package alkayyali.saleh.models.post;


import alkayyali.saleh.models.User;

public class PhotoPost extends Post {

    final private String[] photos;

    public PhotoPost(String text, User creator, String feeling, String date, String time, String[] photos) {
        super(text, creator, feeling, date, time);
        this.photos = photos;
    }

    public String[] getPhotos() {
        return photos;
    }

    @Override
    public String toString() {
        return "PhotoPost: \n" + super.toString() + "photos: \n" + photoString() + "\n" + "}";
    }

    private String photoString() {
        String photos = "";
        for (final String photo : this.photos)
            photos += photo + "\n";
        return photos;
    }

}
