package cat.itacademy.s04.t01.n02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/HelloWorld")
    public String hello(@RequestParam(name = "name", defaultValue = "UNKNOWN") String name) {
        return "Hello, " + name + ". You're running a Gradle project.";
    }

    @GetMapping(value = {"/HelloWorld2", "/HelloWorld2/{name}"})
    public String hello2(@PathVariable(required = false) String name) {
        if (name == null) {
            return "Hello. You're running a Gradle project.";
        } else {
            return "Hello, " + name + ". You're running a Gradle project.";
        }
    }
}