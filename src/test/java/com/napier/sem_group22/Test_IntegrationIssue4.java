package com.napier.sem_group22;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Test_IntegrationIssue4 {
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

    String N;

    @Test
    void getIssue4Test()
    {
        ArrayList<Country> countries = app.getThreeBiggestCountries(N);

    }
    @Test
    void getIssue4TestNNull()
    {

        ArrayList<Country> countries = app.getThreeBiggestCountries(null);

    }


}
