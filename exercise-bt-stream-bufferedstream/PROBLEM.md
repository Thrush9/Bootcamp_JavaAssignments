## Problem Statement: Transfer data from one file to another

**Given two file names read the first file and add the content in the second file using bufferedStream and handle exception using throws**

**This exercise contains a class named FileMigration with the following method:**

         +fileContentDuplicator(String, String) : String  
         - Should take two String values as input and return a string as result
         - Should validate the input String by checking whether it is null or empty   
         - Should return an Error String when the file is empty or blank space       
         - Should read data from file of name first String using bufferedInputStream and write in file of name second String using bufferedOutputStream  

## Example
    Sample Input:
    text.txt, testBackup.txt      
    
    Expected Output:
    Hi my name is
--------------------------------------------------------
    Sample Input:
    test , testBackup.txt
        
    Expected Output:
    Throw IOException
--------------------------------------------------------
    Sample Input:
    test.txt , null
        
    Expected Output:
    Given fileName to read or write is empty, null or blank space


## Instructions

- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding