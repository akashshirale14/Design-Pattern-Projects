# CSX42: Assignment 4
## Name: Akash Shirale

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in multiThreadedHS/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile multiThreadedHS/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile multiThreadedHS/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile multiThreadedHS/src/build.xml run -Dargs="N input1.txt input2.txt output.txt 0"

Example:

The last argument is the Logger value. 
ant -buildfile multiThreadedHS/src/build.xml run -Dargs="2 input1.txt input2.txt output.txt 0"



-----------------------------------------------------------------------
## Description:
Each individual thread reads from file and enters data into ArrayList
The bubble sorting algorithm is used to sort the individual lists.
The time complexity of bubble sort is O(n2)(n square).
Each individual list is then passed to Results class which is then merged with final list
The final list is also a ArrayList.
The final list is sorted using merge sort.
The time complexity for merge sort is O(nlogn).

Reference:
https://www.codexpedia.com/java/java-merge-sort-implementation/


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date:07/22/19


