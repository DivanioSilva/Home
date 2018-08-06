package com.ds.home.Focus;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(method = RequestMethod.GET, value = "/api", produces= MediaType.APPLICATION_JSON_VALUE)
    public Response test(){
        Response res = new Response();
        res.setResponse("Pong");
        return res;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api", produces= MediaType.APPLICATION_JSON_VALUE)
    public Response test1(){
        Response res = new Response();
        res.setResponse("PongPost");
        return res;
    }
}
