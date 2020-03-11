package com.example.demo.controller;

import com.example.demo.api.callApi;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static com.example.demo.api.callApi.*;

@Controller
public class getCurrency {

    //@Scheduled(fixedRate = 1000)
    public void methodilogi() throws IOException, JSONException {
        System.out.println("batur methodu çalıştı");
        callApi api = new callApi();
        api.apiCall();
        api.apiData();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) throws IOException, JSONException {

        methodilogi();

        model.addAttribute("usdAlis", usdAlis);
        model.addAttribute("usdSatis", usdSatis);
        model.addAttribute("eurAlis", eurAlis);
        model.addAttribute("eurSatis", eurSatis);
        model.addAttribute("guncelleme", guncellemeSaati);

        return "index";
    }

}
