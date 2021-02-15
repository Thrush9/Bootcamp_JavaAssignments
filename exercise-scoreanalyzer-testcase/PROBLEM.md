## Problem Statement: Writing unit tests for the given solution ##

**This exercise should be completed by writing unit test cases for the solution provided**

- Below is the summary of the solution provided

- class `CricketScoreAnalyzer` 
   - batsman name and runs scored are stored in a HashMap `scorecard`
   - contains below methods for analyzing the runs scored by batsman in a cricket match
        
   
   ```       
   +addRunsToScoreCard(String, int) : boolean     
       -  adds the batsman and runs scored to `scorecard`
   
   +getRunsScored(String) : Integer
       -  returns the runs scored for a given batsman
            
   +getTotalRuns() : int
       - returns the total runs scored by all batsmen
            
   +getSortedBatsmanName() : List<String>
       - returns a list of names of batsmnn from scorecard in descending order   
            
   +getHighestRunsScored() : Integer
       - returns the highest runs scored
        
   +getBatsmenNamesWithHighestRuns() : List<String>
       - returns names of batsmen who scored highest runs    
        
   ``` 
 
-   Create class `CricketScoreAnalyzerTests` in package `com.stackroute.collections` and write the unit tests for testing all methods of `CricketScoreAnalyzer` class
-   Some of the test cases are mentioned below
    - On object creation of `CricketScoreAnalyzer`, an empty scorecard should be created
    - `addRunsToScoreCard` is adding batsman name and runs to scorecard
    - `getRunsScored` is returning the runs scored for a given batsman
    - `getTotalRuns` is returning total runs scored by all batsman
    - `getSortedBatsmanName` is returning a list of all batsman name sorted in descending order
    - `getHighestRunsScored` is returning the highest runs scored from the scorecard
    - `getHighestRunsBatsmenName` is returning a list of batsman who have scored highest runs

- Minimum test cases expected : 10
- Test cases should be written for positive, negative and boundary scenarios, wherever applicable
- Test coverage should be 100%

## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding