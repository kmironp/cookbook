package com.example.therealcookbook.CaloryTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaloryTableService {
    private final CaloryTableRepository caloryTableRepository;

    @Autowired
    public CaloryTableService(CaloryTableRepository caloryTableRepository) {
        this.caloryTableRepository = caloryTableRepository;
    }

    public List<CaloryTable> ListStuff(String cat)
    {
        List<CaloryTable> totable = new ArrayList<CaloryTable>();
        List<CaloryTable> c = caloryTableRepository.findAll();

        for(CaloryTable stuff:c)
        {
            if(stuff.getCategory().equals(cat))
                totable.add(stuff);
        }
        return totable;
    }

    public List<CaloryTable> Listallwithoutcat()
    {
        return caloryTableRepository.findAll();

    }

}
