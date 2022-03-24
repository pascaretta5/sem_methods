package com.napier.sem_group22;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_IntegrationIssue21 {

    static App app;
    static Issue21 issue21;

    @BeforeAll
    static void init()
    {
        app = new App();
        issue21 = new Issue21();
        app.connect("localhost:33060", 30000);
    }


    @Test
    void getTopNIssue21Test()
    {
        ArrayList<City> city1 = issue21.getTopNIssue21("1", app, "Asia");
        ArrayList<City> city2 = new ArrayList<>();
        City acity = new City();
        acity.name = "Seoul";
        acity.countryName = "South Korea";
        acity.district = "Seoul";
        acity.population = 9981619;
        city2.add(acity); // add city in ArrayList<City> cities

        for(int i = 0; i < city1.size(); i++ ) {
            assertEquals(city2.get(i).name, city1.get(i).name, "Test getIssue20 1/4 Failed");
            assertEquals(city2.get(i).countryName, city1.get(i).countryName, "Test getIssue20 2/4 Failed");
            assertEquals(city2.get(i).district, city1.get(i).district, "Test getIssue20 3/4 Failed");
            assertEquals(city2.get(i).population, city1.get(i).population, "Test getIssue20 4/4 Failed");
        }
    }

    @Test
    void getTopNIssue21TestNullN()
    {
        ArrayList<City> city1 = issue21.getTopNIssue21(null, app, "Asia");

    }

    @Test
    void getTopNIssue21TestNullArray()
    {
        ArrayList<City> city1 = issue21.getTopNIssue21("2", null, "Asia");

    }

    @Test
    void getTopNIssue21TestNullContinent()
    {
        ArrayList<City> city1 = issue21.getTopNIssue21("2", app, null);

    }

    @Test
    void getTopNIssue21TestNullAllParams()
    {
        ArrayList<City> city1 = issue21.getTopNIssue21(null, null, null);

    }

}
