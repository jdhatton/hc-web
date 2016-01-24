package com.hc.rest;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import com.hc.rest.dto.Account;
import com.hc.rest.dto.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	System.out.println("\n Getting the Greeting! \n");
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public List<Greeting> greetings(@RequestParam(value="name", defaultValue="World") String name) {
    	List<Greeting> results = Lists.newArrayList();
    	results.add(new Greeting(100,String.format(template, name)));
    	results.add(new Greeting(200,String.format(template, name)));
    	results.add(new Greeting(300,String.format(template, name)));
    	results.add(new Greeting(400,String.format(template, name)));
        return results;
    }
   
}
