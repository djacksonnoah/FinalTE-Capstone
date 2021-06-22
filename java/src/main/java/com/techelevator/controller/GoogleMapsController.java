package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping(value="/maps")
public class GoogleMapsController
{
    @Autowired
    private Environment env;

    @RequestMapping(value="/search", method = RequestMethod.GET)
    public ResponseEntity<String> search(@RequestParam String search)
    {
        String places = env.getProperty("google.places.api");
       // String query = "/textsearch/json?inputtype=textquery&input=" + search;
        String query = "/textsearch/json?query=" + search;
        String key = "&key=" + env.getProperty("google.key");

//        String fields = "&fields=" +
//                "formatted_address" +
//                ",name" +
//                ",rating" +
//                ",photos";

        String url = places + query  + key;

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(url, String.class);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
