package com.napier.sem_group22;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_IntegrationIssue20 {

    static App app;
    static Issue20 issue20;

    @BeforeAll
    static void init()
    {
        app = new App();
        issue20 = new Issue20();
        app.connect("localhost:33060", 30000);
    }


    @Test
    void getTopNIssue20Test()
    {
        ArrayList<City> city1 = issue20.getTopNIssue20("1", app);
        ArrayList<City> city2 = new ArrayList<>();
        City acity = new City();
        acity.name = "Seoul";
        acity.countryName = "South Korea";
        acity.district = "Seoul";
        acity.population = 9981619;
        city2.add(acity); // add country in ArrayList<Country> countries

        for(int i = 0; i < city1.size(); i++ ) {
            assertEquals(city2.get(i).name, city1.get(i).name, "Test getIssue20 1/4 Failed");
            assertEquals(city2.get(i).countryName, city1.get(i).countryName, "Test getIssue20 2/4 Failed");
            assertEquals(city2.get(i).district, city1.get(i).district, "Test getIssue20 3/4 Failed");
            assertEquals(city2.get(i).population, city1.get(i).population, "Test getIssue20 4/4 Failed");
        }
    }

    @Test
    void getTopNIssue20TestNullN()
    {
        ArrayList<City> city1 = issue20.getTopNIssue20(null, app);

    }

    @Test
    void getTopNIssue20TestNullArray()
    {
        ArrayList<City> city1 = issue20.getTopNIssue20("1", null);

    }

    @Test
    void getTopNIssue20TestNullAllParams()
    {
        ArrayList<City> city1 = issue20.getTopNIssue20(null, null);

    }

}
