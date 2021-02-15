package com.stackroute.streams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public class CountryTests {

    private static final String MSG_01 = "check the constructor for proper initialization of properties";
    private static final String MSG_02 = "check the setter for proper assignment of property values";

    private Country country;

    @BeforeEach
    public void setUp() {
        country = new Country("IN", "India");
    }

    @AfterEach
    public void tearDown() {
        country = null;
    }

    @Test
    public void givenCountryPropertiesWhenObjectCreatedThenPropertiesAreSet() {
        assertThat(MSG_01, country, hasProperty("countryCode", is("IN")));
        assertThat(MSG_01, country, hasProperty("name", is("India")));
    }

    @Test
    public void givenCountryObjectWhenPropertyValuesModifiedWithSettersThenPropertiesAreSet() {
        country = new Country();
        country.setCountryCode("BR");
        country.setName("Brazil");
        assertThat(MSG_02, country.getCountryCode(), is("BR"));
        assertThat(MSG_02, country.getName(), is("Brazil"));
    }


}