package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A mutable collection of {@link City} objects.
 * <p>
 * Invariants:
 * <ul>
 *   <li>No duplicates (by City.equals).</li>
 *   <li>All public read access returns a defensive copy.</li>
 * </ul>
 */

public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * Creates an empty {@code CityList}.
     */
    public CityList() { }

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Returns whether this list contains the given city.
     * @param city the city to check
     * @return {@code true} if the list contains {@code city}; {@code false} otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes {@code city} if present.
     *
     * @param city the city to remove
     * @throws IllegalArgumentException if the city is not present
     */
    public void delete(City city) {
        boolean removed = cities.remove(city);
        if (!removed) {
            throw new IllegalArgumentException("City not found: " + city);
        }
    }

    /**
     * Returns the number of cities currently in the list.
     * @return the number of cities currently in the list
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> copy = new ArrayList<>(cities);
        Collections.sort(copy);
        return copy;
    }
}
