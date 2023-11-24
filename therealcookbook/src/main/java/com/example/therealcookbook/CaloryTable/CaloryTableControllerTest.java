package com.example.therealcookbook.CaloryTable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CaloryTableControllerTest {

    @Mock
    private CaloryTableService mockCaloryTableService;

    private CaloryTableController caloryTableControllerUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        caloryTableControllerUnderTest = new CaloryTableController(mockCaloryTableService);
    }

    @Test
    void testToTheTable() {
        // Setup
        final List<CaloryTable> expectedResult = List.of(CaloryTable.builder().build());
        when(mockCaloryTableService.ListStuff("beef")).thenReturn(List.of(CaloryTable.builder().build()));

        // Run the test
        final List<CaloryTable> result = caloryTableControllerUnderTest.ToTheTable("beef");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testToTheTable_CaloryTableServiceReturnsNoItems() {
        // Setup
        when(mockCaloryTableService.ListStuff("beef")).thenReturn(Collections.emptyList());

        // Run the test
        final List<CaloryTable> result = caloryTableControllerUnderTest.ToTheTable("beef");

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }
}
