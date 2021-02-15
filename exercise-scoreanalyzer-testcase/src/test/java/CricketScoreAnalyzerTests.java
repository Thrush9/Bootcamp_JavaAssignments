import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stackroute.collections.CricketScoreAnalyzer;

public class CricketScoreAnalyzerTests {
	
	private static final String MSG_01 = "On Object Instantiation,scorecard should have emplty values";
	private static final String MSG_02 = "return true, if valid batsman data added to scoreCard";
	private static final String MSG_03 = "return false, if invalid batsman data added to scoreCard";
	private static final String MSG_04 = "should show same data,after adding data to scoreCaard";
	private static final String MSG_05 = "should return runs scored, when searched by batsman in scoreCard";
	private static final String MSG_06 = "should return total runs scored in scoreCard";
	private static final String MSG_07 = "should return zero, if no data added in scoreCard";
	private static final String MSG_08 = "should return batsman List in Sorted - Descending Order";
	private static final String MSG_09 = "should return Highest runs scored in scoreCard";
	private static final String MSG_10 = "should return batsman list with Highest runs scored in scoreCard";
	
	private CricketScoreAnalyzer scoreAnalyzer;
	private Map<String, Integer> scoreCard;
	
	@BeforeEach
	public void setUp() {
		scoreCard = new HashMap<>();
		scoreAnalyzer = new CricketScoreAnalyzer();
	}

	@AfterEach
	public void tearDown() {
		scoreAnalyzer = null;
	}

	@Test
	public void givenValidCricketScoreAnalyzer() {
		assertEquals(scoreCard, scoreAnalyzer.getScoreCard(), MSG_01);
	}
	
	@Test
	public void addRunsToCricketScorecardAnalyzerObjectSuccess() {
		boolean output = scoreAnalyzer.addRunsToScoreCard("Dhawan",27);
		assertEquals(true, output, MSG_02);
	}
	
	@Test
	public void addValueToCricketScorecardAnalyzerObjectFailure() {
		boolean output = scoreAnalyzer.addRunsToScoreCard(null,27);
		assertEquals(false, output, MSG_03);
	}
	
	@Test
	public void checkScorecardAfterAddRunstoScoreCard() {
		scoreCard.put("Rohit", 67);
		scoreAnalyzer.addRunsToScoreCard("Rohit", 67);
		assertEquals(scoreCard, scoreAnalyzer.getScoreCard(), MSG_04);
	}
	
	@Test
	public void getRunsScoredByBatsmanFromCricketScorecardAnalyzerObject() {
		Map<String, Integer> scoreList = scoreAnalyzer.getScoreCard();
		scoreList.put("Dhawan",27);
		scoreList.put("Rohit", 67);
		assertEquals(27, scoreAnalyzer.getRunsScored("Dhawan"), MSG_05);
	}
	
	@Test
	public void getTotalRunsFromCricketScorecardAnalyzerObject() {
		Map<String, Integer> scoreList = scoreAnalyzer.getScoreCard();
		scoreList.put("Dhawan",27);
		scoreList.put("Rohit", 67);
		assertEquals(94, scoreAnalyzer.getTotalRuns(), MSG_06);
	}
	
	@Test
	public void getTotalRunsWithNoDataFromCricketScorecardAnalyzerObject() {
		assertEquals(0, scoreAnalyzer.getTotalRuns(), MSG_07);
	}
	
	@Test
	public void getBatsmanListFromCricketScorecardAnalyzerObject() {
		Map<String, Integer> scoreList = scoreAnalyzer.getScoreCard();
		scoreList.put("Dhawan",27);
		scoreList.put("Rohit", 67);
		scoreList.put("Kohli", 67);
		List<String> batsmen = new ArrayList<>();
		batsmen.add("Rohit");
		batsmen.add("Kohli");
		batsmen.add("Dhawan");
		assertEquals(batsmen, scoreAnalyzer.getSortedBatsmanName(), MSG_08);
	}
	
	@Test
	public void getHighestRunsScoredFromCricketScorecardAnalyzerObject() {
		Map<String, Integer> scoreList = scoreAnalyzer.getScoreCard();
		scoreList.put("Dhawan",27);
		scoreList.put("Rohit", 67);
		scoreList.put("Kohli", 77);
		assertEquals(77, scoreAnalyzer.getHighestRunsScored(), MSG_09);
	}
	
	@Test
	public void getBatsmanWithHighestRunsFromCricketScorecardAnalyzerObject() {
		Map<String, Integer> scoreList = scoreAnalyzer.getScoreCard();
		scoreList.put("Dhawan",27);
		scoreList.put("Rohit", 67);
		scoreList.put("Kohli", 67);
		List<String> topScores = new ArrayList<>();
		topScores.add("Rohit");
		topScores.add("Kohli");
		assertEquals(topScores, scoreAnalyzer.getBatsmenNamesWithHighestRuns(), MSG_10);
	}
	
}
