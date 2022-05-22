package com.learing.Springbootpractice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

//@RestController //will be needed for rest-api call (GET/POST)
@Controller
public class ControllerHelloWorld {

    /* using rest-api
    @GetMapping("/") // this GET api method will be called by default from browser
    public String getMessage(){
        return "Welcome to my world of spring boot practice !!";
     */
    @RequestMapping("/welcome")
    public String loginMessage(@RequestParam String userName, ModelMap model){
        //return "Welcome to my world of spring boot practice !! -- From controller";
        model.put("UserName",userName);
        return "welcome";
    }
}
