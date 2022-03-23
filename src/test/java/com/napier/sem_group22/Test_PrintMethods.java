/**
 * Author : Sara Hussein Celda
 * Date: 22/03/22
 * Test file to test PrintCountries() method from App.java
 */
package com.napier.sem_group22;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Test_PrintMethods {
    static App app;
    static Issue6 issue6;

    @BeforeAll
    static void init()
    {
        app = new App();
        issue6 = new Issue6();
    }

    @Test
    void printCountriesTestNull()
    {
        app.printCountries(null);

    }
    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<>();
        app.printCountries(countries);

    }

    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printCountries(countries);
    }

    @Test
    void printCountries()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Country c = new Country();
        c.code = "NLZ";
        c.name = "New Zealand";
        c.continent = "Oceania";
        c.region = "Australia and New Zealand";
        c.population = 3862000;
        c.capitalName = "Wellington";
        countries.add(c);
        app.printCountries(countries);
    }


}
