package hello;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(path="/rest")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @PostMapping
    public Greeting post(){
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, "post"));
    }

    @PutMapping
    public Greeting put(){
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, "put"));
    }

    @DeleteMapping
    public Greeting delete(){
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, "delete"));
    }



}
