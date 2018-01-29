# cucumber-project

The project is consists of two parts - cucumber-project/src/main/java/part1 and cucumber-project/src/main/java/part2 
to match with the requirements of given requirements.

cucumber-project/src/test/java/ consists of junits 
for part1.

To implement Part1 mostly in Java 8, I have used Bridge design pattern to decouple abstraction from implementation
of service layer. Service layer provides methods to get the details of files in a drectory. The path of directory and 
the mimetype can be configured via properties file.

Part2 is cucumber/selenium based framework which has used design patterns like singleton(DefineDriver.java), Pageobjects 
(one java classes containing webelements for one page) and PageFactory.

The recording to run automation test has been shared via email. The project has been built on mac-os so classpathh issues 
have to be resolved to run on windows machine.
