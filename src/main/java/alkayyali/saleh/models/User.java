package alkayyali.saleh.models;

import java.io.Serializable;

public class User implements Serializable {
    private final String email;
    private final String password;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return user.email.equals(this.email);
    }
}
