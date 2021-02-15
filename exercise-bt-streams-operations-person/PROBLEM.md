## Problem Statement: Person names are searched and sorted using streams

**Person names have to be searched and sorted from the given collection of person names and age**

**This exercise contains PersonStreamOperations class with the following methods :**

       +getPersonListSortedByNameInUpperCase(List<String>) : Optional<List<String>>
            -Should return the sorted person list alphabetically in uppercase
            -Should return empty Optional if given personList id empty or null
            
            Sample Input :
            ["Kamala","Priyanka","Gautham","Moses"]
            
            Output:
            ["GAUTHAM","KAMALA","MOSES","PRIYANKA"]
 -------------------------------------------------------------------------------------------     
       +getDistinctPersonNamesSortedInDescendingOrder(List<String>) : Set<String>
            -Should return the distinct sorted person list in descending order
            -Should return empty set if given personList is empty or null
            
            Sample Input:
            ["Kamala","Priyanka","Moses","Kamala","Gautham"]
            
            Output:
            ["Priyanka","Moses","Kamala","Gautham"]
 -------------------------------------------------------------------------------------------
       +searchPerson(List<String>, String) : String        
            -Should search for a person ignoring case in the given list
            -Should return "List or name to search cannot be null" if given personlist or nameToSearch is null or empty
            
            Sample Input:
            ["Kamala","Priyanka","Gautham","Moses"]
            "Gautham"
            
            Output:
            Person found
 ------------------------------------------------------------------------------------------
       +getPersonListSortedByLengthWithNameLengthGreaterThanFive(List<String>) :List<String>           
            -Should filter the list whose name length is greater than five and sorts by name length
            -Should retun empty list if given personList is empty or null
            
            Sample Input:
            ["Kamala","Priyanka","Gautham","Moses"]
            
            Output:
            ["Kamala","Gautham","Priyanka"]
 ------------------------------------------------------------------------------------------          
       +getPersonByMaxAge(Map<String, Integer>) : String
            -Should return the person name having maximum age from the given map 
            -Should return "Give proper input not null" if given map is null or empty
            
            Sample Input:
            {"Gautham"=30,"Latha"=56,""Punith"=45}
            
            Output:
            Latha
 -------------------------------------------------------------------------------------------        
      
   
## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding
