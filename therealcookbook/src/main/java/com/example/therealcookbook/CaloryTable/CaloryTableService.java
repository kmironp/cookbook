package com.example.therealcookbook.CaloryTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaloryTableService {
    private final CaloryTableRepository caloryTableRepository;

    @Autowired
    public CaloryTableService(CaloryTableRepository caloryTableRepository) {
        this.caloryTableRepository = caloryTableRepository;
    }
}
