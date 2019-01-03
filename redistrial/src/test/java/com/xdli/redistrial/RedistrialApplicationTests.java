package com.xdli.redistrial;

import com.xdli.redistrial.controller.HelloWorldController;
import com.xdli.redistrial.services.RedisService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedistrialApplicationTests {

    private MockMvc mvc;

    @Autowired
    RedisService redisService;

    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
    }

    @Test
    public void redisSetTest() throws Exception {
        String testKey = "abcd";
        String originalValue = "value2222";
        TestCase.assertTrue(redisService.set(testKey, originalValue));
        String valueBack = redisService.get(testKey).toString();
        System.out.println("The value got back is " + valueBack);
        TestCase.assertEquals(valueBack, originalValue);

    }

}

