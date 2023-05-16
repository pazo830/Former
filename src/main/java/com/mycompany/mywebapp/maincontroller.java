package com.mycompany.mywebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class maincontroller {


              @GetMapping("")
     public String showHomePage(){
                  System.out.println("main controller");
    return "index";
}


}
