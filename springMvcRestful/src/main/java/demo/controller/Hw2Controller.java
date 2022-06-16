package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Hw2Controller {

    @GetMapping(value = "/user/getJson/{id}", produces = { "application/json" })
    public String getUserByIdWithJson(@PathVariable("id") int id){
        return "{" +
                "\"head\": [{\n" +
                "\"code\": \"000000\",\n" +
                "\"msg\": \"success\"\n" +
                "}],\n" +
                "\"body\": [{'id':'"+id+"','name':'u"+id+"'}" +
                "}";
    }

    @GetMapping(value = "/user/getXml/{name}",produces = { "application/xml" })
    public String getUserByNameWithXml(@PathVariable("name") String n){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<doc><head><code>000000</code><msg>success</msg></head>" +
                "<users><user id='1' name='"+n+"'/></users></doc>";
    }
}
