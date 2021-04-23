package alkayyali.saleh.repo;

import java.util.ArrayList;
import java.util.List;


import alkayyali.saleh.models.User;

public class UsersRepository extends Repository<List<User>> {

    public UsersRepository() {
        super("/users.list");
    }

    public boolean login(User user) {
        for(final User current : loaded)
            if(current.equals(user))
                return current.getPassword().equals(user.getPassword());
        return false;
    }

    public boolean register(User user) {
        if(loaded.contains(user))
            return false;
        loaded.add(user);
        saveProgress();
        return true;
    }

    @Override
    protected List<User> defualt() {
        return new ArrayList<User>();
    }

}
