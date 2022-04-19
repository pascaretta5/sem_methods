package com.napier.sem_group22;

public class Population {
    /**
     * Name of a continent/region/country
     */
    public String name;
    /**
     * Population of a continent/region/country
     */
    public long population;
    /**
     * Population of people living in cities, in continent/region/country
     */
    public long CityPop;
    /**
     * Population of people NOT living in cities, in continent/region/country
     */
    public long notINCityPop;
    /**
     * Percentage of people living cities, in continent/region/country
     */
    public double inCities;
    /**
     * Percentage of people NOT living cities, in continent/region/country
     */
    public double notinCities;
}
