# CSX42: Assignment 2
## Name: Akash Shirale

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in racingDrivers/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile racingDrivers/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile racingDrivers/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile racingDrivers/src/build.xml run -Darg0=<inputFile.txt> -Darg1=<outputFile.txt> -Darg2=<Logger-Value> 

Example:

ant -buildfile racingDrivers/src/build.xml run -Darg0=inputFile.txt -Darg1=outputFile.txt -Darg2=3



-----------------------------------------------------------------------
## Description:
I have followed the following scenario:
LEADING:Driver.Position<=RoundtoClosestInt(0.3*No.ofDrivers)
HOLDING_ON:RoundtoClosestInt(0.3*No.ofDrivers)<Driver.Position<RoundtoClosestInt(0.7*No.ofDrivers)
LOSING:Driver.Position >=RoundtoClosestInt(0.7*No.ofDrivers)
To store the Driver Position at each state I have mapped them using an Hashmap.

The final states of all the drivers are stored in ArrayList<>()
The writeToFile method helps to write to the file.
I have taken reference code from :https://www.javatpoint.com/java-filewriter-class which is used in writeToFile method.

The meaning of debug values in MyLogger.java:
DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
DEBUG_VALUE=3 [Print to stdout everytime the state is changed]
DEBUG_VALUE=2 [Print to stdout the total distance travelled by each driver till that time according to their initial position]
DEBUG_VALUE=1 [Print to stdout position of driver and its rank in that minute]
DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]

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

Date: 06/26/19 


