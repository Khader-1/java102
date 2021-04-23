package alkayyali.saleh;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import alkayyali.saleh.models.User;
import alkayyali.saleh.models.post.PhotoPost;
import alkayyali.saleh.models.post.Post;
import alkayyali.saleh.models.post.TextPost;
import alkayyali.saleh.models.post.VideoPost;
import alkayyali.saleh.repo.PostsRepository;
import alkayyali.saleh.repo.UsersRepository;
import alkayyali.saleh.utils.TextPrinter;

public class App {
    public static final String BASE_PATH = System.getProperty("user.home") + "/Desktop";

    final private static UsersRepository users = new UsersRepository();
    final private static PostsRepository posts = new PostsRepository();
    final private static Scanner reader = new Scanner(System.in);
    final private static TextPrinter printer = new TextPrinter("/outputs.text");

    public static void main(String[] args) {
        final User auth = showSignInPrompt();
        while(true) {
            System.out.println("do you want to?");
            System.out.println("1- Add posts");
            System.out.println("2- Display posts");
            System.out.println("3- Print posts");
            System.out.println("4- Logout");
            System.out.print(">> ");
            final int choice = reader.nextInt();
            switch (choice) {
                case 1:
                    final Post post = showPostPrompt(auth);
                    posts.create(post);
                    continue;
                case 2:
                    System.out.println(formatedPosts(personalPostsOrAll(auth)));
                    continue;
                case 3:
                    printer.write(formatedPosts(personalPostsOrAll(auth)));
                    continue;
                case 4:
                    main(args);
                    return;
                default:
                    exit("invalid choice");
                }
        }
    }

    private static User showSignInPrompt() {
        System.out.println("do you want to?");
        System.out.println("1- Sign In");
        System.out.println("2- Sign Up");
        System.out.print(">> ");
        final int choice = reader.nextInt();
        switch (choice) {
        case 1:
            final User user = getUserData();
            if (users.login(user))
                return user;
            exit("invalid credintials");
        case 2:
            final User newUser = getUserData();
            if (users.register(newUser))
                return newUser;
            exit("user already exists!");
        default:
            exit("invalid option");
        }
        return null;

    }

    private static String readString(String label) {
        System.out.print(label + ": ");
        return reader.next();
    }

    private static User getUserData() {
        final String email = readString("email");
        final String password = readString("password");
        return new User(email, password);
    }

    private static void exit(String message) {
        System.err.println(message);
        System.exit(500);
    }

    private static Post showPostPrompt(User user) {
        System.out.println("do you want to create?");
        System.out.println("1- text post");
        System.out.println("2- photos");
        System.out.println("3- video");
        System.out.print(">> ");
        final int choice = reader.nextInt();
        if (choice > 3 || choice < 1)
            exit("invalid option");
        final String text = readString("text");
        final String feeling = readString("feeling");
        final String date = new Date().toString();
        final String time = "";
        switch (choice) {
        case 1:
            return new TextPost(text, user, feeling, date, time);
        case 2:
            System.out.print("how many photos do you have ");
            final int length = reader.nextInt();
            final String[] photos = new String[length];
            for (int i = 0; i < length; i++) {
                photos[i] = readString("photo " + i + " : ");
            }
            return new PhotoPost(text, user, feeling, date, time, photos);
        case 3:
            return new VideoPost(text, user, feeling, date, time, readString("video link: "));
        }
        return null;
    }

    private static String formatedPosts(List<Post> posts) {
        String formated = "";
        for (Post post : posts) {
            formated += post.toString() + "\n";
        }
        return formated;
    }

    private static List<Post> personalPostsOrAll(User user) {
        System.out.println("Do you want to see? ");
        System.out.println("1- all Posts ");
        System.out.println("2- yours only ");
        System.out.print(">> ");
        final int choice = reader.nextInt();
        switch (choice) {
        case 1:
            return posts.getAll();
        case 2:
            return posts.getUserPosts(user);
        default:
            exit("invalid choice");
            return null;
        }
    }
}
