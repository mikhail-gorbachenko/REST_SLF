package hello;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/greeting", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private Map<String, User> users;

    @GetMapping(path = "/hrest")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @PostMapping(path = "/hrest")
    public Greeting post() {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, "post"));
    }

    @PutMapping(path = "/hrest")
    public Greeting put() {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, "put"));
    }

    @DeleteMapping(path = "/hrest")
    public Greeting delete() {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, "delete"));
    }


    @GetMapping(path = "/users")
    public String getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "limit", defaultValue = "10") int limit,
                           @RequestParam(value = "Hug-A-Duck", required = false) boolean hug) {

        StringBuilder returnValue = new StringBuilder("Page " + page + " Limit " + limit + " Hug a Duck " + hug + "\n");

        for (int i = 0; i < limit; i++) {
            returnValue.append("User id ").append(i).append("\n");
        }

        return returnValue.toString();
    }

    @GetMapping(path = "/response")
    public ResponseEntity getResponse() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/response/users/{userID}")
    public ResponseEntity<User> getUserWithResponse(@PathVariable String userID) {
        User user = new User();
        user.setId(userID);
        user.setEmail("sabaka@gav.rr");
        user.setFirstName("Twilight");
        user.setLastName("Sparkle");
        return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
    }

   /* @GetMapping(path = "/users/{userID}")
    public String getUser(@PathVariable String userID) {
        return "Call user info with ID = " + userID;
    } */

    @GetMapping(path = "/users/{userID}")
    public ResponseEntity<User> getUser(@PathVariable String userID) {
        if(users.containsKey(userID)) {
            return new ResponseEntity<>(users.get(userID), HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/users", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDetailsRequestModel userRequest) {
        User user = new User();
        user.setId(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());

        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        if(users==null) users = new HashMap<>();
        users.put(userId, user);

        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @PutMapping(path = "/users/{userID}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> updateUser(@PathVariable String userID, @Valid @RequestBody UpdateUserRequestModel userRequest) {

        User storedUser = users.get(userID);
        if (!userRequest.getFirstName().equals("null"))
            storedUser.setFirstName(userRequest.getFirstName());
        if (!userRequest.getLastName().equals("null"))
            storedUser.setLastName(userRequest.getLastName());
        if (!userRequest.getEmail().equals("null"))
            storedUser.setEmail(userRequest.getEmail());
        if (!userRequest.getPassword().equals("null"))
            storedUser.setPassword(userRequest.getPassword());

        users.put(userID, storedUser);

        return new ResponseEntity<User>(storedUser, HttpStatus.OK);
    }

}
