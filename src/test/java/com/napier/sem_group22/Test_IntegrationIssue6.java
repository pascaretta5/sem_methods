package com.napier.sem_group22;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class Test_IntegrationIssue6 {
    static App app;

    static Issue6 issue6;

    @BeforeAll
    static void init()
    {
        app = new App();
        issue6 = new Issue6();
        app.connect("localhost:33060", 30000);
    }

    @Test
    void getNTopPopCountriesRegionTestNullN()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion(null, app, "Central America");

    }

    @Test
    void getNTopPopCountriesRegionTestNullRegion()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion("2", app, null);

    }

    @Test
    void getNTopPopCountriesRegionTestNullApp()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion("2", null, "Central America");

    }

    @Test
    void getNTopPopCountriesRegionTestNullAllParams()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion(null, null, null);

    }

}
