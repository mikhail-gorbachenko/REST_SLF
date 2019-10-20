package hello;

import jdk.internal.net.http.common.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServerImpl implements UserService {

    private Map<String, User> users;
    IdGenerator generator;

    public UserServerImpl(){}

    @Autowired
    public UserServerImpl(IdGenerator generator){
        this.generator = generator;
    }


    @Override
    public User createUser(UserDetailsRequestModel userRequest) {
        User user = new User();
        user.setId(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());

        String userId = generator.GenerateUserID();
        user.setId(userId);
        if(users==null) users = new HashMap<>();
        users.put(userId, user);

        return user;
    }
}
