package ua.hillel.stolitnii.glovo.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class SecuredController {

    @GetMapping("/example")
    public String securedExample() {
        return "This is a secured resource!";
    }
}
