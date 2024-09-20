package com.java02.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java02.demo.service.ExternalAPIService;

@RestController
@RequestMapping ("api/v1/")
public class ExternalAPIhandler {
    @Autowired
    private ExternalAPIService externalAPIService;

    @GetMapping
    public String getAllData(){
        return externalAPIService.getAllData();
    }

}
