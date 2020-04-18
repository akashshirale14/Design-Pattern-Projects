# CSX42: Assignment 3
## Name: Akash Shirale

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=<input.txt> -Darg1=<delete.txt> -Darg2=<output1.txt>  -Darg3=<output2.txt> -Darg4=<output3.txt> -Darg5=<MyLogger_Value>

Example:

The last argument is the Logger value. 
ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=input.txt -Darg1=delete.txt 
-Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt -Darg5=2



-----------------------------------------------------------------------
## Description:

The Node Class implements SubjectI and ObserverI:
The subject in our program is the original node and which has list of references to it.
The add() method is used to add refernces to the subject.
When the original node changes, the subject(original node) calls the notifAll() method 
so that all its references can know about the change of course(either insertion or deletion)
This design concept is also called as pushing,as when we see change in original node we are pushing change to all its references.
The references are stored in ArrayList called listners_list in original node.
Now the update method performs the corresponding insertion or deletion operation,depending on enum on each of the references of 
the original node.Thus,this is the Observer Pattern.


The Hashmap datastructure is used to store unique value of courses taken by each B_number.
The file input takes place in FileProcessor.java and file output takes place in Results.java

The insertion and seaching of nodes is done as per the implemented Binary Search Tree.

https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/


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

Date: 07/09/19 


