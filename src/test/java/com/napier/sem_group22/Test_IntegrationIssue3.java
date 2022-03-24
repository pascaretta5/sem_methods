package com.napier.sem_group22;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Test_IntegrationIssue3 {
    static App app;

    @BeforeAll
    static void init()
    {
        /**
         * Initializing connection with the database
         */
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    String region;

    @Test
    void getIssue3Test()
    {
        ArrayList<Country> countries = app.getCountryByRegionLargeToSmall(region);

    }
    @Test
    void getIssue3TestRegionNull()
    {

        ArrayList<Country> countries = app.getCountryByRegionLargeToSmall(null);

    }
    @Test
    void getIssue3TestRegion()
    {

        ArrayList<Country> countries = app.getCountryByRegionLargeToSmall("South America");

    }

}
