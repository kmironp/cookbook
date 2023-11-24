package com.example.therealcookbook.CaloryTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/CaloryTable")
@CrossOrigin("http://localhost:3000")
public class CaloryTableController {
    private final CaloryTableService caloryTableService;

    @Autowired
    public CaloryTableController(CaloryTableService caloryTableService) {
        this.caloryTableService = caloryTableService;
    }

    @GetMapping("/listallwithoutcat")
    public List<CaloryTable> AllToTheTable()
    {
        return caloryTableService.allstuff();
    }

    @GetMapping("/listall")
    public List<CaloryTable> ToTheTable(String cat)
    {
        return caloryTableService.ListStuff(cat);
    }
}


