package com.luxoftInterview.demo.controller;

import com.luxoftInterview.demo.model.Division;
import com.luxoftInterview.demo.model.DivisionReturnObject;
import com.luxoftInterview.demo.model.ReturnObject;
import com.luxoftInterview.demo.service.DivisionService;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.logging.Logger;

@RestController
public class DivisionController {

    private Logger logger = Logger.getLogger(DivisionController.class.getName());

    private final DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }


    @GetMapping("/getNaceDetails")
    public DivisionReturnObject getNaceDetails(@RequestParam String divisionId) {
        Division division = divisionService.getDivisionById(divisionId);
        if (division == null) {
            return new DivisionReturnObject(404, null);
        }
        return new DivisionReturnObject(200, division);
    }

    @PostMapping("/putNaceDetails")
    public ReturnObject putNaceDetails(@RequestParam String filepath) {
        try {
            divisionService.readDivisionsFromCSV(filepath);
            ReturnObject returnObject = new ReturnObject(200);
            return returnObject;
        } catch (Exception e) {
            ReturnObject returnObject = new ReturnObject(500);
            returnObject.setMessage("Error reading the provided CSV file.");
            return returnObject;
        }
    }

    @PostMapping("/putNaceCSV")
    public ReturnObject putNaceDetailsByFile(@RequestBody File file) {
        try {
            divisionService.readDivisionsFromCSV(file);
            ReturnObject returnObject = new ReturnObject(200);
            return returnObject;
        } catch (Exception e) {
            ReturnObject returnObject = new ReturnObject(500);
            returnObject.setMessage("Error reading the provided file");
            return returnObject;
        }
    }

    @PostMapping("/putNaceObject")
    public ReturnObject putNaceObject(@RequestBody Division division) {
        try {
            divisionService.insertDivisionItem(division);
            ReturnObject returnObject = new ReturnObject(200);
            return returnObject;
        } catch (Exception e) {
            ReturnObject returnObject = new ReturnObject(500);
            returnObject.setMessage("Error adding NACE object to the database");
            return returnObject;
        }
    }
}
