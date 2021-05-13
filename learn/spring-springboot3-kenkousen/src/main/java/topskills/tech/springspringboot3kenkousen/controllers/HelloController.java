package topskills.tech.springspringboot3kenkousen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    //registers this method for GET requests to /hello, replacing the name with value provided
    public String sayHello(
            @RequestParam(value = "name", required = false,
                    defaultValue = "World") String name, Model model) {
        model.addAttribute("user", name);
        //model passes information from controller to view
        return "hello";
    }
}