package com.napier.sem_group22;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {
    static App app;

    static Issue1 issue1;
    static Issue2 issue2;
    static Issue3 issue3;
    static Issue4 issue4;
    static Issue5 issue5;
    static Issue6 issue6;
    static Issue7 issue7;
    static Issue17 issue17;
    static Issue18 issue18;
    static Issue19 issue19;
    static Issue20 issue20;
    static Issue21 issue21;
    static Issue24 issue24;
    static Issue25 issue25;
    static Issue26 issue26;
    static Issue28 issue28;
    static Issue29 issue29;
    static Issue30 issue30;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 3000);

        issue1 = new Issue1();
        issue2 = new Issue2();
        issue3 = new Issue3();
        issue4 = new Issue4();
        issue5 = new Issue5();
        issue6 = new Issue6();
        issue7 = new Issue7();
        issue17 = new Issue17();
        issue18 = new Issue18();
        issue19 = new Issue19();
        issue20 = new Issue20();
        issue21 = new Issue21();
        issue24 = new Issue24();
        issue25 = new Issue25();
        issue26 = new Issue26();
        issue28 = new Issue28();
        issue29 = new Issue29();
        issue30 = new Issue30();
    }

    //Issue24
    @Test
    void getIssue24Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "Middle East";
        pop.population = 188380700;
        pop.inCities = 37.355934143066406;
        pop.notinCities = 62.644065856933594;
        pop1.add(pop);

        ArrayList<Population> populations = issue24.getIssue24(app);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
            for (int i = 0; i < pop1.size(); i++) {

                assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue24 1/4 Failed");
                assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue24 2/4 Failed");
                assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue24 3/4 Failed");
                assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue24 4/4 Failed");
            }
        }

    //Issue25
    @Test
    void getIssue25Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "United Kingdom";
        pop.population = 59623400;
        pop.inCities = 37.630645751953125;
        pop.notinCities = 62.369354248046875;
        pop1.add(pop);

        ArrayList<Population> populations = issue25.getIssue25(app);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue25 1/4 Failed");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue25 2/4 Failed");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue25 3/4 Failed");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue25 4/4 Failed");
        }
    }
    }
