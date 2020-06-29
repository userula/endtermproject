package services.interfaces;

import domain.AccessToken;
import domain.UserLoginData;
import domain.User;

public interface IAuthorizationService {
    AccessToken authenticateUser(UserLoginData data) throws Exception;

    User getUserByUsername(String issuer);
}
