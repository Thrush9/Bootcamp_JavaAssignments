package com.stackroute.streams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BatsmanServiceTests {

    private static final String MSG_01 = "existing batsman should be returned in an optional";
    private static final String MSG_02 = "should return empty optional for null or empty inputs";
    private static final String MSG_03 = "should return empty optional for non existing batsman";
    private static final String MSG_04 = "should return a string with batsman name for the given country code in ascending order, separated by comma and enclosed in []";
    private static final String MSG_05 = "should return null for null or empty inputs";
    private static final String MSG_06 = "should return empty map for null or empty inputs";
    private static final String MSG_07 = "should return a map with player name and totalRuns scored, for players who have played more than 50 matches";
    private static final String MSG_08 = "should return the highest runs scored by any batsman for a given country";
    private static final String MSG_09 = "should return zero for null or empty inputs";
    private static final String MSG_10 = "should return a linkedList of player names for a given country who have scored more than 5000 runs, in descending order";
    private static final String MSG_11 = "exception CountryNotFoundException should be thrown";

    private BatsmanService batsmanService;
    private List<Batsman> batsmanList;
    private Batsman batsmanVirat;

    @BeforeEach
    public void setUp() {
        batsmanService = new BatsmanService();
        batsmanVirat = new Batsman("Virat", 55, 6000, 150, new Country("IN", "India"));
        batsmanList = List.of(
                batsmanVirat,
                new Batsman("Dhoni", 110, 8000, 120, new Country("IN", "India")),
                new Batsman("Ponting", 105, 5500, 55, new Country("AU", "Australia")),
                new Batsman("Hayden", 45, 5000, 105, new Country("AU", "Australia")),
                new Batsman("Jonty", 49, 4000, 60, new Country("SA", "SouthAfrica")),
                new Batsman("Duminy", 75, 4500, 125, new Country("SA", "SouthAfrica")),
                new Batsman("Rahul", 25, 3000, 75, new Country("IN", "India"))
        );
    }

    @AfterEach
    public void tearDown() {
        batsmanService = null;
    }

    @Test
    public void givenListOfBatsmanWhenSearchedByBatsmanNameAndCountryCodeIgnoringCaseThenReturnOptionalOfBatsman() {
        assertThat(MSG_01, batsmanService.getBatsman(batsmanList, "virat", "IN"), is(Optional.of(batsmanVirat)));
    }

    @Test
    public void givenListOfBatsmanWhenSearchInputsAreNullOrEmptyThenReturnEmptyOptional() {
        assertThat(MSG_02, batsmanService.getBatsman(null, "virat", "IN"), is(Optional.empty()));
        assertThat(MSG_02, batsmanService.getBatsman(batsmanList, null, null), is(Optional.empty()));
    }

    @Test
    public void givenListOfBatsmanWhenSearchedByNonExistingCountryCodeThenThrowException() {
        assertThrows(CountryNotFoundException.class, () -> batsmanService.getBatsman(batsmanList, "virat", "NZ"), "MSG_11");
    }

    @Test
    public void givenListOfBatsmanWhenSearchedByNonExistingBatsmanNameThenReturnEmptyOptional() {
        assertThat(MSG_03, batsmanService.getBatsman(batsmanList, "test", "IN"), is(Optional.empty()));
    }

    @Test
    public void givenBatsmanListAndCountryCodeThenReturnSortedBatsmanNamesInString() {
        assertThat(MSG_04, batsmanService.getBatsmanNamesForCountry(batsmanList, "IN"), is("[Dhoni,Rahul,Virat]"));
    }

    @Test
    public void givenNullInputsForBatsmanListAndCountryCodeThenReturnNull() {
        assertThat(MSG_05, batsmanService.getBatsmanNamesForCountry(null, "null"), is(nullValue()));
    }

    @Test
    public void givenEmptyBatsmanListThenReturnNull() {
        assertThat(MSG_05, batsmanService.getBatsmanNamesForCountry(Collections.emptyList(), "IN"), is(nullValue()));
    }

    @Test
    public void givenBatsmanListThenReturnMapWithBatsmanNameAndTotalRunsWhoPlayedMoreThan50Matches() {
        assertThat(MSG_07, batsmanService.getPlayerNameWithTotalRuns(batsmanList), allOf(
                hasEntry("Dhoni", 8000),
                hasEntry("Virat", 6000),
                hasEntry("Duminy", 4500),
                hasEntry("Ponting", 5500)
                )
        );
    }

    @Test
    public void givenBatsmanListNullOrEmptyThenReturnEmptyMap() {
        assertThat(MSG_06, batsmanService.getPlayerNameWithTotalRuns(null), is(Collections.emptyMap()));
        assertThat(MSG_06, batsmanService.getPlayerNameWithTotalRuns(Collections.emptyList()), is(Collections.emptyMap()));
    }

    @Test
    public void givenBatsmanListAndCountryNameThenReturnHighestRunsScoredByBatsman() {
        assertThat(MSG_08, batsmanService.getHighestRunsScoredByBatsman(batsmanList, "Australia"), is(105));
    }

    @Test
    public void givenBatsmanListAsNullOrEmptyThenReturnZero() {
        assertThat(MSG_09, batsmanService.getHighestRunsScoredByBatsman(null, "India"), is(0));
        assertThat(MSG_09, batsmanService.getHighestRunsScoredByBatsman(Collections.emptyList(), "India"), is(0));
    }

    @Test
    public void givenBatsmanListAndCountryNameThenReturnPlayerNamesWithTotalRunsMoreThan5000SortedDescendingAsLinkedList() {
        assertThat(MSG_10, batsmanService.getPlayerNamesByCountry(batsmanList, "India"), is(Optional.of(List.of("Virat", "Dhoni"))));
        assertThat(MSG_10, batsmanService.getPlayerNamesByCountry(batsmanList, "India").get(), instanceOf(LinkedList.class));
    }

    @Test
    public void givenBatsmanListAndCountryNameWhenNoBatsmanWithTotalRunsMoreThan5000ThenReturnEmptyOptional() {
        assertThat(MSG_02, batsmanService.getPlayerNamesByCountry(batsmanList, "SouthAfrica"), is(Optional.empty()));
    }

    @Test
    public void givenBatsmanListAndCountryNameWithNullOrEmptyInputsThenReturnEmptyOptional() {
        assertThat(MSG_02, batsmanService.getPlayerNamesByCountry(null, null), is(Optional.empty()));
        assertThat(MSG_02, batsmanService.getPlayerNamesByCountry(Collections.emptyList(), "India"), is(Optional.empty()));
    }
}