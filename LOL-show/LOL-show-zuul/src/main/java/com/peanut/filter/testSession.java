package com.peanut.filter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class testSession {

    @ResponseBody
    @RequestMapping("/zuul/test/session")
    public String testSession(HttpSession session){
        return (String) session.getAttribute("exception");
    }
}
