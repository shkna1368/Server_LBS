package com.shabab.lbsserver.controller;

import com.google.gson.Gson;

import com.shabab.lbsserver.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by amirsedighi on 10/5/16.
 */

@RestController
public class HelloController {

 /*   @Autowired
    PlaceDaoService repository;
*/
/*    @RequestMapping("/")
    public String index() {
        System.out.println("injaaaaaaaaaaaaHellow");

        return "The first com.course.controller";
    }*/

    @RequestMapping(value = "/v1/msg", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String getFaz() {
        System.out.println("in");

       /* List<Place> list= repository.findNearestPlace(35.321639,46.967017);
        System.out.println(list.get(0).getPlaceName());
        System.out.println(list.get(1).getPlaceName());*/

        return new Gson().toJson("Hellow");


    }

}