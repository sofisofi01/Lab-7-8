package com.example.lab7_8.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class HelloController {
//@RequestMapping(method = RequestMethod.GET, value = "/test")
    @GetMapping("/hello")
    public String hello(){
        return "hello_world";
    }

    @GetMapping("/goodbye")
    public String goodbye(){return "good_bye";}

    @GetMapping("/testparam")
    public String testparam(HttpServletRequest request)
    {
        String param1 = request.getParameter("name");
        return param1;
    }

    @GetMapping("/testparam1")
    public String testparam1(@RequestParam("name") String paramName, @RequestParam("last_name") String paramLName
    , Model model)
    {
        model.addAttribute("params1", paramName);
        model.addAttribute("params2", paramLName);
        System.out.println("My name is " + paramName+" and last name is " + paramLName);
        return "answer";
        //http://localhost:8080/hello/testparam1?name=Sofi&last_name=Zav
    }
}
