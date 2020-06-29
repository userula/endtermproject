package repositories.interfaces;

import domain.User;
import domain.UserLoginData;

public interface IUserRepository extends IEntityRepository<User> {
    User getUserByID(int id);

    User getUserByUsername(String username);

    User findUserByLogin(UserLoginData data);
}
