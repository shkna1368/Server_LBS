package com.shabab.lbsserver.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.shabab.lbsserver.model.Place;
import com.shabab.lbsserver.model.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Sh-Java on 6/29/2017.
 */
@RestController
public class PlaceController {
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    DataSource dataSource;

    @RequestMapping(value = "/v1/SnaLBS/findNearestPlace/{lat}/{lon}", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String findNearestPlace(@PathVariable("lat") double  lat,@PathVariable("lon") double  lon) {


        JsonObject jsonObject = new JsonObject();


        try {
            //  List<House> recruitments = recruitmentDaoService.findByCompanyId(id);

            List<Place> places = placeRepository.findNearest(lat,lon);


            jsonObject.addProperty("result", true);

            jsonObject.addProperty("action", "findNearestPlace");
            //jsonObject.add("recruitments", recruitments);


            JsonArray result = (JsonArray) new Gson().toJsonTree(places,
                    new TypeToken<List<Place>>() {
                    }.getType());

            jsonObject.add("list", result);


            return new Gson().toJson(jsonObject);

        } catch (Exception ex) {
            System.out.println(ex.toString());
            jsonObject.addProperty("reult", false);
            jsonObject.addProperty("action", "findNearestPlace");
            return new Gson().toJson(jsonObject);


        }
    } @RequestMapping(value = "/v1/SnaLBS/findNearestPlaceByRadious/{lat}/{lon}/{radious}", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String findNearestPlaceByRadious(@PathVariable("lat") double  lat,@PathVariable("lon") double  lon,@PathVariable("radious") double radious) {


        JsonObject jsonObject = new JsonObject();


        try {
            //  List<House> recruitments = recruitmentDaoService.findByCompanyId(id);

            List<Place> places = placeRepository.findNearesInRadious(lat,lon,radious);


            jsonObject.addProperty("result", true);

            jsonObject.addProperty("action", "findNearestPlaceByRadious");
            //jsonObject.add("recruitments", recruitments);


            JsonArray result = (JsonArray) new Gson().toJsonTree(places,
                    new TypeToken<List<Place>>() {
                    }.getType());

            jsonObject.add("list", result);


            return new Gson().toJson(jsonObject);

        } catch (Exception ex) {
            System.out.println(ex.toString());
            jsonObject.addProperty("reult", false);
            jsonObject.addProperty("action", "findNearestPlaceByRadious");
            return new Gson().toJson(jsonObject);


        }
    }
}
