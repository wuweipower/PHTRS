package edu.scut.controller;


import edu.scut.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    DemoDao demoDao;
    @GetMapping("/hello")
    public String hello()
    {
        return demoDao.findByName("hx").toString();
    }

}

