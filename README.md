# SimpleEmail

Desktop client for managing email accounts.

[![Build Status](https://travis-ci.org/importTeamName/simpleemail.svg?branch=master)](https://travis-ci.org/importTeamName/simpleemail)


## Building using Eclipse

This project uses maven.

It should already contain the eclipse project files, so you can simply open
project and select the directory containing pom.xml

If that does not work, you can import the project.
File > import > Maven > existing maven project (select directory containing Pom.xml)

### To run

Right click pom.xml in the left sidebar > run as > maven install
The jar file will go to the "target" directory.


## Building on command line using mvn

```
git clone https://github.com/importteamname/simpleemail.git
cd simpleemail
mvn -f "pom.xml" package
mvn exec:java -Dexec.mainClass="com.importteamname.simpleemail.SimpleEmail"
```