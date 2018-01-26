package com.rekik.demourlparam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Scanner;

@RestController
public class MainController {

    @RequestMapping("/")
    public String home()
    {
        String userName="";
        Scanner reader = new Scanner(System.in);

        userName = reader.nextLine();
        String greeting = "Hello "+userName;
        System.out.println(greeting);

        return  greeting;
    }

    @RequestMapping("/getname")
    public String showWithName(@RequestParam("county") String name, @RequestParam("age") int age){
        return name +" "+ age;
    }

    @RequestMapping("/getothername")
    public String showWithName(HttpServletRequest param)
    {
        String withname = param.getParameter("yourname");
        if(withname==null)
            return "Just Hello";
        else return "Hello "+withname;
    }

    @RequestMapping("/color")
    public String getColor(HttpServletRequest param)
    {
        String color = param.getParameter("color");
        return "My favourite color is "+ color;
    }

}
