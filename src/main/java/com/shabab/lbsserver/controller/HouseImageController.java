package com.shabab.lbsserver.controller;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
public class HouseImageController {



    @RequestMapping(value = "/v1/findAllHouseImage/{houseId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String findImages(@PathVariable("houseId") long houseId) {

            return new Gson().toJson("trytr");


        }

    }




