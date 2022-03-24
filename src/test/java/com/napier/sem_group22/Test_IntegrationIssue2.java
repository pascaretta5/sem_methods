package com.napier.sem_group22;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Test_IntegrationIssue2 {
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

    @Test
    void getIssue2Test()
    {
        ArrayList<Country> countries = app.getCountryByContinentLargeToSmall(app);

    }
    @Test
    void getIssue2TestNull()
    {
        ArrayList<Country> countries = app.getCountryByContinentLargeToSmall(null);

    }

}
