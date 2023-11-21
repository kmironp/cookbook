package com.example.therealcookbook.CaloryTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/CaloryTable")
public class CaloryTableController {
    private final CaloryTableService caloryTableService;

    @Autowired
    public CaloryTableController(CaloryTableService caloryTableService) {
        this.caloryTableService = caloryTableService;
    }
}


