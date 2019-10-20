package hello;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(path="/hrest")
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


    @GetMapping(path="/users/{userID}")
    public String getUser(@PathVariable String userID){
        return "Call user info with ID = " + userID;
    }

    @GetMapping(path="/users")
    public String getUsers(@RequestParam(value = "page") int page,
                                 @RequestParam(value = "limit") int limit){

        StringBuilder returnValue = new StringBuilder("Page " + page + " Limit " + limit + "\n");

        for (int i = 0; i < limit; i++) {
            returnValue.append("User id ").append(i).append("\n");
        }

        return returnValue.toString();
    }


}
