package thalysmartins.filmesbancoh2.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Thalys Figueira Martins
 * @Since 24/04/2020
 * @version 1.0
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloWorldController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
}
