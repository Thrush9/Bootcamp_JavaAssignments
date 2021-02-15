package com.stackroute.streams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BatsmanTests {
    private static final String MSG_01 = "check the constructor for proper initialization of properties";
    private static final String MSG_02 = "check the setter for proper assignment of property values";

    private Batsman batsman;
    private Country country;

    @BeforeEach
    public void setUp() {
        country = new Country("IN", "India");
        batsman = new Batsman("Virat", 55, 6000, 150, country);
    }

    @AfterEach
    public void tearDown() {
        country = null;
        batsman = null;
    }

    @Test
    public void givenBatsmanPropertiesWhenObjectCreatedThenPropertiesAreSet() {
        assertThat(MSG_01, batsman, hasProperty("name", is("Virat")));
        assertThat("MSG_01", batsman, hasProperty("matchesPlayed", is(55)));
        assertThat("MSG_01", batsman, hasProperty("totalRuns", is(6000)));
        assertThat("MSG_01", batsman, hasProperty("highestScore", is(150)));
        assertThat("MSG_01", batsman, hasProperty("country", allOf(notNullValue(), instanceOf(Country.class))));
    }

    @Test
    public void givenBatsmanObjectWhenPropertyValuesModifiedWithSettersThenPropertiesAreSet() {
        batsman = new Batsman();
        batsman.setName("Virat");
        batsman.setMatchesPlayed(55);
        batsman.setTotalRuns(6000);
        batsman.setHighestScore(150);
        batsman.setCountry(country);
        assertThat("MSG_02", batsman.getName(), is("Virat"));
        assertThat("MSG_02", batsman.getMatchesPlayed(), is(55));
        assertThat("MSG_02", batsman.getTotalRuns(), is(6000));
        assertThat("MSG_02", batsman.getHighestScore(), is(150));
        assertThat("MSG_02", batsman.getCountry(), is(notNullValue()));
    }

}