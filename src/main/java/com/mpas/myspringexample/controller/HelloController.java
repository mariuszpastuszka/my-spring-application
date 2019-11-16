package com.mpas.myspringexample.controller;

import com.mpas.myspringexample.domain.User;
import com.mpas.myspringexample.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private UserService userService;

    @Autowired
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    ModelAndView myFirstView(ModelAndView modelAndView, @RequestParam(defaultValue = "franek") String name) {

        logger.info("name: {}", name);

        modelAndView.addObject("user", name);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/my-data")
    ModelAndView getMyData(ModelAndView modelAndView,
                           @RequestParam(value = "imie", defaultValue = "mariusz") String name,
                           @RequestParam(defaultValue = "P.") String surname,
                           @RequestParam(defaultValue = "15") int age) {
        return modelAndView;
    }

    @GetMapping("/users")
    ModelAndView readAllUsers(ModelAndView modelAndView) {

        List<User> users = userService.getAllUsers();
        logger.info("users from db [{}]", users);

        modelAndView.addObject("allUsers", users);
        modelAndView.setViewName("hello/users");
        return modelAndView;
    }
}
