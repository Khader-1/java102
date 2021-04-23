package alkayyali.saleh.repo;

import java.util.ArrayList;
import java.util.List;

import alkayyali.saleh.models.User;
import alkayyali.saleh.models.post.Post;

public class PostsRepository extends Repository<List<Post>>{

    public PostsRepository() {
        super("/posts.list");
    }

    @Override
    protected List<Post> defualt() {
        return new ArrayList<Post>();
    }

    public void create(Post post) {
        loaded.add(post);
        saveProgress();
    }

    public List<Post> getAll() {
        return loaded;
    }

    public List<Post> getUserPosts(User user) {
        ArrayList<Post> matches = new ArrayList<>();
        for(final Post current : loaded)
            if(current.getCreator().equals(user))
                matches.add(current);
        return matches;
    }

}
