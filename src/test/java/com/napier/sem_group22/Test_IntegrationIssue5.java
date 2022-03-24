package com.napier.sem_group22;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Test_IntegrationIssue5 {
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
    int limit = 0;
    String continent;

    @Test
    void getIssue5Test()
    {
        ArrayList<Country> countries = app.getTopCountryByContinentLargeToSmall(continent, limit);

    }
    @Test
    void getIssue5TestContinentNull()
    {

        ArrayList<Country> countries = app.getTopCountryByContinentLargeToSmall(null, limit);

    }
    @Test
    void getIssue5TestAllNull()
    {

        ArrayList<Country> countries = app.getTopCountryByContinentLargeToSmall(null, null);

    }

}
