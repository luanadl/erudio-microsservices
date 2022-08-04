package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.context.MessageSource;

import java.util.Locale;

@RestController
public class HelloWorldController {

//    @RequestMapping(method = RequestMethod.GET, path = "/hello-word")
//    public String helloWorld(){
//        return "Hello World";
//    }

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-word")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    ///hello-world/path-variable/in28minutes
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(
            @RequestHeader(name="Accept-Language", required = false) Locale locale
            ) {
        return messageSource
                .getMessage("good.morning.message", null,"Default Message", locale);


        // EN = Hello World
        // DE = Hallo Welt
        // FR = Salut Monde
    }

}


