package Bank.service;

import Bank.module.User;

import java.util.List;

public interface AdminService {


    void acceptOrDecline_User(User user);

    void handleUser(User user);

    List<User> viewUserDetails();
}
