package com.mayowasogbein.android.walmart;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static List<User> users = new ArrayList<>();

    public static void loadUsers() {
        users.add(new User("bill@gmail.com", "clinton"));
        users.add(new User("barack@gmail.com", "obama"));
        users.add(new User("george@gmail.com", "bush"));
        users.add(new User("bola@gmail.com", "tinubu"));
        users.add(new User("nelson@gmail.com", "mandela"));
    }

    public static boolean addUser(User user) {
        Boolean success = users.add(user);
        if(success) return true;
        return false;
    }
}
