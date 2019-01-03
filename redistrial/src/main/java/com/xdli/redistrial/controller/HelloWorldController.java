package com.xdli.redistrial.controller;

import com.xdli.redistrial.services.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static final Logger logger;

    static {
        logger = LoggerFactory.getLogger(HelloWorldController.class);
    }

    @Autowired
    private RedisService redisService ;

    @RequestMapping("/hello")
    public String index(){
        return "Hello world.";
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public void demoTest(){
        Boolean result = redisService.set("abcd","value22222");
        logger.info("the result is {}", result);
        String valueBack = redisService.get("abcd").toString();
        logger.info("the result got back is {}", valueBack);
    }

}
