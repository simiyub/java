package topskills.tech.springspringboot3kenkousen.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import topskills.tech.springspringboot3kenkousen.entities.Greeting;

public class HelloRestController {

    @GetMapping("/rest")//Spring uses a handlermapping to connect URLs to claases and methds
    public Greeting greet(@RequestParam(required = false, defaultValue = "World") String name){
        return new Greeting(String.format("Hello, %s!", name));
    }
}