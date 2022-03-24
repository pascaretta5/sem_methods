package com.napier.sem_group22;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class Test_Integration {
    static App app;

    static Issue6 issue6;

    @BeforeAll
    static void init()
    {
        app = new App();
        issue6 = new Issue6();
        app.connect("localhost:33060", 30000);
    }


}
