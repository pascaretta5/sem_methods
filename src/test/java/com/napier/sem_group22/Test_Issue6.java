package com.napier.sem_group22;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;


public class Test_Issue6 {
    static App app;

    static Issue6 issue6;

    @BeforeAll
    static void init()
    {
        app = new App();
        issue6 = new Issue6();
        app.connect("db:3306", 30000);
    }



    @Test
    void getNTopPopCountriesRegionTest()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion("1", app, "Central America");
        ArrayList<Country> countries2 = new ArrayList<>();
        Country c1 = new Country();
        c1.code = "MEX";
        c1.name = "Mexico";
        c1.continent = "North America";
        c1.region = "Central America";
        c1.population = 98881000;
        c1.capitalName = "Ciudad de México";

        countries2.add(c1);

        for(int i = 0; i < countries1.size(); i++ ) {
            assertEquals(countries2.get(i).code, countries1.get(i).code);
            assertEquals(countries2.get(i).name, countries1.get(i).name);
            assertEquals(countries2.get(i).continent, countries1.get(i).continent);
            assertEquals(countries2.get(i).region, countries1.get(i).region);
            assertEquals(countries2.get(i).population, countries1.get(i).population);
            assertEquals(countries2.get(i).capitalName, countries1.get(i).capitalName);
        }



    }


}
