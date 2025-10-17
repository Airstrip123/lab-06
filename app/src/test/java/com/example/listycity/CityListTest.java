package com.example.listycity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {

    private City edmonton() {
        return new City("Edmonton", "Alberta");
    }

    private CityList withEdmonton() {
        CityList list = new CityList();
        list.add(edmonton());
        return list;
    }

    @Test
    void testAdd() {
        CityList list = withEdmonton();
        assertEquals(1, list.countCities());

        City regina = new City("Regina", "Saskatchewan");
        list.add(regina);

        assertEquals(2, list.countCities());
        assertTrue(list.hasCity(regina));
        assertTrue(list.getCities().contains(regina));
    }

    @Test
    void testAddException_onDuplicate() {
        CityList list = withEdmonton();
        assertThrows(IllegalArgumentException.class, () -> list.add(edmonton()));
    }

    @Test
    void testHasCity_trueFalse() {
        CityList list = withEdmonton();
        assertTrue(list.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(list.hasCity(new City("Calgary", "Alberta")));
    }

    @Test
    void testDelete_removesWhenPresent() {
        CityList list = withEdmonton();
        assertTrue(list.hasCity(edmonton()));

        list.delete(new City("Edmonton", "Alberta"));

        assertFalse(list.hasCity(edmonton()));
        assertEquals(0, list.countCities());
    }

    @Test
    void testDelete_throwsWhenAbsent() {
        CityList list = withEdmonton();
        City absent = new City("Calgary", "Alberta");
        assertFalse(list.hasCity(absent));

        assertThrows(IllegalArgumentException.class, () -> list.delete(absent));
    }

    @Test
    void testCountCities() {
        CityList list = new CityList();
        assertEquals(0, list.countCities());
        list.add(new City("Edmonton", "Alberta"));
        list.add(new City("Regina", "Saskatchewan"));
        assertEquals(2, list.countCities());
    }

    @Test
    void testGetCities_sortedCopyNotAlias() {
        CityList list = new CityList();
        City c1 = new City("Charlottetown", "Prince Edward Island");
        City c2 = new City("Edmonton", "Alberta");
        City c3 = new City("Yellowknife", "Northwest Territories");

        list.add(c2);
        list.add(c3);
        list.add(c1);

        List<City> sorted = list.getCities();
        // sorted by name, then province
        assertEquals(c1, sorted.get(0));
        assertEquals(c2, sorted.get(1));
        assertEquals(c3, sorted.get(2));

        // ensure it's a defensive copy (mutations here don't affect internal state)
        sorted.clear();
        assertEquals(3, list.countCities());
    }
}
