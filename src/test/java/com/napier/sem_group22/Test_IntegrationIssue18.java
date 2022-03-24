package com.napier.sem_group22;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Test_IntegrationIssue18 {
    static App app;

    static Issue18 issue18;

    @BeforeAll
    static void init()
    {
        /**
         * Initializing connection with the database
         */
        app = new App();
        issue18 = new Issue18();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void getIssue18Test()
    {
        ArrayList<City> cities = issue18.getIssue18(app);

    }
    @Test
    void getIssue18TestNull()
    {
        ArrayList<City> cities = issue18.getIssue18(null);

    }

}
