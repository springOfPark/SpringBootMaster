package me.ktpark.websvc.base.controller;

import me.ktpark.websvc.base.model.Event;
import me.ktpark.websvc.define.Course;
import me.ktpark.websvc.define.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class TestController {

    @PostMapping("/transaction/test/userTest")
    public ResponseEntity<Map<String, Object>> userTest(@RequestBody Map<String, Object> param, HttpServletRequest req) {
        ResponseEntity<Map<String, Object>> mapResponseEntity = new ResponseEntity<>(param, HttpStatus.OK);
        return mapResponseEntity;

    }
    @GetMapping("/test/test")
    public String test(@RequestBody String body) {
        return body;
    }
    @GetMapping("/test/json")
    public Map<String, Object> testJson(@RequestBody Map<String, Object> body) {
        return body;
    }

    @PostMapping("/test/xml")
    public Person testXML(@RequestBody Person body) {
        return body;
    }

    @PostMapping("/test/courseXml")
    public Course testXML(@RequestBody Course body) {
        return body;
    }

    @RequestMapping("/binding/test")
    public Event getEvent(@Validated @ModelAttribute Event event, BindingResult bindingResult) {
        return new Event();
    }

}
