## Problem Statement: Understanding TreeSet and its methods ##

**This exercise should be completed using Test Driven Development Technique**

- Test classes provided in this exercise will show compilation errors, when the exercise is cloned locally
- Classes and methods should be created by analysing the test code, so that there are no compilation errors
- Functionality of methods should be completed, such that all the test cases pass
- Some of the requirements/hints are mentioned below

- In this problem, ISBN number is validated for the following rules:
         
         An ISBN (International Standard Book Number) is a ten digit code which uniquely identifies a book.
         To verify an ISBN you calculate 10 times the first digit, plus 9 times the second digit, plus 8 times the third ..all the way until you add 1 times the last digit.
         If the final number leaves no remainder when divided by 11 the code is a valid ISBN.
               Example :
               Input String : 0201103311
               Calculation : 10*0 + 9*2 + 8*0 + 7*1 + 6*1 + 5*0 + 4*3 + 3*3 + 2*1 + 1*1 = 55.
               55 mod 11 = 0
               Output : 1
               
               Example :
               Input String : 8999
               Output : 0
               
               Example :
               Input String : 
               output : -1
 
  
    
        
   

## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding
