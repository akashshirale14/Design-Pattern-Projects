# CSX42: Assignment 1
## Name: Akash Shirale

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in coursesRegistration/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile coursesRegistration/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile coursesRegistration/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile coursesRegistration/src/build.xml run -Darg0=<input_file.txt> -Darg1=<delete_file.txt> -Darg2=<output1_file.txt> -Darg3=<output2_file.txt> -Darg4=<output3_file.txt>

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:
Reference Code:https://www.javatpoint.com/java-filewriter-class using in writeToFile method in Results class
Steps to Compile:
 ant -buildfile akash_shirale_assign1/myArrayList/src/build.xml all

Steps to Run:
ant -buildfile akash_shirale_assign1/myArrayList/src/build.xml run -Darg0=input.txt -Darg1=output.txt

Data Structure used:
1)MyArrayList.java:
I have used LinkedList data structure,to store the insertion order of the elements
Time Complexity:The time complexity of the data structure is O(n) when you print the insertion order and when you remove all occurences of an element and is 0(1) when you add element at the end of the linked List.  
Space Complexity:The space complexity of linked list data structure in 0(n) as it stores n elements.

2)Results:

I have used LinkedList data structure,to store the string results.
Time Complexity:The time complexity of the data structure is O(n) when you print the strings for writeToStdout function and 0(1) when you add string at the end of the linked List.
Space Complexity:The space complexity of linked list data structure in 0(n) as it stores n elements.
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 06/19/2019 


