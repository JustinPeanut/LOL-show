package com.peanut.controller;

import com.peanut.api.MySqlRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Peanut
 */

@Controller
public class TestFeign {
    @Autowired
    private MySqlRemoteService mySqlRemoteService;


    @ResponseBody
    @RequestMapping("test")
    public String testHello(){
        return  mySqlRemoteService.testHello();
    }

}
