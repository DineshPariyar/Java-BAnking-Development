package Bank.service;

import Bank.module.User;

public interface UserService {

        User login(String e, String p);
        void deposit(int id);
        void withdraw(int id);
        void changePin(int id);
}
