package team2.taskmanager.services;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoService {

    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello World";
    }

    @PostMapping("/hello")
        public String answer(@RequestBody String message){
            return "hola "+message + "!";
    }
}