package web.service;

import web.dao.UserDAO;
import web.models.User;

import java.util.List;

public class UserService extends UserDAO {
    @Override
    public User getUserById(int id) {
        return super.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return super.getAllUsers();
    }

    @Override
    public void removeUserById(long id) {
        super.removeUserById(id);
    }

    @Override
    public void saveUser(User user) {
        super.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        super.updateUser(user);
    }
}
