package com.example.therealcookbook.CaloryTable;

import org.h2.command.query.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CaloryTableRepository extends JpaRepository<CaloryTable, Integer> {

}
