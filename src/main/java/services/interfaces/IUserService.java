package services.interfaces;


import domain.User;

public interface IUserService {

    User getUserByID(int id);

    void addUser(User u);
}
