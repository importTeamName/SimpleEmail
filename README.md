# SimpleEmail

Desktop client for managing email accounts.

[![Build Status](https://travis-ci.org/importTeamName/simpleemail.svg?branch=master)](https://travis-ci.org/importTeamName/simpleemail)

## Quick Install

```
git clone https://github.com/importteamname/simpleemail.git
cd simpleemail
java target/simpleemail-1.0-SNAPSHOT.jar "com.importteamname.simpleemail.SimpleEmail"
```

## Building using Eclipse

### Importing project

This project uses maven.

File > import > Maven > existing maven project (select directory containing Pom.xml)


### Building

Right click pom.xml in the left sidebar > run as > maven install
The jar file will go to the "target" directory.


### Running

From the command line, go to the target/ directory.
```
java -cp simpleemail-1.0-SNAPSHOT.jar "com.importteamname.simpleemail.SimpleEmail"
```


## Building on command line using mvn

```
git clone https://github.com/importteamname/simpleemail.git
cd simpleemail
mvn -f "pom.xml" package
mvn exec:java -Dexec.mainClass="com.importteamname.simpleemail.SimpleEmail"
```