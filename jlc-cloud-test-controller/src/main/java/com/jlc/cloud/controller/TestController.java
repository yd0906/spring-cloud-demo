package com.jlc.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlc.cloud.feign.ComputerRemote;


@RestController
public class TestController {
	
    @Autowired
    private ComputerRemote computerRemote;
    
    @RequestMapping("/add")
    public String hi(){
    	Integer sum = computerRemote.add(1, 2);
        return sum+"";
    }
}
