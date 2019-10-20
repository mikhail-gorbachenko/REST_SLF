package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServerImpl implements UserService {

    private Map<String, User> users;

    @Override
    public User createUser(UserDetailsRequestModel userRequest) {
        User user = new User();
        user.setId(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());

        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        if(users==null) users = new HashMap<>();
        users.put(userId, user);

        return user;
    }
}
