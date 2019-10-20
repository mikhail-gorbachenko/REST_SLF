package hello;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IdGenerator {
    public String GenerateUserID(){
        return UUID.randomUUID().toString();
    }
}
