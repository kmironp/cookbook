package com.example.therealcookbook.CaloryTable;

import com.example.therealcookbook.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaloryTableService {
    private final CaloryTableRepository caloryTableRepository;

    @Autowired
    public CaloryTableService(CaloryTableRepository caloryTableRepository) {
        this.caloryTableRepository = caloryTableRepository;
    }



}
