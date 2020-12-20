package com.example.SpringBeginner.controller;

import com.example.SpringBeginner.model.student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/demo")
public class domoController {
    @GetMapping("hello-world")
    public  String helloWorld(){
        return "hello world";
    }
    @GetMapping("/demo-return-ints")
    public  int demoReturn(){
        return 1;
    }
    @GetMapping("/demo-get-student")
    public student getStudent(){
        student s = new student("quang",19);
        return s;
    }
    @GetMapping("/demo-api-with-param")
    public String demoApiWithParam(@RequestParam String param,String id){
        return "Param ban truyen vao la: " + param + " " + id ;
    }
    @GetMapping("demo-hash-map")
    public HashMap<String,Object> demoHashMap(){
        HashMap<String,Object> returnValuse = new HashMap<>();
        returnValuse.put("quang","hien");
        returnValuse.put("quang1",22);
        returnValuse.put("quang2",true);
        return  returnValuse;

    }
}
