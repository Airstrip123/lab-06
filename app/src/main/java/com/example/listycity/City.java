package com.example.listycity;


import java.util.Objects;

/**
 * Represents a City with a name and its province/state.
 * <p>
 * Equality is defined by both city name and province.
 * Natural ordering sorts by city name, then province.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

   /**
    * Constructs a {@code City}.
    *
    * @param city     the city name (non-null)
    * @param province the province/state name (non-null)
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * @return the city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * @return the province/state name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Natural ordering: by city name, then province.
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
    /**
     * Two cities are equal iff both city name and province match.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;
        City other = (City) obj;
        return Objects.equals(this.city, other.city)
                && Objects.equals(this.province, other.province);
    }

    /**
     * Hash code consistent with {@link #equals(Object)}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

    @Override
    public String toString() {
        return city + ", " + province;
    }
}