package web.service;

import web.models.User;

import java.util.List;

public interface IUserService {
    User getUserById(int id);
    List<User> getAllUsers();
    void removeUserById(long id);
    void saveUser(User user);
    void updateUser(User user);
}
