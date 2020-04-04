package com.example.graphql.type;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomSortTest {

    @Test
    public void toSort_DirectionASC_shouldSucceed() {
        CustomSort customSort = new CustomSort("testField", CustomDirection.ASC);
        Sort.Order actual = customSort.toSort().getOrderFor("testField");

        assertEquals("testField", actual.getProperty());
        assertEquals(Sort.Direction.ASC, actual.getDirection());
    }

    @Test
    public void toSort_DirectionDESC_shouldSucceed() {
        CustomSort customSort = new CustomSort("testField_desc", CustomDirection.DESC);
        Sort.Order actual = customSort.toSort().getOrderFor("testField_desc");

        assertEquals("testField_desc", actual.getProperty());
        assertEquals(Sort.Direction.DESC, actual.getDirection());
    }

}