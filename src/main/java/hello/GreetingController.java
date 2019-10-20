package hello;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/greeting", produces = {"application/json" , "application/xml"})
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(path="/hrest" )
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @PostMapping(path="/hrest")
    public Greeting post(){
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, "post"));
    }

    @PutMapping(path="/hrest")
    public Greeting put(){
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, "put"));
    }

    @DeleteMapping(path="/hrest")
    public Greeting delete(){
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, "delete"));
    }


    @GetMapping(path="/users/{userID}" )
    public String getUser(@PathVariable String userID){
        return "Call user info with ID = " + userID;
    }

    @GetMapping(path="/users")
    public String getUsers(@RequestParam(value = "page" , defaultValue = "0") int page,
                                 @RequestParam(value = "limit", defaultValue = "10") int limit,
                           @RequestParam(value = "Hug-A-Duck", required = false) boolean hug){

        StringBuilder returnValue = new StringBuilder("Page " + page + " Limit " + limit  + "Hug a Duck " + hug + "\n");

        for (int i = 0; i < limit; i++) {
            returnValue.append("User id ").append(i).append("\n");
        }

        return returnValue.toString();
    }


}
