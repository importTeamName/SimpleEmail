# SimpleEmail

Desktop client for managing email accounts.

[![Build Status](https://travis-ci.org/importTeamName/simpleemail.svg?branch=master)](https://travis-ci.org/importTeamName/simpleemail)


##  Requirements

This project used maven and will require the mvn command line tool.


## Building

```
git clone https://github.com/importteamname/simpleemail.git
cd simpleemail
mvn -f "pom.xml" package
mvn exec:java -Dexec.mainClass="com.importteamname.simpleemail.SimpleEmail"
```

