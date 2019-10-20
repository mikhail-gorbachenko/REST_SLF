package hello;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @PostMapping
    public String post(){
        return "Post";
    }

    @PutMapping
    public String put(){
        return "put";
    }

    @DeleteMapping
    public String delete(){
        return "Delete";
    }



}
