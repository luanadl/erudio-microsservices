package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

//    @RequestMapping(method = RequestMethod.GET, path = "/hello-word")
//    public String helloWorld(){
//        return "Hello World";
//    }

    @GetMapping(path = "/hello-word")
    public String helloWorld(){
        return "Hello World";
    }
}


