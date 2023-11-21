package com.example.therealcookbook.CaloryTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaloryTableRepository extends JpaRepository<CaloryTable, Integer> {
}
